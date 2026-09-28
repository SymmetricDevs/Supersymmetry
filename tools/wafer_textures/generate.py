#!/usr/bin/env python3
"""Procedural 16x16 textures for the wafer-processing metaitems.

Each wafer item is rendered from the recipe that produces it, not from its name: dump_recipes.sh runs
the pack's groovy against stubs and records every recipe along with the Lithography/Etching/Deposition
helper call that made it. This script walks each item's producer chain back to its bare wafer and
replays it on a per-pixel stack of material layers:

  * lithography coats a resist film, exposes a latent image through a die pattern, and develops it away;
    the pattern shape is picked from what the opened area is used for next (well implant, trench,
    gate, contact, metal line, bump pad, ...)
  * etches remove the top layer only where that layer is the etched material, so resist protects
  * depositions stack films; transparent dielectrics show thin-film interference colours from their
    summed recipe thickness, the way real oxide/nitride films look on silicon
  * implants tint the semiconductor underneath (n = cyan/green, p = magenta) and crust exposed resist
  * CMP re-planarises back to the pre-fill surface, leaving the fill inlaid in recesses
  * anneals activate/diffuse dopants and form silicides; backgrinding flips to the ground backside

Usage:
  tools/wafer_textures/dump_recipes.sh
  python3 tools/wafer_textures/generate.py [--recipes build/recipes.json] [--all] [--preview out.png]

By default only wafer textures listed in resources/susy/texturestodo.txt are written.
"""
import argparse
import collections
import colorsys
import hashlib
import json
import math
import os
import sys

from PIL import Image

HERE = os.path.dirname(os.path.abspath(__file__))
REPO = os.path.abspath(os.path.join(HERE, '..', '..'))
TEX_ROOT = os.path.join(REPO, 'resources', 'gregtech', 'textures', 'items')
TODO = os.path.join(REPO, 'resources', 'susy', 'texturestodo.txt')

SIZE = 16
PERIOD = 5  # 4px dies with a 1px scribe street; streets on 0, 5, 10, 15 keep the grid centred


def h32(*parts):
    return int.from_bytes(hashlib.md5('|'.join(map(str, parts)).encode()).digest()[:4], 'little')


# --------------------------------------------------------------------------------------------------
# Materials
# kind: 'semi' (opaque semiconductor, takes dopant tint), 'metal' (opaque, specular),
#       'film' (transparent dielectric, interference colour), 'resist' (tinted translucent organic),
#       'opaque' (dull opaque)
# n is the optical weight a film contributes per unit of recipe thickness.
# --------------------------------------------------------------------------------------------------
MAT = {
    'si':       dict(kind='semi', rgb=(92, 97, 112)),
    'poly':     dict(kind='semi', rgb=(128, 118, 110)),
    'epi':      dict(kind='semi', rgb=(100, 102, 114)),
    'sige':     dict(kind='semi', rgb=(118, 108, 96)),
    'gaas':     dict(kind='semi', rgb=(88, 92, 70)),
    'ge':       dict(kind='semi', rgb=(118, 118, 124)),
    'quartz':   dict(kind='opaque', rgb=(214, 216, 222)),
    'sio2':     dict(kind='film', n=1.0),
    'si3n4':    dict(kind='film', n=1.6),
    'bpsg':     dict(kind='film', n=1.0),
    'psg':      dict(kind='film', n=1.0),
    'bsg':      dict(kind='film', n=1.0),
    'sioch':    dict(kind='film', n=0.9),
    'hfo2':     dict(kind='film', n=2.0),
    'sion':     dict(kind='film', n=1.4),
    'al':       dict(kind='metal', rgb=(196, 200, 208)),
    'cu':       dict(kind='metal', rgb=(196, 112, 70)),
    'cu_ecp':   dict(kind='metal', rgb=(186, 104, 66), matte=True),
    'w':        dict(kind='metal', rgb=(136, 142, 154)),
    'tin':      dict(kind='metal', rgb=(196, 160, 72)),
    'tial':     dict(kind='metal', rgb=(164, 166, 178)),
    'ta':       dict(kind='metal', rgb=(132, 128, 140)),
    'tan':      dict(kind='metal', rgb=(150, 126, 96)),
    'ti':       dict(kind='metal', rgb=(158, 160, 166)),
    'ni':       dict(kind='metal', rgb=(162, 158, 144)),
    'pt':       dict(kind='metal', rgb=(190, 190, 194)),
    'co':       dict(kind='metal', rgb=(146, 152, 170)),
    'cr':       dict(kind='metal', rgb=(170, 176, 192)),
    'ag':       dict(kind='metal', rgb=(218, 218, 224)),
    'au':       dict(kind='metal', rgb=(222, 180, 64)),
    'ausb':     dict(kind='metal', rgb=(206, 170, 86)),
    'solder':   dict(kind='metal', rgb=(186, 188, 190), matte=True),
    'bump':     dict(kind='metal', rgb=(204, 206, 210)),
    'ni2si':    dict(kind='opaque', rgb=(104, 98, 104)),
    'nisi':     dict(kind='opaque', rgb=(82, 80, 92)),
    'co2si':    dict(kind='opaque', rgb=(98, 100, 114)),
    'cosi2':    dict(kind='opaque', rgb=(74, 80, 100)),
    'soc':      dict(kind='opaque', rgb=(34, 30, 36)),
    'alumina':  dict(kind='opaque', rgb=(226, 224, 214)),
    'batio3':   dict(kind='opaque', rgb=(212, 198, 168)),
    'cu_paste': dict(kind='opaque', rgb=(164, 112, 84)),
    'cu_fired': dict(kind='metal', rgb=(178, 114, 76), matte=True),
    'rink':     dict(kind='opaque', rgb=(70, 68, 72)),
    'rfired':   dict(kind='opaque', rgb=(44, 44, 50)),
    'kerf':     dict(kind='opaque', rgb=(120, 96, 78)),
    'glass_paste': dict(kind='opaque', rgb=(160, 186, 160)),
    'glass':    dict(kind='resist', rgb=(70, 150, 100), a=0.62),
    'nicr':     dict(kind='metal', rgb=(150, 150, 158)),
    'mandrel':  dict(kind='semi', rgb=(128, 118, 110)),
    'novolac':  dict(kind='resist', rgb=(168, 40, 52), a=0.78),
    'phs':      dict(kind='resist', rgb=(220, 176, 52), a=0.66),
    'pmma':     dict(kind='resist', rgb=(176, 120, 196), a=0.58),
    'su8':      dict(kind='resist', rgb=(214, 206, 150), a=0.55),
    'hsq':      dict(kind='resist', rgb=(170, 214, 230), a=0.5),
}
RESISTS = {'novolac', 'phs', 'pmma', 'su8', 'hsq'}
SEMIS = {k for k, v in MAT.items() if v['kind'] == 'semi'}
CONDUCTORS = {k for k, v in MAT.items() if v['kind'] == 'metal'} | {'nisi', 'ni2si', 'cosi2', 'co2si'}

RESIST_FLUIDS = {
    'novolac_resist': 'novolac', 'novolac_liftoff_resist': 'novolac', 'su_eight': 'su8',
    'polyhydroxystyrene_resist': 'phs', 'methacrylate_resist': 'pmma',
    'hydrogen_silsesquioxane_photoresist': 'hsq',
}

# recipe material name -> (layer token, is dielectric film)
DEPOSIT = {
    'silicon_dioxide': 'sio2', 'silicon_dioxide.silane': 'sio2', 'silicon_dioxide.teos': 'sio2',
    'silicon_nitride': 'si3n4', 'silicon_nitride.silane': 'si3n4',
    'borophosphosilicate_glass': 'bpsg', 'phosphosilicate_glass': 'psg',
    'silicon_oxycarbide_hydride': 'sioch', 'silicon_oxynitride': 'sion', 'hafnium_dioxide': 'hfo2',
    'silicon': 'poly', 'p_doped_silicon': 'epi', 'n_doped_silicon': 'epi', 'silicon_germanium': 'sige',
    'titanium_nitride': 'tin', 'titanium_aluminide': 'tial', 'tungsten': 'w',
    'aluminium': 'al', 'copper': 'cu', 'tantalum': 'ta', 'tantalum_nitride': 'tan', 'titanium': 'ti',
    'nickel': 'ni', 'platinum': 'pt', 'cobalt': 'co', 'chromium': 'cr', 'silver': 'ag', 'gold': 'au',
    'gold_antimony': 'ausb', 'nichrome': 'nicr',
}
EPI_DOPING = {'p_doped_silicon': 'p', 'n_doped_silicon': 'n'}

ETCH = {
    'silicon_nitride': {'si3n4'},
    'silicon_dioxide': {'sio2', 'psg', 'bsg', 'bpsg'},
    'silicon': {'poly', 'si', 'epi', 'sige', 'mandrel'},
    'silicon_bosch': {'poly', 'si', 'epi', 'mandrel'},
    'borophosphosilicate_glass': {'bpsg'},
    'hafnium_dioxide': {'hfo2'},
    'silicon_oxycarbide_hydride': {'sioch'},
    'silicon_oxynitride': {'sion'},
    'spin_on_carbon': {'soc'} | RESISTS,
    'aluminium': {'al'},
    'titanium_nitride': {'tin'},
    'nickel_silicide': {'ni', 'pt'},   # strips the unreacted metal, silicide stays
    'cobalt_silicide': {'co'},
    'platinum': {'pt'},
    'phosphosilicate_glass': {'psg'},
    'nichrome': {'nicr'},
    'gallium_arsenide': {'gaas'},
    'copper': {'cu', 'cu_ecp'},
    'chromium': {'cr'},
    'titanium': {'ti'},
    'tungsten': {'w'},
    'gold': {'au'},
}

DOPANT_TYPE = {'boron_trifluoride': 'p', 'boron': 'p', 'phosphine': 'n', 'phosphorus': 'n',
               'arsine': 'n', 'purified_antimony_trioxide': 'n'}


# --------------------------------------------------------------------------------------------------
# Die patterns: 4x4 masks in die coordinates, 1 = opened by development (positive resist)
# --------------------------------------------------------------------------------------------------
def mask_from(cells):
    return frozenset(cells)


def rect(x0, y0, x1, y1):
    return mask_from((x, y) for x in range(x0, x1 + 1) for y in range(y0, y1 + 1))


ALL = rect(0, 0, 3, 3)
PATTERNS = {
    'left': rect(0, 0, 1, 3),
    'right': rect(2, 0, 3, 3),
    'left_inner': rect(0, 1, 1, 2),
    'right_inner': rect(2, 1, 3, 2),
    'left_col': rect(0, 0, 0, 3),
    'right_col': rect(3, 0, 3, 3),
    'ring': ALL - rect(1, 1, 2, 2),
    'center': rect(1, 1, 2, 2),
    'gate': ALL - rect(1, 0, 1, 3) - rect(3, 0, 3, 3),     # keeps two gate lines at x=1, x=3
    'contact': mask_from([(0, 1), (0, 2), (2, 1), (2, 2)]),
    'metal_h': rect(0, 0, 3, 0) | rect(0, 2, 3, 2),
    'metal_v': rect(0, 0, 0, 3) | rect(2, 0, 2, 3),
    'metal_h2': rect(0, 1, 3, 1) | rect(0, 3, 3, 3),
    'metal_v2': rect(1, 0, 1, 3) | rect(3, 0, 3, 3),
    'wiring': rect(0, 1, 2, 2),                             # Al stays as a bracket around the die
    'top': rect(0, 0, 3, 1),
    'bottom': rect(0, 2, 3, 3),
    'dots': mask_from([(0, 0), (3, 0), (0, 3), (3, 3)]),
    'cross': rect(1, 0, 2, 3) | rect(0, 1, 3, 2),
    'full': ALL,
    'pads': rect(0, 0, 0, 3) | rect(3, 0, 3, 3),            # chip-resistor terminations
    'res_body': rect(0, 1, 3, 2),
    'res_film': rect(0, 0, 3, 0) | rect(0, 3, 3, 3),        # NiCr removed around the resistor strip
    'overglaze': rect(1, 0, 2, 3),
    'trim': mask_from([(1, 1), (2, 1)]),
}
GENERIC = ['center', 'left', 'right', 'top', 'bottom', 'cross', 'dots']
IMPLANT_VARIANTS = {'p': ['left', 'left_inner', 'left_col', 'center'],
                    'n': ['right', 'right_inner', 'right_col', 'center']}


def T(name, th=1.0, n=0.0, p=0.0):
    """A layer in a pixel's stack: material, thickness, and the n/p dopant it carries."""
    return (name, th, n, p)


def die_coord(x, y):
    if x % PERIOD == 0 or y % PERIOD == 0:
        return None
    return (x % PERIOD - 1, y % PERIOD - 1)


# --------------------------------------------------------------------------------------------------
# Recipe graph -> process operations
# --------------------------------------------------------------------------------------------------
def names(lst, prefix):
    return [s.split(':', 1)[1] for s in lst if s.startswith(prefix + ':')]


def ctx_last(r, *methods):
    # the harness pushes onto the front, so the innermost helper call comes first
    for c in (r.get('ctx') or []):
        if not methods or c[1] in methods:
            return c
    return None


def wafer_input(r):
    for i in names(r['inputs'], 'metaitem'):
        if is_waferish(i):
            return i
    ins = names(r['inputs'], 'metaitem')
    return ins[0] if ins else None


def is_waferish(i):
    return i.startswith('wafer.') or i.startswith('boule.') or ('.wafer' in i and i.startswith('component.'))


def describe(r, out):
    """Turn one recorded recipe into (op, params)."""
    m = r['map']
    fl = names(r['fluidInputs'], 'fluid')
    ins = names(r['inputs'], 'metaitem') + names(r['inputs'], 'ore')
    c = ctx_last(r)
    meth = c[1] if c else None
    args = c[2] if c else []

    if out.endswith('.hardmasked'):
        return ('push', dict(tokens=[T('soc')]))
    if out.endswith('.mandrel'):
        return ('push', dict(tokens=[T('mandrel')]))
    if m == 'resist_processing':
        if out.endswith('.coated'):
            resist = next((RESIST_FLUIDS[f] for f in fl if f in RESIST_FLUIDS), 'novolac')
            return ('coat', dict(resist=resist))
        src = wafer_input(r) or ''
        if src.endswith('.exposed') or src.endswith('.deposited'):
            return ('develop', dict(liftoff=src.endswith('.deposited')))
        if 'ultrapure_hydrofluoric_acid' in fl:
            return ('etch', dict(material='silicon_oxynitride', wet=True))
        if src.endswith('.ashed'):
            return ('rinse', {})
        return ('strip', dict(residue=False))
    if m in ('uv_light_box', 'laser_engraver', 'electron_beam_lithography') and (wafer_input(r) or '').endswith('.coated'):
        return ('expose', dict(tool=m))
    if m == 'plasma_ashing':
        if meth == 'generateSOCStrippingRecipes':
            return ('soc_ash', {})
        return ('strip', dict(residue=out.endswith('.ashed')))
    if m in ('reactive_ion_etching', 'chemical_bath') and meth in ('generateReactiveIonEtchingRecipe', 'generateWetEtchingRecipe'):
        return ('etch', dict(material=args[2], wet=m == 'chemical_bath'))
    if m == 'chemical_bath' and meth is None:
        return ('clean', {})
    if m == 'chemical_bath' and meth == 'generateBoronDiffusionDopingRecipes':
        return ('etch', dict(material='silicon_dioxide', wet=True))
    if m in ('cvd', 'atomic_layer_deposition') and meth in ('generateChemicalVaporDepositionRecipe', 'generateAtomicLayerDepositionRecipe'):
        mat = args[3]
        thick = float(args[2])
        if thick > 50:      # packaging passivation uses a duration-scaled number
            thick = 2.0
        if m == 'atomic_layer_deposition':
            thick = max(thick, 0.3)
        return ('deposit', dict(material=mat, thickness=thick))
    if m == 'tube_furnace' and meth == 'generateSiliconDioxideGrowthRecipe':
        return ('oxidize', dict(wet=bool(args[3])))
    if m == 'tube_furnace' and meth in ('generateBoronDiffusionDopingRecipes', 'generatePhosphorusDiffusionDopingRecipes'):
        return ('diffuse', dict(type='p' if 'Boron' in meth else 'n'))
    if m == 'ion_implantation':
        src = args[3] if meth == 'generateIonImplantationRecipes' else (fl[0] if fl else 'phosphine')
        return ('implant', dict(type=DOPANT_TYPE.get(src, 'n'), source=src))
    if m == 'sputter_deposition' or m == 'evaporation_deposition':
        if meth == 'generateSputteringRecipe' and isinstance(args[2], dict):
            # sequential stacks (Ta/Cu, Ti/Ni/Ag) vs alloy targets (Al-1%Si, Al-0.5%Cu): drop minor constituents
            mats = list(args[2].items())
            total = sum(float(v) for _, v in mats)
            mats = [(k, v) for k, v in mats if float(v) >= 0.05 * total]
            if {k for k, _ in mats} == {'chromium', 'nickel'}:
                mats = [('nichrome', total)]
        elif meth in ('generateSputteringRecipe', 'generateEvaporationRecipe'):
            mats = [(args[3], args[2])]
        else:
            mats = [('aluminium', 100)]
        return ('metal', dict(materials=[mm for mm, _ in mats]))
    if m == 'electrolytic_cell':
        if any('Solder' in i for i in ins):
            return ('plate', dict(token='solder'))
        return ('plate', dict(token='cu_ecp'))
    if m == 'polishing_machine':
        if meth == 'generateBackgrindingRecipe':
            return ('backgrind', {})
        if meth == 'generateChemicalMechanicalPolishingRecipe':
            return ('cmp', {})
        return ('polish', {})
    if m == 'resistance_furnace':
        if meth == 'generateDriveInRecipe':
            return ('drive_in', {})
        if meth == 'generateSinteringRecipe':
            return ('anneal', dict(tier=args[3]))
        if any('Aluminium' in i for i in ins):
            return ('alloy', dict(material='al'))
        return ('anneal', dict(tier=2))
    if m == 'screen_printer':
        nc = ''.join(r['notConsumable'])
        if 'resistor_pads' in nc:
            return ('print', dict(token='cu_paste', pattern='pads'))
        if any('Glass' in i for i in ins):
            return ('print', dict(token='glass_paste', pattern='overglaze'))
        return ('print', dict(token='rink', pattern='res_body'))
    if m == 'sintering_oven':
        return ('fire', {})
    if m == 'laser_engraver' and meth is None:
        return ('trim', {})
    if m == 'cutter':
        return ('slice', dict(source=(names(r['inputs'], 'metaitem') + names(r['inputs'], 'ore') + [''])[0]))
    if m == 'lathe':
        return ('tune', {})
    return ('noop', dict(map=m, meth=meth))


class Graph:
    def __init__(self, recipes):
        self.producers = collections.defaultdict(list)
        self.consumers = collections.defaultdict(list)
        for r in recipes:
            for o in names(r['outputs'], 'metaitem'):
                self.producers[o].append(r)
            for i in names(r['inputs'], 'metaitem'):
                for o in names(r['outputs'], 'metaitem'):
                    self.consumers[i].append((r, o))
        self.aliases = {}
        self.virtual = {}

    def producer(self, item):
        rs = self.producers.get(item)
        if not rs:
            return None
        # Prefer the plasma strip over the NMP alternative, dry over wet when both exist
        def rank(r):
            return (r['map'] == 'resist_processing' and 'n_methyl_two_pyrrolidone' in ''.join(r['fluidInputs']),
                    r['map'] == 'chemical_bath')
        return sorted(rs, key=rank)[0]

    def step(self, item):
        """(input item, op, params) for the step producing `item`, or None for a root."""
        if item in self.virtual:
            return self.virtual[item]
        r = self.producer(item)
        if r is None:
            return None
        op, params = describe(r, item)
        src = wafer_input(r)
        if op == 'slice' or src is None or not is_waferish(src):
            return (None, op, dict(params, item=item, source=src))
        return (src, op, params)

    def next_ops(self, item, limit=10):
        """Ops that follow `item` down its chain, used to decide what a litho pattern is for."""
        ops = []
        cur = item
        for _ in range(limit):
            nxt = [(r, o) for r, o in self.consumers.get(cur, []) if is_waferish(o)]
            if not nxt:
                break
            r, o = nxt[0]
            op, params = describe(r, o)
            ops.append((op, params, o))
            if op in ('strip', 'soc_ash'):
                break
            cur = o
        return ops


# --------------------------------------------------------------------------------------------------
# Wafer state
# --------------------------------------------------------------------------------------------------
class State:
    def __init__(self, substrate='si', doping=None, small=False, square=False):
        self.small = small
        self.square = square
        self.pixels = [(x, y) for y in range(SIZE) for x in range(SIZE) if in_shape(x, y, small, square)]
        n0 = doping[1] if doping and doping[0] == 'n' else 0.0
        p0 = doping[1] if doping and doping[0] == 'p' else 0.0
        self.stack = {p: [T(substrate, 1.0, n0, p0)] * 3 for p in self.pixels}
        self.fresh = set()          # pixels with unannealed implant damage
        self.latent = None          # exposed-but-undeveloped mask (set of pixels)
        self.crust = set()          # implant-hardened resist
        self.residue = set()
        self.snapshot = None        # stacks before the current fill, for CMP
        self.finish = 'gloss'       # gloss | matte | raw | ground
        self.back = False
        self.back_stack = None
        self.implants = collections.Counter()
        self.metal_layers = 0
        self.special = None

    def copy(self):
        s = State.__new__(State)
        s.__dict__.update(self.__dict__)
        s.stack = {p: list(v) for p, v in self.stack.items()}
        s.fresh = set(self.fresh)
        s.crust = set(self.crust)
        s.residue = set(self.residue)
        s.latent = set(self.latent) if self.latent is not None else None
        s.snapshot = {p: list(v) for p, v in self.snapshot.items()} if self.snapshot else None
        s.back_stack = {p: list(v) for p, v in self.back_stack.items()} if self.back_stack else None
        s.implants = collections.Counter(self.implants)
        return s

    def top(self, p):
        return self.stack[p][-1][0]

    def has_mask_layer(self, p):
        return any(t[0] in RESISTS or t[0] == 'soc' for t in self.stack[p][3:])


def in_shape(x, y, small=False, square=False):
    if square:
        return 1 <= x <= 14 and 1 <= y <= 14
    return in_disc(x, y, small)


def in_disc(x, y, small=False):
    r = 5.6 if small else 7.55
    return (x - 7.5) ** 2 + (y - 7.5) ** 2 <= r * r


def pattern_for(graph, state, item, product_after_develop):
    """Choose which die pattern a lithography step exposes, from what the opened area is used for."""
    ops = graph.next_ops(product_after_develop)
    seed = h32(item)
    if 'photovoltaic' in item:
        return 'metal_h'     # front-contact fingers
    kinds = []
    etched = []
    for op, params, o in ops:
        if op == 'implant':
            t = params['type']
            variants = IMPLANT_VARIANTS[t]
            return variants[state.implants[t] % len(variants)]
        if op == 'etch':
            m = params['material']
            if m in ('silicon_oxynitride', 'spin_on_carbon'):
                continue
            etched.append(m)
        if op == 'plate':
            return 'center'
        if op == 'metal':
            kinds.append('metal')
    if '.pkg.' in item:
        return 'center' if not etched else 'dots'
    if 'silicon_bosch' in etched:
        return 'ring'
    if 'silicon_oxycarbide_hydride' in etched:
        layer = state.metal_layers
        return ['metal_h', 'metal_v', 'metal_h2', 'metal_v2'][layer % 4]
    if 'borophosphosilicate_glass' in etched:
        return 'contact'
    if 'aluminium' in etched:
        return 'wiring'
    if 'nichrome' in etched:
        return 'res_film'
    if 'silicon' in etched:
        poly = sum(1 for p in state.pixels if any(t[0] == 'poly' for t in state.stack[p][3:]))
        if poly > 0.5 * len(state.pixels):
            return 'gate'
        return 'ring'
    if 'titanium_nitride' in etched or 'hafnium_dioxide' in etched:
        return 'right'
    if 'silicon_nitride' in etched and 'silicon_dioxide' not in etched:
        return 'right' if state.implants else 'center'
    if etched:
        return ['center', 'left', 'right', 'center'][seed % 4] if state.implants else 'center'
    if 'metal' in kinds:
        return 'center'
    return GENERIC[seed % len(GENERIC)]


def mask_pixels(state, pattern):
    cells = PATTERNS[pattern]
    return {p for p in state.pixels if die_coord(*p) in cells}


def apply(graph, state, item, op, params):
    s = state.copy()
    s.special = None
    if s.back and op not in ('metal', 'anneal', 'plate', 'polish', 'clean'):
        s.back = False
    stack = s.back_stack if s.back else s.stack

    if op == 'coat':
        for p in s.pixels:
            s.stack[p].append(T(params['resist']))
        s.finish = 'gloss'
    elif op == 'push':
        for p in s.pixels:
            s.stack[p].append(params['tokens'][0])
    elif op == 'expose':
        base = item[:-len('.exposed')] if item.endswith('.exposed') else item
        product = None
        for r, o in graph.consumers.get(item, []):
            product = o
        # liftoff: exposed -> deposited -> develop
        if product and product.endswith('.deposited'):
            pat = 'center'
        else:
            pat = pattern_for(graph, s, base, product or item)
        s.latent = mask_pixels(s, pat)
        s.expose_tool = params['tool']
    elif op == 'develop':
        lat = s.latent or set()
        for p in s.pixels:
            st = s.stack[p]
            ridx = max((i for i, t in enumerate(st) if t[0] in RESISTS), default=None)
            if ridx is None:
                continue
            if params['liftoff']:
                if p in lat:
                    del st[ridx]
                else:
                    del st[ridx:]
            elif p in lat:
                del st[ridx:]
        s.latent = None
        s.crust = set()
    elif op == 'strip':
        for p in s.pixels:
            st = s.stack[p]
            # an O2 ash also burns off a spin-on-carbon hardmask, lifting the SiON cap with it
            ridx = max((i for i, t in enumerate(st) if t[0] in RESISTS), default=None)
            sidx = min((i for i, t in enumerate(st) if t[0] == 'soc'), default=None)
            cut = min(i for i in (ridx, sidx) if i is not None) if (ridx, sidx) != (None, None) else None
            if cut is not None:
                del st[cut:]
        s.crust = set()
        s.latent = None
        if params.get('residue'):
            s.residue = {p for p in s.pixels if h32(item, p) % 100 < 30}
        s.snapshot = None
    elif op == 'rinse':
        s.residue = set()
    elif op == 'soc_ash':
        # forming-gas ash takes out the carbon; the SiON cap settles onto the surface until it is cleared
        for p in s.pixels:
            st = s.stack[p]
            for t in RESISTS | {'mandrel'}:
                while st and st[-1][0] == t:
                    st.pop()
            if st and st[-1][0] == 'sion' and len(st) >= 2 and st[-2][0] == 'soc':
                sion = st.pop()
                st.pop()
                st.append(sion)
            else:
                while st and st[-1][0] == 'soc':
                    st.pop()
        s.snapshot = None
    elif op == 'etch':
        targets = ETCH.get(params['material'], {params['material']})
        depth = 2 if params['material'] == 'silicon_bosch' else 1
        for p in s.pixels:
            st = s.stack[p]
            if st[-1][0] == 'mandrel':     # the mandrel poly is cut in the same window as the layer under it
                st.pop()
            for _ in range(depth):
                if st[-1][0] in targets and len(st) > 1:
                    st.pop()
            if params['material'] == 'spin_on_carbon':
                while len(st) > 1 and st[-1][0] in targets:
                    st.pop()
        s.snapshot = None
    elif op in ('deposit', 'metal', 'oxidize', 'plate', 'diffuse'):
        if s.snapshot is None and not s.back:
            s.snapshot = {p: list(v) for p, v in s.stack.items()}
        if op == 'deposit':
            tok = DEPOSIT.get(params['material'], params['material'].split('.')[0])
            dt = EPI_DOPING.get(params['material'])
            layer = T(tok, params['thickness'], 0.3 if dt == 'n' else 0.0, 0.3 if dt == 'p' else 0.0)
            for p in s.pixels:
                s.stack[p].append(layer)
        elif op == 'metal':
            for mat in params['materials']:
                tok = DEPOSIT.get(mat, mat)
                for p in s.pixels:
                    stack[p].append(T(tok))
            s.finish = 'metal'
        elif op == 'oxidize':
            # Thermal oxide only grows on exposed silicon (or thickens existing oxide): LOCOS-style selectivity
            th = 1.5 if params['wet'] else 1.0
            for p in s.pixels:
                st = s.stack[p]
                t = st[-1][0]
                if t in SEMIS:
                    st.append(T('sio2', th))
                elif t == 'sio2':
                    st[-1] = T('sio2', st[-1][1] + th * 0.6)
        elif op == 'plate':
            for p in s.pixels:
                if stack[p][-1][0] in CONDUCTORS:
                    stack[p].append(T(params['token']))
            s.finish = 'matte'
        elif op == 'diffuse':
            for p in s.pixels:
                st = s.stack[p]
                if st[-1][0] in SEMIS:
                    st[-1] = add_dopant(st[-1], params['type'], 0.9)
                st.append(T('bsg', 0.8))
    elif op == 'implant':
        t = params['type']
        dose = 1.2 if params.get('source') == 'purified_antimony_trioxide' else 0.8
        for p in s.pixels:
            if s.has_mask_layer(p):
                s.crust.add(p)
                continue
            st = s.stack[p]
            # ions pass through thin dielectrics and stop in the first solid layer
            for i in range(len(st) - 1, -1, -1):
                kind = MAT.get(st[i][0], {'kind': 'opaque'})['kind']
                if kind == 'film':
                    continue
                if kind == 'semi':
                    st[i] = add_dopant(st[i], t, dose)
                    s.fresh.add(p)
                break
        s.implants[t] += 1
    elif op == 'drive_in':
        # dopants diffuse laterally into neighbouring silicon of the same layer
        new = {}
        for p in s.pixels:
            x, y = p
            st = list(s.stack[p])
            for i, t in enumerate(st):
                if t[0] not in SEMIS:
                    continue
                n, pp = t[2] * 0.7, t[3] * 0.7
                for q in ((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)):
                    qs = s.stack.get(q)
                    src = qs[i] if qs and i < len(qs) and qs[i][0] == t[0] else t
                    n += src[2] * 0.075
                    pp += src[3] * 0.075
                st[i] = (t[0], t[1], n, pp)
            new[p] = st
        s.stack = new
        s.fresh = set()
    elif op == 'anneal':
        s.fresh = set()
        stk = s.back_stack if s.back else s.stack
        for p in s.pixels:
            st = stk[p]
            for i in range(1, len(st)):
                t, below = st[i][0], st[i - 1][0]
                if t in ('ni', 'pt') and below in SEMIS | {'ni2si'}:
                    st[i] = T('ni2si')
                elif t == 'co' and below in SEMIS:
                    st[i] = T('co2si')
            for i, tok in enumerate(st):
                t = tok[0]
                if params.get('tier', 2) >= 3 and t == 'ni2si':
                    st[i] = T('nisi')
                if params.get('tier', 2) >= 3 and t == 'co2si':
                    st[i] = T('cosi2')
                if t == 'solder':
                    st[i] = T('bump')
            # collapse pt/ni pairs that became silicide into a single layer
            j = 1
            while j < len(st):
                if st[j][0] in ('ni2si', 'nisi', 'co2si', 'cosi2') and st[j - 1][0] == st[j][0]:
                    del st[j]
                else:
                    j += 1
        if any(st[-1][0] == 'bump' for st in stk.values()):
            s.finish = 'gloss'
    elif op == 'cmp':
        if s.snapshot:
            hmax = max(len(v) for v in s.snapshot.values())
            for p in s.pixels:
                snap = s.snapshot[p]
                added = s.stack[p][len(snap):] if s.stack[p][:len(snap)] == snap else []
                if len(snap) >= hmax or not added:
                    s.stack[p] = list(snap)
                else:
                    s.stack[p] = list(snap) + [added[-1]]
            if any(st[-1][0] in ('cu_ecp', 'cu') for st in s.stack.values()):
                s.metal_layers += 1
        s.snapshot = None
        s.residue = set()
        s.finish = 'gloss'
    elif op == 'polish':
        s.finish = 'gloss'
    elif op == 'clean':
        s.finish = 'clean'
        s.residue = set()
    elif op == 'backgrind':
        s.back = True
        s.back_stack = {p: [T('si')] for p in s.pixels}
        s.finish = 'ground'
    elif op == 'alloy':
        for p in s.pixels:
            if (p[0] - 7.5) ** 2 + (p[1] - 7.5) ** 2 <= 4.5:
                s.stack[p][-1] = add_dopant(s.stack[p][-1], 'p', 1.0)
                s.stack[p].append(T('al'))
        s.finish = 'gloss'
    elif op == 'tune':
        s.special = 'tuned'
    elif op == 'print':
        for p in mask_pixels(s, params['pattern']):
            s.stack[p].append(T(params['token']))
        s.finish = 'matte'
    elif op == 'fire':
        fired = {'cu_paste': 'cu_fired', 'rink': 'rfired', 'glass_paste': 'glass'}
        for p in s.pixels:
            s.stack[p] = [T(fired[t[0]]) if t[0] in fired else t for t in s.stack[p]]
        s.finish = 'gloss'
    elif op == 'trim':
        for p in mask_pixels(s, 'trim'):
            s.stack[p] = s.stack[p][:3] + [T('kerf')]
    return s


def root_state(item, params):
    src = (params.get('source') or '') + ' ' + item
    small = '.small.' in item or 'fz' in src
    sub = 'si'
    if item.startswith('component.'):
        s = State('batio3' if '_cap.' in item else 'alumina', None, False, square=True)
        s.finish = 'matte'
        if '_cap.' in item:
            s.special = 'mlcc_ni' if 'bme' in item else 'mlcc_pd'
        return s
    if 'gallium_arsenide' in src:
        sub = 'gaas'
    elif 'germanium' in src:
        sub = 'ge'
    elif 'quartz' in src:
        sub = 'quartz'
    doping = None
    if 'heavily_n' in src:
        doping = ('n', 0.35)
    elif 'n_doped' in src:
        doping = ('n', 0.12)
    elif 'p_doped' in src:
        doping = ('p', 0.12)
    s = State(sub, doping, small)
    s.finish = 'raw' if params and params.get('item', '').endswith('.raw') or item.endswith('.raw') else 'gloss'
    if sub == 'quartz':
        s.finish = 'clean'
    return s


class Simulator:
    def __init__(self, graph):
        self.g = graph
        self.memo = {}
        self.trace = {}

    def state(self, item, depth=0):
        if item in self.memo:
            return self.memo[item]
        if depth > 400:
            raise RuntimeError('chain too long at ' + item)
        target = self.g.aliases.get(item, item)
        if target != item:
            st = self.state(target, depth + 1)
            self.memo[item] = st
            self.trace[item] = ('alias', target)
            return st
        step = self.g.step(item)
        if step is None:
            st = root_state(item, {})
            self.trace[item] = ('root', None)
        else:
            src, op, params = step
            if src is None:
                st = root_state(item, params)
                if op == 'print':
                    st = apply(self.g, st, item, op, params)
                if op == 'polish':
                    st.finish = 'gloss'
                if op == 'clean':
                    st.finish = 'clean'
                if op == 'tune':
                    st.special = 'tuned'
            else:
                st = apply(self.g, self.state(src, depth + 1), item, op, params)
            self.trace[item] = (op, src)
        self.memo[item] = st
        return st


# --------------------------------------------------------------------------------------------------
# Rendering
# --------------------------------------------------------------------------------------------------
# Interference colours of a transparent film on silicon vs optical thickness (1 unit ~ 100 nm SiO2)
INTERFERENCE = [
    (0.0, (104, 106, 118)), (0.5, (168, 140, 104)), (1.0, (124, 72, 142)), (1.5, (70, 104, 196)),
    (2.0, (136, 184, 214)), (2.5, (206, 196, 118)), (3.0, (218, 146, 88)), (3.5, (186, 88, 130)),
    (4.0, (98, 88, 186)), (4.5, (78, 156, 168)), (5.0, (116, 184, 108)), (5.5, (196, 202, 112)),
    (6.0, (212, 146, 140)), (6.5, (150, 110, 170)), (7.0, (104, 150, 176)), (7.5, (130, 176, 140)),
    (8.0, (190, 186, 140)), (8.5, (186, 150, 160)), (9.0, (150, 150, 180)),
]


def interference(d):
    if d >= INTERFERENCE[-1][0]:
        period = 3.0
        d = INTERFERENCE[-1][0] - period + ((d - INTERFERENCE[-1][0]) % period)
    for (d0, c0), (d1, c1) in zip(INTERFERENCE, INTERFERENCE[1:]):
        if d0 <= d <= d1:
            t = (d - d0) / (d1 - d0)
            return lerp(c0, c1, t)
    return INTERFERENCE[-1][1]


def lerp(a, b, t):
    return tuple(a[i] + (b[i] - a[i]) * t for i in range(3))


def lum(c):
    return 0.299 * c[0] + 0.587 * c[1] + 0.114 * c[2]


def scale(c, f):
    return tuple(v * f for v in c)


def add_dopant(tok, kind, amount):
    return (tok[0], tok[1], tok[2] + (amount if kind == 'n' else 0.0), tok[3] + (amount if kind == 'p' else 0.0))


def dopant_tint(c, n, p, fresh):
    net = n - p
    if abs(net) < 0.05 and n + p < 0.05:
        return c
    if net >= 0:
        tint = (70, 150, 150)   # n-type: cyan/teal
    else:
        tint = (170, 80, 140)   # p-type: magenta
    amt = min(0.75, abs(net) * 0.55 + 0.08 * min(n, p))
    out = lerp(c, tint, amt)
    if fresh:
        out = scale(out, 0.86)
    return out


def pixel_color(s, p, stack):
    """Composite the stack bottom-up: last opaque layer, then films, then resists."""
    idx = 0
    for i, t in enumerate(stack):
        if MAT.get(t[0], {'kind': 'opaque'})['kind'] in ('semi', 'metal', 'opaque'):
            idx = i
    base_t = stack[idx][0]
    info = MAT.get(base_t) or dict(kind='opaque', rgb=hash_color(base_t))
    c = info['rgb']
    if info['kind'] == 'semi' and not s.back:
        c = dopant_tint(c, stack[idx][2], stack[idx][3], p in s.fresh)
    d = 0.0
    out = c
    for t, th, _, _ in stack[idx + 1:]:
        mi = MAT.get(t) or dict(kind='film', n=1.0)
        if mi['kind'] == 'film':
            d += th * mi['n']
            # a film only shows interference colour as brightly as the surface under it reflects
            refl = min(1.0, 0.35 + 0.65 * lum(c) / lum(MAT['si']['rgb']))
            ic = scale(interference(d), refl)
            base_weight = 0.35 if info['kind'] == 'metal' else 0.15
            out = lerp(ic, c, base_weight)
        elif mi['kind'] == 'resist':
            rc = mi['rgb']
            if s.latent is not None and p in s.latent:
                # latent image: UV bleaches novolac's PAC; DUV/e-beam leave a faint grey shift
                rc = lerp(rc, (236, 222, 200), 0.45) if s.__dict__.get('expose_tool') == 'uv_light_box' else lerp(rc, (120, 116, 130), 0.4)
            if p in s.crust:
                rc = scale(rc, 0.62)
            out = lerp(out, rc, mi['a'])
        else:
            out = mi['rgb']
    return out, info['kind'] if len(stack) - 1 == idx else MAT.get(stack[-1][0], {'kind': 'film'})['kind']


def hash_color(name):
    hv = h32(name)
    r, g, b = colorsys.hsv_to_rgb((hv % 360) / 360.0, 0.35, 0.7)
    return (r * 255, g * 255, b * 255)


def render(s, item):
    img = Image.new('RGBA', (SIZE, SIZE), (0, 0, 0, 0))
    stack = s.back_stack if s.back else s.stack
    heights = {p: sum(0.6 if MAT.get(t[0], {}).get('kind') in ('film', 'resist') else 1.0 for t in stack[p]) for p in s.pixels}
    hmax = max(heights.values())
    r_outer = 5.6 if s.small else 7.55
    cx = cy = 7.5
    for p in s.pixels:
        x, y = p
        c, top_kind = pixel_color(s, p, stack[p])
        # lower (etched) areas sit in shadow, which is what makes patterns read after uniform depositions
        relief = min(0.3, (hmax - heights[p]) * 0.08)
        c = scale(c, 1.0 - relief)
        # global lighting: bright top-left, darker bottom-right
        light = 1.10 - 0.22 * ((x + y) / (2 * (SIZE - 1)))
        c = scale(c, light)
        dist = math.hypot(x - cx, y - cy)
        if (s.square and (x in (1, 14) or y in (1, 14))) or (not s.square and dist > r_outer - 1.0):
            c = scale(c, 0.8)                                 # bevel
        if s.special in ('mlcc_ni', 'mlcc_pd'):
            # internal electrodes of the laminated stack show through at the cut faces / thin cover layer
            dc = die_coord(x, y)
            if dc is None:
                c = scale(c, 0.86)
            elif dc[1] in (0, 2):
                c = lerp(c, (120, 120, 126) if s.special == 'mlcc_ni' else (200, 196, 180), 0.35)
        n = (h32(item if s.finish in ('raw', 'ground', 'matte') else 'grain', x, y) % 1000) / 1000.0 - 0.5
        grain = {'raw': 22, 'ground': 14, 'matte': 14}.get(s.finish, 5)
        c = tuple(v + n * grain for v in c)
        if s.finish == 'raw':
            # wire-saw marks
            if (x - y) % 3 == 0:
                c = scale(c, 0.9)
        if s.finish == 'ground':
            ring = math.sin(math.hypot(x - 2.0, y - 15.0) * 1.9)
            c = scale(c, 1.0 + 0.07 * ring)
        if p in s.residue:
            c = lerp(c, (112, 96, 86), 0.55)
        spec = 0.0
        if s.finish in ('gloss', 'clean', 'metal') or top_kind in ('metal', 'resist'):
            # specular streak across the upper-left of the disc
            u = (x - y)
            v = x + y
            if abs(u) <= 1 and 3 <= v <= 7:
                spec = 0.28 if top_kind == 'metal' or s.finish == 'metal' else 0.18
                if s.finish == 'clean':
                    spec += 0.08
                if abs(u) == 1:
                    spec *= 0.5
        top = stack[p][-1][0]
        if top == 'bump':
            dc = die_coord(x, y)
            if dc is not None:
                lx, ly = dc[0] - 1, dc[1] - 1
                if (lx, ly) == (0, 0):
                    spec = 0.45
                elif (lx, ly) == (1, 1):
                    c = scale(c, 0.7)
        c = lerp(c, (255, 255, 255), spec)
        if s.special == 'tuned' and 2.0 <= dist <= 3.2:
            c = lerp(c, (255, 255, 255), 0.25)
        img.putpixel(p, tuple(int(max(0, min(255, round(v)))) for v in c) + (255,))
    return img


# --------------------------------------------------------------------------------------------------
# Main
# --------------------------------------------------------------------------------------------------
def add_fixups(g):
    """Items with no producing recipe (registration/recipe name mismatches) get their intended state."""
    g.aliases.update({
        'wafer.silicon.small.n_doped': 'wafer.small.silicon.n_doped',
        'wafer.silicon.small.heavily_n_doped': 'wafer.small.silicon.heavily_n_doped',
        'wafer.thyristor.step_one.coated': 'wafer.silicon.n_doped.coated',
        'wafer.thyristor.step_one.exposed': 'wafer.silicon.n_doped.exposed',
    })
    g.virtual['wafer.thyristor.step_seven.deposited'] = (
        'wafer.thyristor.step_seven.exposed', 'metal', dict(materials=['aluminium']))
    g.virtual['wafer.advanced_random_access_memory'] = (
        'wafer.cmos_chipset.beol_nine.step_eight', 'noop', {})


def todo_items():
    out = []
    with open(TODO) as f:
        for line in f:
            line = line.strip()
            item = line[len('metaitems/'):].replace('/', '.')
            if line.startswith('metaitems/wafer/') or (item.startswith('component.') and '.wafer' in item):
                out.append(item)
    return out


def tex_path(item):
    return os.path.join(TEX_ROOT, 'metaitems', *item.split('.')) + '.png'


def main():
    ap = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument('--recipes', default=os.path.join(HERE, 'build', 'recipes.json'))
    ap.add_argument('--all', action='store_true', help='render every wafer item with a recipe, not just the todo list')
    ap.add_argument('--dry-run', action='store_true')
    ap.add_argument('--preview', help='write an upscaled contact sheet of the rendered items')
    ap.add_argument('--trace', help='print the replayed chain for one item')
    a = ap.parse_args()

    with open(a.recipes) as f:
        recipes = json.load(f)
    g = Graph(recipes)
    add_fixups(g)
    sim = Simulator(g)

    if a.trace:
        chain = []
        cur = a.trace
        while cur:
            sim.state(cur)
            op, src = sim.trace[cur]
            chain.append((cur, op))
            cur = src
        for it, op in reversed(chain):
            print(f'{op:10s} {it}')
        return

    items = todo_items()
    if a.all:
        items = sorted(set(items) | {i for i in g.producers if i.startswith('wafer.')})
    rendered = []
    for item in items:
        st = sim.state(item)
        img = render(st, item)
        rendered.append((item, img))
        if not a.dry_run:
            path = tex_path(item)
            os.makedirs(os.path.dirname(path), exist_ok=True)
            img.save(path)
    print(f'rendered {len(rendered)} wafer textures', file=sys.stderr)

    if a.preview:
        preview(rendered, a.preview)


def preview(rendered, path, sc=5, cols=24):
    cell = SIZE * sc + 4
    rows = (len(rendered) + cols - 1) // cols
    sheet = Image.new('RGBA', (cols * cell, rows * cell), (48, 48, 52, 255))
    for i, (_, img) in enumerate(rendered):
        big = img.resize((SIZE * sc, SIZE * sc), Image.NEAREST)
        sheet.paste(big, ((i % cols) * cell + 2, (i // cols) * cell + 2), big)
    sheet.save(path)


if __name__ == '__main__':
    main()

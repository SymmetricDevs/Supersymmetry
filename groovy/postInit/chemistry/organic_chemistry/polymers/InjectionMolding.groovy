import globals.Globals

INJECTION_MOLDER = recipemap('injection_molder')

class ExtrudablePolymers {
    String name
    int voltage_required
    int duration
    boolean plate
    boolean pipe
    boolean fluidpipe
    boolean ring
    ExtrudablePolymers(name, voltage_required, duration, plate, pipe, fluidpipe, ring) {
        this.name = name
        this.voltage_required = voltage_required
        this.duration = duration
        this.plate = plate
        this.pipe = pipe
        this.fluidpipe = fluidpipe
        this.ring = ring
    }
}

def polymers = [
        new ExtrudablePolymers('Plastic', 120, 8, true, true, true, false),
        new ExtrudablePolymers('Polypropylene', 120, 8, true, false, false, false),
        new ExtrudablePolymers('PolyvinylChloride', 120, 8, true, true, false, false),
        new ExtrudablePolymers('Rubber', 120, 8, true, true, true, false),
        new ExtrudablePolymers('Polycaprolactam', 120, 8, true, false, false, false),
        new ExtrudablePolymers('EpoxyCresolNovolacs', 120, 8, true, false, false, false),

        new ExtrudablePolymers('Polycarbonate', 480, 8, false, false, false, false),
        new ExtrudablePolymers('Polytetrafluoroethylene', 480, 8, true, true, true, false),
        new ExtrudablePolymers('PolyethyleneTerephthalate', 480, 8, true, false, false, false),
        new ExtrudablePolymers('EthyleneVinylAcetate', 480, 8, false, true, true, false),
        new ExtrudablePolymers('SiliconeRubber', 480, 8, true, false, false, true),
        new ExtrudablePolymers('StyreneIsopreneRubber', 480, 8, true, false, false, false),
        new ExtrudablePolymers('StyreneButadieneRubber', 480, 8, true, false, false, false),

        new ExtrudablePolymers('PolyphenyleneOxide', 1920, 8, false, false, false, false),
        new ExtrudablePolymers('PolyphenyleneSulfide', 1920, 8, true, false, false, false),
        new ExtrudablePolymers('PolyvinylideneFluoride', 1920, 8, true, false, false, false),
        new ExtrudablePolymers('Ultem', 1920, 8, false, false, false, false),
        new ExtrudablePolymers('Epoxy', 1920, 8, false, false, false, false),
        new ExtrudablePolymers('Pmma', 1920, 8, true, false, false, false),

        new ExtrudablePolymers('Polybenzimidazole', 7680, 8, true, true, true, false),
        new ExtrudablePolymers('PolyetherEtherKetone', 7680, 8, false, false, false, false),
        new ExtrudablePolymers('Viton', 7680, 8, false, false, false, false),
        new ExtrudablePolymers('KaptonE', 7680, 8, false, false, false, false),
        new ExtrudablePolymers('KaptonK', 7680, 8, false, false, false, false)
]

for (polymer in polymers) {

    INJECTION_MOLDER.recipeBuilder()
            .notConsumable(metaitem('shape.extruder.ingot'))
            .inputs(ore('dust' + polymer.name))
            .outputs(metaitem('ingot' + polymer.name))
            .duration(polymer.duration)
            .EUt(polymer.voltage_required)
            .buildAndRegister();

    if (polymer.plate == true) {
        INJECTION_MOLDER.recipeBuilder()
                .notConsumable(metaitem('shape.extruder.plate'))
                .inputs(ore('dust' + polymer.name))
                .outputs(metaitem('plate' + polymer.name))
                .duration(polymer.duration)
                .EUt(polymer.voltage_required)
                .buildAndRegister();

        INJECTION_MOLDER.recipeBuilder()
                .notConsumable(metaitem('shape.extruder.foil'))
                .inputs(ore('dust' + polymer.name))
                .outputs(metaitem('foil' + polymer.name) * 4)
                .duration(polymer.duration)
                .EUt(polymer.voltage_required)
                .buildAndRegister();
    }

    if (polymer.pipe == true) {
        if (polymer.fluidpipe == true) {
            INJECTION_MOLDER.recipeBuilder()
                    .notConsumable(metaitem('shape.extruder.pipe.tiny'))
                    .inputs(ore('dust' + polymer.name))
                    .outputs(metaitem('pipeTinyFluid' + polymer.name) * 2)
                    .duration(polymer.duration)
                    .EUt(polymer.voltage_required)
                    .buildAndRegister();

            INJECTION_MOLDER.recipeBuilder()
                    .notConsumable(metaitem('shape.extruder.pipe.small'))
                    .inputs(ore('dust' + polymer.name))
                    .outputs(metaitem('pipeSmallFluid' + polymer.name))
                    .duration(polymer.duration)
                    .EUt(polymer.voltage_required)
                    .buildAndRegister();

            INJECTION_MOLDER.recipeBuilder()
                    .notConsumable(metaitem('shape.extruder.pipe.normal'))
                    .inputs(ore('dust' + polymer.name) * 3)
                    .outputs(metaitem('pipeNormalFluid' + polymer.name))
                    .duration(polymer.duration * 3)
                    .EUt(polymer.voltage_required)
                    .buildAndRegister();

            INJECTION_MOLDER.recipeBuilder()
                    .notConsumable(metaitem('shape.extruder.pipe.large'))
                    .inputs(ore('dust' + polymer.name) * 6)
                    .outputs(metaitem('pipeLargeFluid' + polymer.name))
                    .duration(polymer.duration * 6)
                    .EUt(polymer.voltage_required)
                    .buildAndRegister();

            INJECTION_MOLDER.recipeBuilder()
                    .notConsumable(metaitem('shape.extruder.pipe.huge'))
                    .inputs(ore('dust' + polymer.name) * 12)
                    .outputs(metaitem('pipeHugeFluid' + polymer.name))
                    .duration(polymer.duration * 12)
                    .EUt(polymer.voltage_required)
                    .buildAndRegister();
        } else {
            INJECTION_MOLDER.recipeBuilder()
                    .notConsumable(metaitem('shape.extruder.pipe.small'))
                    .inputs(ore('dust' + polymer.name))
                    .outputs(metaitem('pipeSmallItem' + polymer.name))
                    .duration(polymer.duration)
                    .EUt(polymer.voltage_required)
                    .buildAndRegister();

            INJECTION_MOLDER.recipeBuilder()
                    .notConsumable(metaitem('shape.extruder.pipe.normal'))
                    .inputs(ore('dust' + polymer.name) * 3)
                    .outputs(metaitem('pipeNormalItem' + polymer.name))
                    .duration(polymer.duration * 3)
                    .EUt(polymer.voltage_required)
                    .buildAndRegister();

            INJECTION_MOLDER.recipeBuilder()
                    .notConsumable(metaitem('shape.extruder.pipe.large'))
                    .inputs(ore('dust' + polymer.name) * 6)
                    .outputs(metaitem('pipeLargeItem' + polymer.name))
                    .duration(polymer.duration * 6)
                    .EUt(polymer.voltage_required)
                    .buildAndRegister();

            INJECTION_MOLDER.recipeBuilder()
                    .notConsumable(metaitem('shape.extruder.pipe.huge'))
                    .inputs(ore('dust' + polymer.name) * 12)
                    .outputs(metaitem('pipeHugeItem' + polymer.name))
                    .duration(polymer.duration * 12)
                    .EUt(polymer.voltage_required)
                    .buildAndRegister();
        }
    }

    if (polymer.ring == true) {
        INJECTION_MOLDER.recipeBuilder()
                .notConsumable(metaitem('shape.extruder.ring'))
                .inputs(ore('dust' + polymer.name))
                .outputs(metaitem('ring' + polymer.name) * 4)
                .duration(polymer.duration)
                .EUt(polymer.voltage_required)
                .buildAndRegister();
    }
}

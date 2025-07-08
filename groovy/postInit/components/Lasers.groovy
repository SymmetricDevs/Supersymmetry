import globals.Globals

// TODO: set voltage and duration

ASSEMBLER = recipemap('assembler');
BLENDER = recipemap('blender');
CVD = recipemap('cvd');
LATHE = recipemap('lathe');
MILLING = recipemap('milling');
VACUUM_CHAMBER = recipemap('vacuum_chamber');
SPUTTERING = recipemap('sputter_deposition');

/// Deposition Apparatuses
MILLING.recipeBuilder()
    .inputs(ore('plateMolybdenum') * 1)
    .outputs(metaitem('molybdenum_grid') * 1)
    .EUt(Globals.voltAmps[3])
    .duration(2000)
    .buildAndRegister();

// IBAD
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('graphite_electrode') * 2)
    .inputs(ore('wireFineMolybdenum') * 16)
    .inputs(metaitem('molybdenum_grid') * 2)
    .inputs(metaitem('plateTungstenSteel') * 8)
    .inputs(ore('cableGtDoubleAluminium') * 8)
    .inputs(metaitem('electric.pump.ev') * 1)
    .fluidInputs(fluid('soldering_alloy') * 144)
    .outputs(metaitem('pvd_apparatus.ion_source') * 1)
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister();

// e-beam
ASSEMBLER.recipeBuilder().EUt(Globals.voltAmps[3]).duration(200)
    .inputs(ore('wireFineTungsten') * 16)
    .inputs(metaitem('molybdenum_grid') * 2)
    .inputs(metaitem('plateStainlessSteel') * 4)
    .inputs(ore('cableGtDoubleElectrum') * 4)
    .inputs(metaitem('electric.pump.hv') * 1)
    .fluidInputs(fluid('soldering_alloy') * 144)
    .outputs(metaitem('pvd_apparatus.electron_source') * 1)
    .buildAndRegister();

/// Nd:YAG laser
// mirror: HfO2/SiO2 on BK-7
// [1] suggested the coating, [2] tells how to coat
MIXER.recipeBuilder()
    .inputs(ore('dustAcidWashedSiliconDioxide') * 21)
    .inputs(ore('dustBoronTrioxide') * 5)
    .inputs(ore('dustPotash') * 3)
    .inputs(ore('dustBariumOxide') * 2)
    .outputs(ore('dustBorosilicateCrownGlass').first() * 10)
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister()

LATHE.recipeBuilder()
    .inputs(ore('plateBorosilicateCrownGlass'))
    .outputs(metaitem('lens.borosilicate'))
    .outputs(ore('dustTinyBorosilicateCrownGlass').first())
    .duration(1200).EUt(120).buildAndRegister();

SPUTTERING.recipeBuilder()
    .notConsumable(metaitem('pvd_apparatus.ion_source') * 1)
    .inputs(metaitem('lens.borosilicate') * 1)
    .inputs(ore('dustSmallAcidWashedSiliconDioxide') * 3)
    .inputs(ore('dustSmallHafniumDioxide') * 3)
    .fluidInputs(fluid('argon') * 200)
    .fluidInputs(fluid('krypton') * 200)
    .outputs(metaitem('mirror.hafnia_silica') * 1)
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister();

// excitation source: xenon flash tube
VACUUM_CHAMBER.recipeBuilder()
    .inputs(ore('boltTungsten') * 2)
    .inputs(ore('ringElectrum') * 1)
    .inputs(metaitem('component.glass.tube') * 8)
    .fluidInputs(fluid('xenon') * 2000)
    .outputs(metaitem('laser.component.xenon_flash_tube'))
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('laser.component.xenon_flash_tube'))
    .inputs(metaitem('mirror.hafnia_silica') * 2)
    .inputs(ore('stickNdYagCeramic') * 1)
    .inputs(ore('plateTungstenSteel') * 4)
    .fluidInputs(fluid('soldering_alloy') * 288)
    .outputs(metaitem('laser.nd_yag'))
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

/*
[1] Frank Rainer, Frank P. De Marco, John T. Hunt, Amber J. Morgan, Leonard P. Mott, Frane Marcelja, and Michael R. Greenberg "High-threshold highly reflective coatings at 1064 nm", Proc. SPIE 1441, Laser-Induced Damage in Optical Materials: 1990, (1 June 1991); https://doi.org/10.1117/12.57235 
[2] Philippe Torchio, Alexandre Gatto, Marco Alvisi, Gérard Albrand, Norbert Kaiser, and Claude Amra, "High-reflectivity HfO2/SiO2 ultraviolet mirrors," Appl. Opt. 41, 3256-3261 (2002) 
*/


/// CO2 laser in EUV lithography
// mirror
BR.recipeBuilder()
    .inputs(ore('dustYtterbiumOxide') * 5)
    .fluidInputs(fluid('hydrofluoric_acid') * 6000)
    .outputs(metaitem('dustYtterbiumFluoride') * 8)
    .fluidOutputs(fluid('water') * 9000)
    .duration(80)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

// Coating material: [1]
SPUTTERING.recipeBuilder()
    .notConsumable(metaitem('pvd_apparatus.ion_source') * 1)
    .notConsumable(metaitem('pvd_apparatus.electron_source') * 1)
    .inputs(ore('plateHighPurityGold'))
    .inputs(ore('dustSmallZincSelenide') * 1)
    .inputs(ore('dustSmallYtterbiumFluoride') * 1)
    .inputs(ore('dustSmallGermanium') * 1)
    .fluidInputs(fluid('argon') * 400)
    .fluidInputs(fluid('krypton') * 200)
    .outputs(metaitem('mirror.intermediate.10_6_coated'))
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister();

LATHE.recipeBuilder()
    .inputs(metaitem('mirror.intermediate.10_6_coated'))
    .outputs(metaitem('mirror.10_6_micron'))
    .outputs(ore('dustSmallGold').first())
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister();

// lens: ZnSe lens
// ZnSe synth from [2]
CVD.recipeBuilder()
    .inputs(ore('plateZinc'))
    .fluidInputs(fluid('hydrogen_selenide') * 1000)
    .outputs(ore('plateZincSelenide').first())
    .fluidOutputs(fluid('hydrogen') * 2000)
    .duration(120)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// plate to bare lens
LATHE.recipeBuilder()
    .inputs(ore('plateZincSelenide'))
    .outputs(metaitem('lens.bare_zinc_selenide'))
    .outputs(ore('dustSmallZincSelenide').first())
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister();


SPUTTERING.recipeBuilder()
    .inputs(ore('dustSmallZincSelenide') * 2)
    .inputs(ore('dustSmallYttriumTrifluoride') * 4)
    .inputs(metaitem('lens.bare_zinc_selenide'))
    .fluidInputs(fluid('argon') * 200)
    .fluidInputs(fluid('krypton') * 200)
    .outputs(metaitem('lens.zinc_selenide'))
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister();

/*
[1] Jianwen Jiang, Meng Guo, Jing Jiang, Li Xiang, Yuchuan Shao, Anlian Pan, Metal-Dielectric mirrors utilizing three gradient refractive index dielectric materials for 10.6 μm wavelength applications, Infrared Physics & Technology, Volume 145, 2025, 105709, ISSN 1350-4495, https://doi.org/10.1016/j.infrared.2025.105709.
[2] Shanghai Optics, "ZnSe Window – Infrared Optics," Shanghai Optics, [Online]. Available: https://www.shanghai-optics.com/components/infrared-optics/znse-window/. [Accessed: Jul. 3, 2025].
*/

// Fast axial gas CO2 laser
// Structure from [1]
BLENDER.recipeBuilder()
    .fluidInputs(fluid('carbon_dioxide') * 200)
    .fluidInputs(fluid('nitrogen') * 200)
    .fluidInputs(fluid('hydrogen') * 50)
    .fluidInputs(fluid('xenon') * 50)
    .fluidInputs(fluid('helium') * 500)
    .fluidOutputs(fluid('carbon_dioxide_laser_mixture') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('field.generator.ev') * 1)
    .inputs(metaitem('fluid.regulator.ev') * 4)
    .inputs(metaitem('component.glass.tube') * 4)
    .inputs(ore('pipeNormalFluidTungstenSteel') * 2)
    .inputs(metaitem('mirror.10_6_micron') * 4)
    .inputs(metaitem('lens.zinc_selenide') * 2)
    .inputs(ore('plateTungstenSteel') * 4)
    .fluidInputs(fluid('carbon_dioxide_laser_mixture') * 2000)
    .outputs(metaitem('laser.fast_axial_gas_co2'))
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister();

/*
[1] Uwe Habich, Peter Loosen, Christoph Hertzler, and Reinhard Wollermann-Windgasse "Industrial 30-kW CO2 laser with fast axial gas flow and rf excitation", Proc. SPIE 2702, Gas and Chemical Lasers, (29 March 1996); https://doi.org/10.1117/12.236892 
*/

/// EUV laser in EUV lithography
/// mirror: Mo/Si
SPUTTERING.recipeBuilder()
    .inputs(metaitem('wafer.silicon'))
    .inputs(ore('foilSilicon') * 2)
    .inputs(ore('foilMolybdenum') * 2)
    .inputs(ore('foilRuthenium') * 1)
    .fluidInputs(fluid('krypton') * 400)
    .fluidInputs(fluid('argon') * 600)
    .outputs(metaitem('mirror.molybdenum_silicon'))
    .EUt(Globals.voltAmps[3])
    .duration(200)
    .buildAndRegister();


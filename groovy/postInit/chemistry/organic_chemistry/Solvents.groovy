import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// TODO: move other organic solvents (THF etc.) here

// Carbonate esters

    // DMC (dimethyl carbonate)

    CSTR.recipeBuilder()
        .fluidInputs(fluid('phosgene') * 50)
        .fluidInputs(fluid('methanol') * 100)
        .fluidOutputs(fluid('dimethyl_carbonate') * 50)
        .fluidOutputs(fluid('hydrogen_chloride') * 100)
        .duration(1)
        .EUt(VA[LV])
        .buildAndRegister()

    // EC (ethylene carbonate)

    BCR.recipeBuilder()
        .fluidInputs(fluid('ethylene_oxide') * 50)
        .fluidInputs(fluid('carbon_dioxide') * 50)
        .fluidOutputs(fluid('ethylene_carbonate') * 50)
        .duration(5)
        .EUt(VA[LV])
        .buildAndRegister()

// Organosulfur solvents

    // DMS

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedAlumina'))
        .fluidInputs(fluid('methanol') * 100)
        .fluidInputs(fluid('hydrogen_sulfide') * 50)
        .fluidOutputs(fluid('dimethyl_sulfide') * 50)
        .fluidOutputs(fluid('water') * 100)
        .duration(5)
        .EUt(VA[LV])
        .buildAndRegister()

    // DMSO

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedCupricOxide'))
        .fluidInputs(fluid('dimethyl_sulfide') * 50)
        .fluidInputs(fluid('oxygen') * 50)
        .fluidOutputs(fluid('dimethyl_sulfoxide') * 50)
        .duration(5)
        .EUt(VA[LV])
        .buildAndRegister()

// Organochlorine solvents

    // EDC (ethylene dichloride / 1,2-dichloroethane / Freon 150)

    FIXED_BR.recipeBuilder()
        .fluidInputs(fluid('chlorine') * 100)
        .fluidInputs(fluid('ethylene') * 50)
        .notConsumable(ore('catalystBedIronIiiOxide'))
        .fluidOutputs(fluid('one_two_dichloroethane') * 50)
        .EUt(VA[LV])
        .duration(10)
        .buildAndRegister()

    FIXED_BR.recipeBuilder()
        .fluidInputs(fluid('ethylene') * 50)
        .fluidInputs(fluid('hydrochloric_acid') * 100)
        .fluidInputs(fluid('oxygen') * 50)
        .notConsumable(ore('catalystBedCopperIiChloride'))
        .fluidOutputs(fluid('one_two_dichloroethane') * 50)
        .fluidOutputs(fluid('water') * 150)
        .EUt(VA[LV])
        .duration(10)
        .buildAndRegister()

    // TeCA (1,1,2,2-tetrachloroethane / R130)

    CSTR.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('one_two_dichloroethane') * 50)
        .fluidInputs(fluid('chlorine') * 200)
        .fluidOutputs(fluid('one_one_two_two_tetrachloroethane') * 50)
        .fluidOutputs(fluid('hydrogen_chloride') * 100)
        .duration(5)
        .EUt(VA[LV])
        .buildAndRegister()

    // TCE (trichloroethylene)

    CSTR.recipeBuilder()
        .circuitMeta(2)
        .fluidInputs(fluid('one_two_dichloroethane') * 50)
        .fluidInputs(fluid('chlorine') * 200)
        .fluidOutputs(fluid('trichloroethylene') * 50)
        .fluidOutputs(fluid('hydrogen_chloride') * 150)
        .duration(10)
        .EUt(VA[MV])
        .buildAndRegister()

// Amines

    // Isopropyl Amine

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedNickel'))
        .fluidInputs(fluid('acetone') * 50)
        .fluidInputs(fluid('hydrogen') * 100)
        .fluidInputs(fluid('ammonia') * 50)
        .fluidOutputs(fluid('isopropylamine_solution') * 100)
        .duration(5)
        .EUt(VA[MV])
        .buildAndRegister()

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedNickel'))
        .fluidInputs(fluid('isopropyl_alcohol') * 50)
        .fluidInputs(fluid('ammonia') * 50)
        .fluidOutputs(fluid('isopropylamine_solution') * 100)
        .duration(5)
        .EUt(VA[MV])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('isopropylamine_solution') * 2000)
        .fluidOutputs(fluid('water') * 1000)
        .fluidOutputs(fluid('isopropylamine') * 1000)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

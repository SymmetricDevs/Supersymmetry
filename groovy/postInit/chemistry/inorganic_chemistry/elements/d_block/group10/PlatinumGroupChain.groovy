import globals.Globals;

BR = recipemap('batch_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')
DISTILLERY = recipemap('distillery')
DISTILLATION_TOWER = recipemap('distillation_tower')
ROASTER = recipemap('roaster')
MACERATOR = recipemap('macerator')
SIFTER = recipemap('sifter')
CRYSTALLIZER = recipemap('crystallizer')
REACTION_FURNACE = recipemap('reaction_furnace')
GRAVITY_SEPARATOR = recipemap('gravity_separator')
FF = recipemap('froth_flotation')
CLARIFIER = recipemap('clarifier')
MIXER = recipemap('mixer')
EBF = recipemap('electric_blast_furnace')
ELECTROMAGNETIC_SEPARATOR = recipemap('electromagnetic_separator')
AUTOCLAVE = recipemap('autoclave')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
SIFTER = recipemap('sifter')
DRYER = recipemap('dryer')
VACUUM_DT = recipemap('vacuum_distillation')
BCR = recipemap('bubble_column_reactor')
SIEVE_DT = recipemap('sieve_distillation')
VACUUM_CHAMBER = recipemap('vacuum_chamber')

// Pt/Pd FROM SECONDARY ORES (TIER 1)

    MACERATOR.recipeBuilder()
        .inputs(item('susy:resource_block', 10))
        .outputs(metaitem('dustAlluvialPgmSand') * 9)
        .duration(160)
        .EUt(30)
        .buildAndRegister()

    SIFTER.recipeBuilder()
        .inputs(ore('dustAlluvialPgmSand'))
        .outputs(metaitem('nuggetAlluvialPgm') * 4)
        .outputs(metaitem('dustNetherQuartz') * 3)
        .duration(160)
        .EUt(30)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustAlluvialPgm') * 2)
        .fluidInputs(fluid('aqua_regia') * 12000)
        .fluidInputs(fluid('nitric_acid') * 2000)
        .fluidOutputs(fluid('alluvial_pgm_solution') * 5000)
        .fluidOutputs(fluid('hydrogen') * 1000)
        .fluidOutputs(fluid('nitrogen_dioxide') * 5000)
        .duration(120)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustAnyPurityZinc'))
        .fluidInputs(fluid('alluvial_pgm_solution') * 10000)
        .outputs(metaitem('dustIron'))
        .fluidOutputs(fluid('cemented_alluvial_pgm_solution') * 10000)
        .duration(240)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    CRYSTALLIZER.recipeBuilder() // 2 H2PtCl6 + 4 NH4Cl --> 2 (NH4)2PtCl6 + 4 HCl
        .circuitMeta(1)
        .fluidInputs(fluid('cemented_alluvial_pgm_solution') * 10000)  // 67% (NH4)2Pt, 33% H2PdCl4
        .fluidInputs(fluid('ammonium_chloride_solution') * 4000)
        .chancedOutput(metaitem('dustAmmoniumHexachloroplatinate') * 34, 7500, 0)
        .fluidOutputs(fluid('alluvial_platinum_mother_liquor') * 14000)
        .duration(240)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('alluvial_platinum_mother_liquor') * 14000)
        .chancedOutput(metaitem('dustZincChloride') * 3, 9000, 0)
        .fluidOutputs(fluid('ammonium_chloride_solution') * 1000)
        .fluidOutputs(fluid('water') * 13000)
        .fluidOutputs(fluid('hydrogen_chloride') * 4000)
        .duration(240)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustAmmoniumHexachloroplatinate') * 17)
        .fluidInputs(fluid('hydrogen') * 4000)
        .outputs(metaitem('sponge.platinum'))
        .fluidOutputs(fluid('ammonia') * 2000)
        .fluidOutputs(fluid('hydrogen_chloride') * 6000)
        .duration(240)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    MACERATOR.recipeBuilder()
        .inputs(metaitem('sponge.platinum'))
        .outputs(metaitem('dustPlatinum'))
        .duration(240)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    BR.recipeBuilder()
        .notConsumable(ore('springCupronickel'))
        .fluidInputs(fluid('alluvial_platinum_mother_liquor') * 14000)
        .fluidOutputs(fluid('alluvial_divalent_palladium_solution') * 14000)
        .fluidOutputs(fluid('chlorine') * 50)
        .duration(120)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    CRYSTALLIZER.recipeBuilder()
        .fluidInputs(fluid('ammonia_solution') * 2000)
        .fluidInputs(fluid('alluvial_divalent_palladium_solution') * 14000) //(H2PdCl4)(ZnCl2)(HCl)4(H2O)14
        .chancedOutput(metaitem('dustDiamminedichloropalladium') * 11, 7500, 0)
        .fluidOutputs(fluid('alluvial_palladium_mother_liquor') * 16000) //(NH4Cl)2(ZnCl2)(HCl)4(H2O)16
        .duration(120)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustDiamminedichloropalladium') * 11)
        .fluidInputs(fluid('hydrogen') * 2000)
        .outputs(metaitem('dustPalladium'))
        .fluidOutputs(fluid('ammonia') * 2000)
        .fluidOutputs(fluid('hydrogen_chloride') * 2000)
        .duration(240)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('alluvial_palladium_mother_liquor') * 16000)
        .chancedOutput(metaitem('dustZincChloride') * 3, 9500, 0)
        .fluidOutputs(fluid('ammonium_chloride_solution') * 2000)
        .fluidOutputs(fluid('water') * 14000)
        .fluidOutputs(fluid('hydrogen_chloride') * 4000)
        .duration(240)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

// PGM PROCESSING Tier 2

    // Input: PGM Oxides
    // Output: H2PtCl6, H2PdCl4, H3RhCl6, H2IrCl6, H3RuCl6, H2OsCl6
    BR.recipeBuilder()
        .inputs(ore('dustPgmConcentrate'))
        .fluidInputs(fluid('chlorine') * 880)
        .fluidInputs(fluid('hydrochloric_acid') * 5100)
        .fluidOutputs(fluid('pgm_solution') * 1000)
        .duration(200)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    // OSMIUM & RUTHENIUM (BASED ON PROCESS AT LONMIN'S WESTERN PLATINUM REFINERY)

        // 1. Contacting PGM liquor with an oxidizing solution (NaClO3) to form a volatile RuO4/OsO4 vapor; 
        // 2. In acidic media, osmium is oxidized by peroxodisulfate to form OsO4
        // 3. Bubbling the OsO4 vapor through a KOH trapping solution to form an amount of K2[OsO4(OH)2] dissolved in the KOH trapping solution;
        // 4. Contacting the dissolved K2[OsO4(OH)2] with a reducing agent (ethanol) to form an Os precipitate
        // 5. Separating the Os precipitate from the KOH trapping solution
        // 15% Ru and 1% Os
        // 3H2OsCl6 + 2NaClO3 + 6H2O -> 3OsO4 + 2NaCl + 18HCl 
        // 6H3RuCl6 + 5NaClO3 + 9H2O -> 6RuO4 + 5NaCl + 36HCl

        // Oxidative Distillation

        CSTR.recipeBuilder()
            .fluidInputs(fluid('pgm_solution') * 1000)
            .fluidInputs(fluid('sodium_chlorate_solution') * 130)
            .fluidOutputs(fluid('chlorate_treated_pgm_solution') * 1130)
            .duration(20)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        VACUUM_CHAMBER.recipeBuilder()
            .fluidInputs(fluid('chlorate_treated_pgm_solution') * 1130)
            .fluidOutputs(fluid('os_ru_tetroxide_mixture') * 160)
            .fluidOutputs(fluid('os_ru_free_pgm_solution') * 1130)
            .duration(20)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        // Redissolution & Reduction
        // OsO4 + 10HCl -> H2OsCl6 + 2Cl2 + 4H2O
        // 2RuO4 + 22HCl -> 2H3RuCl6 + 5Cl2 + 8H2O

        CSTR.recipeBuilder()
            .fluidInputs(fluid('os_ru_tetroxide_mixture') * 160)
            .fluidInputs(fluid('hydrochloric_acid') * 1750)
            .fluidOutputs(fluid('os_ru_solution') * 640)
            .fluidOutputs(fluid('chlorine') * 790)
            .duration(6)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        // Selective oxidation of OsO4
        // H2OsCl6 + 2H2O2 -> OsO4 + 6HCl

        CSTR.recipeBuilder()
            .fluidInputs(fluid('os_ru_solution') * 640)
            .fluidInputs(fluid('hydrogen_peroxide_solution') * 50)
            .fluidOutputs(fluid('hexachlororuthenic_acid_solution') * 690)
            .fluidOutputs(fluid('osmium_tetroxide') * 10)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        // Ruthenium precipitation
        // H3RuCl6 + 3NH3 -> (NH4)3[RuCl6]

        BR.recipeBuilder()
            .fluidInputs(fluid('hexachlororuthenic_acid_solution') * 690)
            .fluidInputs(fluid('ammonium_chloride_solution') * 450)
            .fluidOutputs(fluid('distilled_water') * 60)
            .chancedOutput(metaitem('dustAmmoniumHexachlororuthenate') * 22, 1500, 0)
            .fluidOutputs(fluid('hydrochloric_acid') * 510)
            .duration(60)
            .EUt(Globals.voltAmps[1])
            .buildAndRegister()

        // (NH4)3[RuCl6] + 1.5H2 -> Ru + 3NH3 + 6HCl 

        REACTION_FURNACE.recipeBuilder()
            .inputs(ore('dustAmmoniumHexachlororuthenate') * 22)
            .fluidInputs(fluid('hydrogen') * 3000)
            .outputs(metaitem('sponge.ruthenium'))
            .fluidOutputs(fluid('ammonia') * 3000)
            .fluidOutputs(fluid('hydrogen_chloride') * 6000)
            .duration(240)
            .EUt(Globals.voltAmps[3])
            .buildAndRegister()

        MACERATOR.recipeBuilder()
            .inputs(metaitem('sponge.ruthenium'))
            .outputs(metaitem('dustRuthenium'))
            .duration(240)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        // Osmium adsorption
        // 2OsO4 + C2H5OH + 5KOH -> CH3COOK + 2K2[OsO2(OH)4]

        BR.recipeBuilder()
            .fluidInputs(fluid('osmium_tetroxide') * 2000)
            .fluidInputs(fluid('potassium_hydroxide_solution') * 5000)
            .fluidInputs(fluid('ethanol') * 1000)
            .outputs(metaitem('dustPotassiumOsmate') * 26)
            .fluidOutputs(fluid('wastewater') * 5000) //CH3COOK + 5H2O
            .duration(20)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        // Osmium reduction
        // K2[OsO2(OH)4] + 3H2 → Os + 2KOH + 4H2O

        REACTION_FURNACE.recipeBuilder()
            .inputs(ore('dustPotassiumOsmate') * 13)
            .fluidInputs(fluid('hydrogen') * 6000)
            .outputs(metaitem('sponge.osmium'))
            .outputs(metaitem('dustPotassiumHydroxide') * 6)
            .fluidOutputs(fluid('dense_steam') * 4000)
            .duration(240)
            .EUt(Globals.voltAmps[3])
            .buildAndRegister()

        MACERATOR.recipeBuilder()
            .inputs(metaitem('sponge.osmium'))
            .outputs(metaitem('dustOsmium'))
            .duration(240)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

    // SILVER

        // Distillative removal of HCl
        // Output: AgCl precipitate
        // Output: Solution Pt,Pd,Rh,Ir,Au

        DISTILLATION_TOWER.recipeBuilder()
            .fluidInputs(fluid('os_ru_free_pgm_solution') * 1130)
            .chancedOutput(metaitem('dustSilverChloride') * 2, 200, 0)
            .fluidOutputs(fluid('silver_free_pgm_solution') * 1130)
            .fluidOutputs(fluid('hydrogen_chloride') * 980)
            .duration(100)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

    // GOLD (BASED ON THE ACTON PROCESS)

        // 1. Liquid-liquid extraction
        // 2. Stripping w/ oxalic acid
        // Output: H(AuCl4) extract
        // Output: Raffinate Pt,Pd,Rh,Ir,Ru

        // Extraction with dibutyl carbitol

        CENTRIFUGE.recipeBuilder()
            .fluidInputs(fluid('silver_free_pgm_solution') * 1130)
            .fluidInputs(fluid('dibutyl_carbitol') * 10)
            .fluidOutputs(fluid('gold_extract') * 10)
            .fluidOutputs(fluid('gold_free_pgm_solution') * 1130)
            .duration(100)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        // Scrubbing gold extract

        CENTRIFUGE.recipeBuilder() 
            .fluidInputs(fluid('gold_extract') * 1000)
            .fluidInputs(fluid('diluted_hydrochloric_acid') * 2000)
            .fluidOutputs(fluid('scrubbed_gold_extract') * 1000)
            .fluidOutputs(fluid('acidic_wastewater') * 2000)
            .EUt(240)
            .duration(120)
            .buildAndRegister()

        // Stripping with oxalic acid
        // 2HAuCl4 + 3C2H2O4 -> 2Au + 8HCl + 6CO2

        BR.recipeBuilder() 
            .fluidInputs(fluid('scrubbed_gold_extract') * 1000)
            .fluidInputs(fluid('oxalic_acid_solution') * 1500)
            .fluidInputs(fluid('distilled_water') * 2500)
            .fluidOutputs(fluid('dibutyl_carbitol') * 1000)
            .fluidOutputs(fluid('hydrochloric_acid') * 4000)
            .fluidOutputs(fluid('carbon_dioxide') * 3000)
            .outputs(metaitem('dustGold'))
            .EUt(240)
            .duration(120)
            .buildAndRegister()

    //PLATINUM

        // Reduction of Ir(IV) to Ir(III) w/ Fe(II)
        // Precipitation with NH4Cl
        // Output: (NH4)2(PtCl6) precipitate
        // Output: Solution Pd,Rh,Ir

        // Ir(IV) + Fe(II) -> Ir(III) + Fe(III)
        // H2PtCl6 + 2NH4Cl -> (NH4)2PtCl6 + 2HCl

        BR.recipeBuilder()
            .fluidInputs(fluid('iron_ii_chloride_solution') * 60)
            .fluidInputs(fluid('gold_free_pgm_solution') * 1130)
            .fluidOutputs(fluid('reduced_gold_free_pgm_solution') * 1190)
            .duration(20)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        BR.recipeBuilder()
            .fluidInputs(fluid('reduced_gold_free_pgm_solution') * 1190)
            .fluidInputs(fluid('ammonium_chloride_solution') * 600)
            .fluidOutputs(fluid('platinum_free_pgm_solution') * 1790)
            .chancedOutput(metaitem('dustAmmoniumHexachloroplatinate') * 17, 3000, 0)
            .duration(20)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

    //PALLADIUM

        //Solvent extraction with DNHS
        //Stripping with NH3(aq)
        //Output: (Pd(NH3)4)Cl2 extract
        //Output: Solution Ir,Rh

        //Solution + di-n-hexyl-sulfide -> palladium extract + palladium-free pgm solution
        //Extractant + (NH3)(H2O) -> (Pd(NH3)4)Cl2)
        //(Pd(NH3)4)Cl2) + 2HCl -> (Pd(NH3)2)Cl2) + 2NH4Cl
        //3[(Pd(NH3)2)Cl2)] -(inert atmosphere)-> 3Pd + 4NH4Cl + 2HCl + N2

        CENTRIFUGE.recipeBuilder()
            .fluidInputs(fluid('platinum_free_pgm_solution') * 1790)
            .fluidInputs(fluid('di_n_hexyl_sulfide') * 400)
            .fluidOutputs(fluid('palladium_extract') * 400)
            .fluidOutputs(fluid('rh_ir_solution') * 1790)
            .duration(100)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        CENTRIFUGE.recipeBuilder()
            .fluidInputs(fluid('palladium_extract') * 1000)
            .fluidInputs(fluid('ammonia_solution') * 4000)
            .fluidOutputs(fluid('di_n_hexyl_sulfide') * 1000)
            .fluidOutputs(fluid('tetraamminepalladium_dichloride_solution') * 4000)
            .duration(100)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        // Pd(NH3)4Cl2 + 2HCl -> 2NH4Cl + Pd(NH3)2Cl2

        BR.recipeBuilder()
            .fluidInputs(fluid('tetraamminepalladium_dichloride_solution') * 4000)
            .fluidInputs(fluid('hydrogen_chloride') * 2000)
            .fluidOutputs(fluid('diluted_ammonium_chloride_solution') * 4000)
            .outputs(metaitem('dustDiamminedichloropalladium') * 11)
            .duration(20)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

    //IRIDIUM

        //Oxidation with Cl2
        //Solvent extraction with TBP
        //Stripping with H2O
        //Output: H2(IrCl6) extract
        //Output: Solution Rh

        // H3IrCl6 + 0.5Cl2 -> H2IrCl6 + HCl
        
        BCR.recipeBuilder()
            .fluidInputs(fluid('chlorine') * 10)
            .fluidInputs(fluid('rh_ir_solution') * 1790)
            .fluidOutputs(fluid('chlorinated_rh_ir_solution') * 1790)
            .duration(100)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        CENTRIFUGE.recipeBuilder()
            .fluidInputs(fluid('tributyl_phosphate_extraction_mixture') * 100)
            .fluidInputs(fluid('chlorinated_rh_ir_solution') * 1790)
            .fluidOutputs(fluid('hexachlororhodic_acid_solution') * 1790)
            .fluidOutputs(fluid('iridium_extract') * 100)
            .duration(20)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        CENTRIFUGE.recipeBuilder()
            .fluidInputs(fluid('iridium_extract') * 10000)
            .fluidInputs(fluid('diluted_hydrochloric_acid') * 1000)
            .fluidOutputs(fluid('hexachloroiridic_acid_solution') * 2000)
            .fluidOutputs(fluid('tributyl_phosphate_extraction_mixture') * 10000)
            .duration(80)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        //H2IrCl6 + 2NH4Cl -> (NH4)2(IrCl6) + 2HCl

        CRYSTALLIZER.recipeBuilder()
            .fluidInputs(fluid('hexachloroiridic_acid_solution') * 2000)
            .fluidInputs(fluid('ammonium_chloride_solution') * 2000)
            .outputs(metaitem('dustAmmoniumHexachloroiridate') * 17)
            .fluidOutputs(fluid('diluted_hydrochloric_acid') * 4000)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        // (NH4)2(IrCl6) + 2H2 -> Ir + 2NH3 + 6HCl

        REACTION_FURNACE.recipeBuilder()
            .inputs(ore('dustAmmoniumHexachloroiridate') * 17)
            .fluidInputs(fluid('hydrogen') * 4000)
            .outputs(metaitem('sponge.iridium'))
            .fluidOutputs(fluid('ammonia') * 2000)
            .fluidOutputs(fluid('hydrogen_chloride') * 6000)
            .duration(240)
            .EUt(Globals.voltAmps[3])
            .buildAndRegister()

        MACERATOR.recipeBuilder()
            .inputs(metaitem('sponge.iridium'))
            .outputs(metaitem('dustIridium'))
            .duration(240)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

    //RHODIUM

        // Crystallization
        // Output: (NH4)3(RhCl6) crystals

        CRYSTALLIZER.recipeBuilder()
            .fluidInputs(fluid('hexachlororhodic_acid_solution') * 8950)
            .inputs(ore('dustAmmoniumChloride') * 9)
            .chancedOutput(metaitem('dustAmmoniumHexachlororhodate') * 21, 5000, 0)
            .fluidOutputs(fluid('acidic_wastewater') * 8950)
            .duration(200)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        // (NH4)3RhCl6 + 1.5H2 -> Rh + 3NH3 + 6HCl

        REACTION_FURNACE.recipeBuilder()
            .inputs(ore('dustAmmoniumHexachlororhodate') * 21)
            .fluidInputs(fluid('hydrogen') * 3000)
            .outputs(metaitem('sponge.rhodium'))
            .fluidOutputs(fluid('ammonia') * 3000)
            .fluidOutputs(fluid('hydrogen_chloride') * 6000)
            .duration(240)
            .EUt(Globals.voltAmps[3])
            .buildAndRegister()

        MACERATOR.recipeBuilder()
            .inputs(metaitem('sponge.rhodium'))
            .outputs(metaitem('dustRhodium'))
            .duration(240)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

// PGM PROCESSING Tier 3 (SHELVED)

//Begin with HCl solution of Pt,Pd,Rh,Ir,Au,Ag,Ru

//Distillative removal of HCl
//Dilution with water
//Output: AgCl precipitate
//Output: Solution Pt,Pd,Rh,Ir,Au,Ru

//Solvent Extraction with MIBK
//Reduction
//Output: Au precipitate 
//Output: Solution Pt,Pd,Rh,Ir,Ru

//Solvent Extraction with oxime
//Stripping
//Output: H2(PdCl4) Solution
//Output: Solution Pt,Rh,Ir,Ru

//Solvent Extraction with amine
//Stripping
//Output: H2(PtCl6) Solution
//Output: Solution Ir,Rh,RU

//Removal of NH4+
//Oxidative Distillation
//Output: RuO4 distillate
//Output: Solution Ru,Ir

//Amine Extraction
//Stripping
//Output: H2(IrCl6) Solution
//Output: Solution Rh

//Ion Exchange
//Elution
//Output: H3(RhCl6) Solution


import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// HMDS resist adhesion promoter

CSTR.recipeBuilder()
    .fluidInputs(fluid('trimethylsilyl_chloride') * 100)
    .fluidInputs(fluid('ammonia') * 150)
    .fluidInputs(fluid('hexane') * 50)
    .fluidOutputs(fluid('hexamethyldisilazane_solution') * 100)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('hexamethyldisilazane_solution') * 2000)
    .outputs(metaitem('dustAmmoniumChloride') * 12)
    .fluidOutputs(fluid('hexamethyldisilazane') * 1000)
    .fluidOutputs(fluid('hexane') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// Novolac-based photoresists (i-line)

    // PGMEA solvent

    CSTR.recipeBuilder()
        .fluidInputs(fluid('propylene_oxide') * 50)
        .fluidInputs(fluid('methanol') * 50)
        .fluidOutputs(fluid('propylene_glycol_methyl_ether') * 50)
        .duration(5)
        .EUt(VA[LV])
        .buildAndRegister();

    BR.recipeBuilder()
        .fluidInputs(fluid('propylene_glycol_methyl_ether') * 1000)
        .fluidInputs(fluid('acetic_acid') * 1000)
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .fluidOutputs(fluid('propylene_glycol_methyl_ether_acetate_solution') * 2100)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

    SIEVE_DT.recipeBuilder()
        .notConsumable(fluid('toluene') * 100)
        .fluidInputs(fluid('propylene_glycol_methyl_ether_acetate_solution') * 2100)
        .fluidOutputs(fluid('sulfuric_acid') * 100)
        .fluidOutputs(fluid('propylene_glycol_methyl_ether_acetate') * 1000)
        .fluidOutputs(fluid('water') * 1000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

    // Ethyl lactate cosolvent

    CSTR.recipeBuilder()
        .fluidInputs(fluid('lactic_acid_solution') * 50)
        .fluidInputs(fluid('ethanol') * 50)
        .fluidInputs(fluid('sulfuric_acid') * 50)
        .fluidOutputs(fluid('ethyl_lactate_solution') * 200)
        .duration(12)
        .EUt(VA[LV])
        .buildAndRegister()

    SIEVE_DT.recipeBuilder()
        .notConsumable(fluid('toluene') * 100)
        .fluidInputs(fluid('ethyl_lactate_solution') * 4000)
        .fluidOutputs(fluid('sulfuric_acid') * 1000)
        .fluidOutputs(fluid('ethyl_lactate') * 1000)
        .fluidOutputs(fluid('water') * 2000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

    // Diazonaphthoquinone

    CSTR.recipeBuilder()
        .fluidInputs(fluid('naphthalene') * 50)
        .fluidInputs(fluid('oleum') * 300)
        .fluidOutputs(fluid('naphthalenedisulfonic_acid_solution') * 200)
        .duration(20)
        .EUt(VA[LV])
        .buildAndRegister()
        
    CRYSTALLIZER.recipeBuilder()
        .notConsumable(fluid('water') * 4000)
        .fluidInputs(fluid('naphthalenedisulfonic_acid_solution') * 4000)
        .chancedOutput(metaitem('dustOneFiveNaphthalenedisulfonicAcid'), 5300, 0) // 1,6 may be separated from the water filtrate if necessary later.  
        .fluidOutputs(fluid('acidic_wastewater') * 8000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

    BR.recipeBuilder()
        .inputs(ore('dustOneFiveNaphthalenedisulfonicAcid'))
        .fluidInputs(fluid('sodium_hydroxide') * 432)
        .fluidInputs(fluid('distilled_water') * 1000)
        .fluidOutputs(fluid('sodium_naphthol_sulfonate_solution') * 1000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

    CRYSTALLIZER.recipeBuilder()
        .inputs(ore('dustSalt') * 2)
        .fluidInputs(fluid('sodium_naphthol_sulfonate_solution') * 1000)
        .outputs(metaitem('dustSodiumOneNaphtholFiveSulfonate'))
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

    BR.recipeBuilder()
        .inputs(metaitem('dustSodiumOneNaphtholFiveSulfonate'))
        .inputs(ore('dustSodiumNitrite') * 4)
        .fluidInputs(fluid('sulfuric_acid') * 1000)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('two_nitroso_one_naphthol_five_sulfonic_acid_solution') * 1000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

    BR.recipeBuilder()
        .inputs(ore('dustSodiumSulfide') * 3)
        .fluidInputs(fluid('two_nitroso_one_naphthol_five_sulfonic_acid_solution') * 2000)
        .fluidInputs(fluid('diluted_sulfuric_acid') * 2000)
        .fluidOutputs(fluid('diaminonapthoquinone_sulfonic_acid_solution') * 2000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

    BR.recipeBuilder()
        .inputs(ore('dustSodiumNitrite') * 4)
        .inputs(ore('dustTinyCopperSulfate'))
        .fluidInputs(fluid('diaminonapthoquinone_sulfonic_acid_solution') * 1000)
        .fluidOutputs(fluid('diazonaphthoquinone_sulfonic_acid_solution') * 2000)
        .duration(80)
        .EUt(VA[MV])
        .buildAndRegister();

    CRYSTALLIZER.recipeBuilder()
        .fluidInputs(fluid('diazonaphthoquinone_sulfonic_acid_solution') * 2000)
        .outputs(metaitem('dustDiazonaphthoquinoneFiveSulfonicAcid'))
        .fluidOutputs(fluid('acidic_wastewater') * 2000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

    BR.recipeBuilder()
        .inputs(ore('dustDiazonaphthoquinoneFiveSulfonicAcid'))
        .fluidInputs(fluid('chlorosulfuric_acid') * 1000)
        .outputs(ore('dustDiazonaphthoquinoneFiveSulfonylChloride'))
        .fluidOutputs(fluid('hydrogen_chloride') * 1000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

    // Ballast (2,3,4-trihydroxybenzophenone)

    CSTR.recipeBuilder()
        .fluidInputs(fluid('tannic_acid_solution') * 1000)
        .fluidInputs(fluid('water') * 8000)
        .fluidInputs(fluid('sulfuric_acid') * 1000)
        .fluidOutputs(fluid('gallic_acid_solution') * 2000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister();

    CRYSTALLIZER.recipeBuilder()
        .fluidInputs(fluid('gallic_acid_solution') * 2000)
        .outputs(metaitem('dustGallicAcid') * 8)
        .fluidOutputs(fluid('acidic_wastewater') * 2000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister();

    ROASTER.recipeBuilder()
        .inputs(ore('dustGallicAcid'))
        .outputs(metaitem('dustPyrogallol'))
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .duration(100)
        .EUt(VA[MV])
        .buildAndRegister();

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedSupportedAluminiumChloride'))
        .inputs(ore('dustPyrogallol'))
        .fluidInputs(fluid('benzoyl_chloride') * 1000)
        .outputs(metaitem('dustTwoThreeFourTrihydroxybenzophenone'))
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

    // Final DNQ assembly

    BR.recipeBuilder()
        .inputs(ore('dustTwoThreeFourTrihydroxybenzophenone'))
        .inputs(ore('dustDiazonaphthoquinoneFiveSulfonylChloride') * 3)
        .fluidInputs(fluid('acetone') * 3000)
        .fluidOutputs(fluid('diazonaphthoquinone_five_sulfonate_ester_solution') * 3000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

    DT.recipeBuilder()
        .fluidInputs(fluid('diazonaphthoquinone_five_sulfonate_ester_solution') * 1000)
        .outputs(metaitem('dustDiazonaphthoquinoneFiveSulfonateEster') * 29)
        .fluidOutputs(fluid('acetone') * 1000)
        .fluidOutputs(fluid('hydrogen_chloride') * 1000)
        .duration(30)
        .EUt(VA[LV])
        .buildAndRegister();

    // Novolac positive resist

    BLENDER.recipeBuilder()
        .inputs(ore('dustDiazonaphthoquinoneFiveSulfonateEster') * 10)
        .fluidInputs(fluid('propylene_glycol_methyl_ether_acetate') * 8750)
        .fluidInputs(fluid('ethyl_lactate') * 4900)
        .fluidInputs(fluid('phenolic_novolac_oligomer') * 6250)
        .fluidOutputs(fluid('novolac_resist') * 20000)
        .duration(400)
        .EUt(VA[HV])
        .buildAndRegister();

    // EBR Solvent, 70/30 

    BLENDER.recipeBuilder()
        .fluidInputs(fluid('propylene_glycol_methyl_ether') * 770)
        .fluidInputs(fluid('propylene_glycol_methyl_ether_acetate') * 230)
        .fluidOutputs(fluid('novolac_ebr_solvent') * 1000)
        .duration(50)
        .EUt(VA[HV])
        .buildAndRegister();

    // Bis-azide crosslinker (2,6-bis(4-azidobenzylidene)-4-methylcyclohexanone)

        // p-Aminobenzaldehyde, source: https://doi.org/10.1246/bcsj.52.2399

        BR.recipeBuilder()
            .inputs(ore('dustParaNitrotoluene') * 17)
            .inputs(ore('dustSodiumHydroxide') * 6)
            .inputs(ore('dustSodiumPolysulfide') * 3)
            .fluidInputs(fluid('ethanol_water_azeotrope') * 1000)
            .fluidOutputs(fluid('para_aminobenzaldehyde_solution') * 2000)
            .duration(100)
            .EUt(VA[LV])
            .buildAndRegister();

        CRYSTALLIZER.recipeBuilder()
            .fluidInputs(fluid('para_aminobenzaldehyde_solution') * 2000)
            .chancedOutput(metaitem('dustParaAminobenzaldehyde') * 16, 4000, 0)
            .fluidOutputs(fluid('wastewater') * 2000)
            .duration(100)
            .EUt(VA[LV])
            .buildAndRegister();

        // Diazotization

        BR.recipeBuilder()
            .inputs(ore('dustSodiumNitrite') * 4)
            .inputs(ore('dustParaAminobenzaldehyde') * 16)
            .fluidInputs(fluid('hydrochloric_acid') * 2000)
            .fluidOutputs(fluid('para_diazobenzaldehyde_chloride_solution') * 4000)
            .duration(120)
            .EUt(VA[MV])
            .buildAndRegister();

        BR.recipeBuilder()
            .inputs(ore('dustSodiumAzide') * 4)
            .fluidInputs(fluid('para_diazobenzaldehyde_chloride_solution') * 4000)
            .fluidOutputs(fluid('para_azidobenzaldehyde_solution') * 4000)
            .fluidOutputs(fluid('nitrogen') * 2000)
            .duration(120)
            .EUt(VA[MV])
            .buildAndRegister();

        CRYSTALLIZER.recipeBuilder()
            .notConsumable(ore('springCupronickel'))
            .fluidInputs(fluid('para_azidobenzaldehyde_solution') * 4000)
            .outputs(metaitem('dustParaAzidobenzaldehyde') * 16)
            .fluidOutputs(fluid('sodium_chloride_solution') * 2000)
            .fluidOutputs(fluid('dense_steam') * 2000)
            .duration(120)
            .EUt(VA[MV])
            .buildAndRegister();

        // Claisen-Schmidt condensation to produce bis-azide

        FIXED_BR.recipeBuilder()
            .notConsumable(ore('catalystBedSupportedNickel'))
            .fluidInputs(fluid('para_cresol') * 50)
            .fluidInputs(fluid('hydrogen') * 200)
            .fluidOutputs(fluid('four_methylcyclohexanone') * 50)
            .duration(6)    
            .EUt(VA[LV])
            .buildAndRegister()

        BR.recipeBuilder()
            .inputs(ore('dustParaAzidobenzaldehyde') * 32)
            .inputs(ore('dustSodiumHydroxide') * 3)
            .fluidInputs(fluid('four_methylcyclohexanone') * 1000)
            .fluidInputs(fluid('ethanol') * 1000)
            .fluidOutputs(fluid('bis_azide_crosslinker_solution') * 3000)
            .duration(120)
            .EUt(VA[MV])
            .buildAndRegister();

        CRYSTALLIZER.recipeBuilder()
            .fluidInputs(fluid('bis_azide_crosslinker_solution') * 3000)
            .outputs(metaitem('dustBisAzideCrosslinker') * 64)
            .fluidOutputs(fluid('wastewater') * 3000)
            .duration(120)
            .EUt(VA[MV])
            .buildAndRegister();

    // Novolac negative liftoff resist

    BLENDER.recipeBuilder()
        .inputs(ore('dustBisAzideCrosslinker') * 5)
        .fluidInputs(fluid('propylene_glycol_methyl_ether_acetate') * 8750)
        .fluidInputs(fluid('ethyl_lactate') * 4900)
        .fluidInputs(fluid('phenolic_novolac_resin') * 6250)
        .fluidOutputs(fluid('novolac_liftoff_resist') * 20000)
        .duration(400)
        .EUt(VA[HV])
        .buildAndRegister();

// Acrylate dry-film photoresists

    // Acrylic Acid

        // Reppe route

        ROASTER.recipeBuilder()
            .inputs(ore('dustCopper'))
            .inputs(ore('dustNickel'))
            .fluidInputs(fluid('bromine') * 4000)
            .outputs(metaitem('dustAcrylicCatalyst'))
            .duration(200)
            .EUt(VA[MV])
            .buildAndRegister()

        REACTION_FURNACE.recipeBuilder()
            .notConsumable(ore('dustAcrylicCatalyst'))
            .fluidInputs(fluid('acetylene') * 1000)
            .fluidInputs(fluid('carbon_monoxide') * 1000)
            .fluidInputs(fluid('water') * 1000)
            .fluidOutputs(fluid('acrylic_acid') * 1000)
            .duration(200)
            .EUt(VA[MV])
            .buildAndRegister()

        // Propene route
            
        REACTION_FURNACE.recipeBuilder()
            .inputs(ore('dustMolybdenumTrioxide') * 4)
            .inputs(ore('dustVanadiumPentoxide') * 7)
            .inputs(ore('dustAlumina') * 5)
            .outputs(metaitem('dustSupportedMolybdenumVanadium'))
            .duration(200)
            .EUt(VA[MV])
            .buildAndRegister()

        FIXED_BR.recipeBuilder()
            .notConsumable(ore('dustPhosphomolybdicAcid'))
            .fluidInputs(fluid('propene') * 50)
            .fluidInputs(fluid('oxygen') * 100)
            .fluidOutputs(fluid('acrolein') * 50)
            .fluidOutputs(fluid('dense_steam') * 50)
            .duration(8)
            .EUt(VA[MV])
            .buildAndRegister()

        FIXED_BR.recipeBuilder()
            .notConsumable(ore('catalystBedSupportedMolybdenumVanadium'))
            .fluidInputs(fluid('acrolein') * 50)
            .fluidInputs(fluid('oxygen') * 50)
            .fluidOutputs(fluid('acrylic_acid') * 50)
            .duration(8)
            .EUt(VA[MV])
            .buildAndRegister()

    // TMPTA

    BR.recipeBuilder()
        .fluidInputs(fluid('butyraldehyde') * 1000)
        .fluidInputs(fluid('formaldehyde') * 3000)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
        .outputs(metaitem('dustTrimethylolpropane'))
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

    BR.recipeBuilder()
        .notConsumable(ore('springCupronickel'))
        .notConsumable(fluid('sulfuric_acid') * 1000)
        .inputs(ore('dustTrimethylolpropane'))
        .fluidInputs(fluid('acrylic_acid') * 3000)
        .fluidOutputs(fluid('trimethylolpropane_triacrylate') * 1000)
        .fluidOutputs(fluid('dense_steam') * 3000)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

    // UV initiator, Michler's ketone

    CSTR.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 50)
        .fluidInputs(fluid('gtfo_aniline') * 50)
        .fluidInputs(fluid('methanol') * 100)
        .fluidOutputs(fluid('dimethylaniline_solution') * 200)
        .duration(5)
        .EUt(VA[LV])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('dimethylaniline_solution') * 4000)
        .fluidOutputs(fluid('sulfuric_acid') * 1000)
        .fluidOutputs(fluid('dimethylaniline') * 1000)
        .fluidOutputs(fluid('water') * 2000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

    BCR.recipeBuilder()
        .fluidInputs(fluid('dimethylaniline') * 2000)
        .fluidInputs(fluid('phosgene') * 1000)
        .outputs(metaitem('dustMichlersKetone'))
        .fluidOutputs(fluid('hydrogen_chloride') * 2000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

    // Final acrylate resist assembly

    BLENDER.recipeBuilder()
        .inputs(ore('dustSmallMichlersKetone'))
        .inputs(ore('dustPolymethylMethacrylate') * 3)
        .fluidInputs(fluid('dye_blue') * 100)
        .fluidInputs(fluid('trimethylolpropane_triacrylate') * 2000)
        .fluidInputs(fluid('methyl_ethyl_ketone') * 8000)
        .fluidOutputs(fluid('acrylate_resist_mixture') * 10000)
        .duration(500)
        .EUt(VA[HV])
        .buildAndRegister();

    DRYER.recipeBuilder()
        .inputs(ore('foilMylar'))
        .fluidInputs(fluid('acrylate_resist_mixture') * 5000)
        .outputs(metaitem('dry_film_photoresist'))
        .fluidOutputs(fluid('methyl_ethyl_ketone') * 4000)
        .duration(300)
        .EUt(VA[LV])
        .buildAndRegister()

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('dry_film_photoresist'))
        .inputs(ore('foilPlastic'))
        .outputs(metaitem('laminated_dry_film_photoresist') * 32)
        .duration(200)
        .EUt(VA[HV])
        .buildAndRegister()

// Polyhydroxystyrene-based photoresists (DUV/KrF, 248 nm)

    // Polyhydroxystyrene

    CSTR.recipeBuilder()
        .fluidInputs(fluid('ethylbenzene') * 50)
        .fluidInputs(fluid('sulfuric_acid') * 50)
        .fluidOutputs(fluid('para_ethylbenzenesulfonic_acid_solution') * 50)
        .duration(10)
        .EUt(VA[LV])
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('para_ethylbenzenesulfonic_acid_solution') * 1000)
        .outputs(metaitem('dustParaEthylbenzenesulfonicAcid'))
        .fluidOutputs(fluid('water') * 1000)
        .duration(20)
        .EUt(VA[LV])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustParaEthylbenzenesulfonicAcid'))
        .fluidInputs(fluid('sodium_hydroxide') * 432)
        .fluidInputs(fluid('distilled_water') * 1000)
        .outputs(metaitem('dustParaEthylphenol'))
        .fluidOutputs(fluid('sodium_bisulfate_solution') * 1000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedIronIiiOxide'))
        .inputs(ore('dustParaEthylphenol'))
        .outputs(metaitem('dustParaVinylphenol'))
        .fluidOutputs(fluid('hydrogen') * 2000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

    POLYMERIZATION_TANK.recipeBuilder()
        .inputs(ore('dustTinyAzobisisobutyronitrile'))
        .inputs(ore('dustParaVinylphenol'))
        .fluidInputs(fluid('dimethylformamide') * 1000)
        .fluidOutputs(fluid('polyhydroxystyrene_solution') * 1000)
        .duration(400)
        .EUt(VA[LV])
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('polyhydroxystyrene_solution') * 1000)
        .outputs(metaitem('dustPolyhydroxystyrene'))
        .fluidOutputs(fluid('dimethylformamide') * 1000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister();

    // Di-tert-butyl dicarbonate (Boc2O), t-BOC protecting group for PHS

    BR.recipeBuilder()
        .inputs(ore('dustAnyPurityPotassium'))
        .fluidInputs(fluid('tert_butanol') * 1000)
        .outputs(metaitem('dustPotassiumTertButoxide') * 15)
        .fluidOutputs(fluid('hydrogen') * 1000)
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()

    LCR.recipeBuilder()
        .inputs(ore('dustPotassiumTertButoxide') * 30)
        .inputs(ore('dustPotassiumCarbonate') * 6)
        .fluidInputs(fluid('distilled_water') * 4000)
        .fluidInputs(fluid('phosgene') * 1000)
        .fluidOutputs(fluid('di_tert_butyl_dicarbonate_solution') * 5000)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('di_tert_butyl_dicarbonate_solution') * 5000)
        .fluidOutputs(fluid('rock_salt_solution') * 4000)
        .fluidOutputs(fluid('di_tert_butyl_dicarbonate') * 1000)
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()

        // t-BOC protection

    BR.recipeBuilder()
        .inputs(ore('dustPolyhydroxystyrene') * 4)
        .fluidInputs(fluid('tetrahydrofuran') * 4000)
        .fluidInputs(fluid('pyridine') * 100)
        .fluidInputs(fluid('di_tert_butyl_dicarbonate') * 1000)
        .fluidOutputs(fluid('protected_polyhydroxystyrene_solution') * 5100)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('protected_polyhydroxystyrene_solution') * 5100)
        .outputs(metaitem('dustProtectedPolyhydroxystyrene'))
        .fluidOutputs(fluid('pyridine') * 100)
        .fluidOutputs(fluid('tert_butanol') * 1000)
        .fluidOutputs(fluid('tetrahydrofuran') * 4000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

    // KrF photoacid generator: Triphenylsulfonium triflate

        // Synthesis of triflate anion source

        ELECTROLYTIC_CELL.recipeBuilder()
            .notConsumable(metaitem('plateNickel'))
            .notConsumable(metaitem('plateCobalt'))
            .fluidInputs(fluid('methanesulfonic_acid') * 1000)
            .fluidInputs(fluid('hydrogen_fluoride') * 4000)
            .fluidOutputs(fluid('fluorinated_methanesulfonic_acid_mixture') * 2000)
            .fluidOutputs(fluid('hydrogen') * 6000)
            .duration(200)
            .EUt(VA[LV])
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('fluorinated_methanesulfonic_acid_mixture') * 2000)
            .fluidOutputs(fluid('trifluoromethanesulfonyl_fluoride') * 900)
            .fluidOutputs(fluid('water') * 1000)
            .duration(200)
            .EUt(VA[LV])
            .buildAndRegister()

        BR.recipeBuilder()
            .fluidInputs(fluid('trifluoromethanesulfonyl_fluoride') * 1000)
            .fluidInputs(fluid('distilled_water') * 2000)
            .fluidOutputs(fluid('triflic_acid_solution') * 2000)
            .duration(200)
            .EUt(VA[LV]) 
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('triflic_acid_solution') * 2000)
            .fluidOutputs(fluid('triflic_acid') * 1000)
            .fluidOutputs(fluid('hydrofluoric_acid') * 1000)
            .duration(200)
            .EUt(VA[LV]) 
            .buildAndRegister()

        BR.recipeBuilder()
            .inputs(ore('dustSodiumHydroxide') * 3)
            .fluidInputs(fluid('triflic_acid') * 1000)
            .fluidOutputs(fluid('sodium_triflate_solution') * 1000)
            .duration(200)
            .EUt(VA[LV]) 
            .buildAndRegister()

        DISTILLERY.recipeBuilder()
            .fluidInputs(fluid('sodium_triflate_solution') * 1000)
            .outputs(metaitem('dustSodiumTriflate') * 9)
            .fluidOutputs(fluid('water') * 1000)
            .duration(20)
            .EUt(VA[LV]) 
            .buildAndRegister()

        // Synthesis of triphenylsulfonium methanesulfonate + metathesis

        LCR.recipeBuilder()
            .inputs(ore('dustDiphenylSulfoxide'))
            .fluidInputs(fluid('benzene') * 1000)
            .fluidInputs(fluid('sulfonium_preparation_mixture') * 28000)
            .inputs(ore('dustSodiumTriflate') * 9)
            .outputs(metaitem('dustTriphenylsulfoniumTriflate') * 42)
            .fluidOutputs(fluid('spent_sulfonium_preparation_mixture') * 28000)
            .duration(100)
            .EUt(VA[HV])
            .buildAndRegister()

        DISTILLERY.recipeBuilder()
            .fluidInputs(fluid('spent_sulfonium_preparation_mixture') * 28000)
            .fluidOutputs(fluid('sulfonium_preparation_mixture') * 27000)
            .duration(100)
            .EUt(VA[LV])
            .buildAndRegister()

    // KrF resist final formulation

    BLENDER.recipeBuilder()
        .inputs(ore('dustProtectedPolyhydroxystyrene') * 5) // Polymer
        .inputs(ore('dustTriphenylsulfoniumTriflate') * 5) // PAG
        .fluidInputs(fluid('triethanolamine') * 10) // Base quencher
        .fluidInputs(fluid('propylene_glycol_methyl_ether_acetate') * 27000) // Solvent
        .fluidInputs(fluid('propylene_glycol_methyl_ether') * 9900) // Cosolvent
        .fluidOutputs(fluid('polyhydroxystyrene_resist') * 42000)
        .duration(500)
        .EUt(VA[EV])
        .buildAndRegister()

// KrF bottom antireflective coating (BARC)

    // Maleic anhydride copolymers with 2-aminoanthracene

    BR.recipeBuilder()
        .inputs(ore('dustPhthalicAnhydride') * 15)
        .fluidInputs(fluid('chlorobenzene') * 1000)
        .outputs(metaitem('dustTwoChloroanthraquinone'))
        .fluidOutputs(fluid('water') * 1000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister();

    BR.recipeBuilder()
        .inputs(ore('dustTwoChloroanthraquinone'))
        .fluidInputs(fluid('ammonia_solution') * 2000)
        .outputs(metaitem('dustTwoAminoanthraquinone'))
        .fluidOutputs(fluid('diluted_ammonium_chloride_solution') * 2000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister();

    BR.recipeBuilder()
        .inputs(ore('dustTwoAminoanthraquinone'))
        .inputs(ore('dustZinc') * 2)
        .fluidInputs(fluid('ammonia_solution') * 4000)
        .outputs(metaitem('dustTwoAminoanthracene'))
        .fluidOutputs(fluid('wastewater') * 4000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister();

    POLYMERIZATION_TANK.recipeBuilder()
        .inputs(ore('dustTinyAzobisisobutyronitrile'))
        .inputs(ore('dustMaleicAnhydride') * 9)
        .fluidInputs(fluid('styrene') * 1000)
        .fluidInputs(fluid('dimethylformamide') * 1000)
        .fluidOutputs(fluid('styrene_maleic_anhydride_solution') * 1000)
        .duration(400)
        .EUt(VA[LV])
        .buildAndRegister()

    BR.recipeBuilder()
        .notConsumable(ore('springCupronickel'))
        .inputs(ore('dustTwoAminoanthracene'))
        .fluidInputs(fluid('styrene_maleic_anhydride_solution') * 1000)
        .fluidOutputs(fluid('styrene_anthracenyl_maleimide_solution') * 2000)
        .duration(400)
        .EUt(VA[LV])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('styrene_anthracenyl_maleimide_solution') * 2000)
        .outputs(metaitem('dustStyreneAnthracenylMaleimide'))
        .fluidOutputs(fluid('dimethylformamide') * 1000)
        .fluidOutputs(fluid('water') * 1000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

    // Hexamethoxymethylmelamine

    BR.recipeBuilder()
        .inputs(ore('dustMelamine'))
        .fluidInputs(fluid('formaldehyde') * 6000)
        .fluidInputs(fluid('methanol') * 6000)
        .outputs(metaitem('dustHexamethoxymethylmelamine') * 57)
        .fluidOutputs(fluid('wastewater') * 6000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

    // Thermal acid generator: tripropylammonium triflate

    BR.recipeBuilder()
        .fluidInputs(fluid('tripropylamine') * 1000)
        .fluidInputs(fluid('triflic_acid') * 1000)
        .outputs(metaitem('dustTripropylamineTriflate') * 40)
        .duration(200)
        .EUt(VA[LV]) 
        .buildAndRegister()

    // Final mixing

    BLENDER.recipeBuilder
        .inputs(ore('dustTinyStyreneAnthracenylMaleimide') * 3)
        .inputs(ore('dustTripropylamineTriflate'))
        .inputs(ore('dustHexamethoxymethylmelamine') * 8)
        .fluidInputs(fluid('propylene_glycol_methyl_ether_acetate') * 25500)
        .fluidOutputs(fluid('krf_barc') * 26000)
        .duration(520)
        .EUt(VA[LV]) 
        .buildAndRegister()

// Acrylate-based photoresists (DUV/ArF, 193 nm)

    // Di(4-t-butyl)phenyliodinium nonaflate
        
        // Nonaflate source

        AUTOCLAVE.recipeBuilder()
            .notConsumable(ore('dustTinyHydroquinone'))
            .fluidInputs(fluid('butadiene') * 1000)
            .fluidInputs(fluid('sulfur_dioxide') * 1000)
            .outputs(metaitem('dustSulfolene') * 13)
            .duration(200)
            .EUt(VA[LV])
            .buildAndRegister()

        FIXED_BR.recipeBuilder()
            .notConsumable(ore('dustRaneyNickel'))
            .inputs(ore('dustSulfolene') * 13)
            .fluidInputs(fluid('hydrogen') * 2000)
            .fluidOutputs(fluid('sulfolane') * 1000)
            .duration(200)
            .EUt(VA[LV])
            .buildAndRegister()

        ELECTROLYTIC_CELL.recipeBuilder()
            .notConsumable(metaitem('plateNickel'))
            .notConsumable(metaitem('plateCobalt'))
            .fluidInputs(fluid('sulfolane') * 1000)
            .fluidInputs(fluid('hydrogen_fluoride') * 9000)
            .fluidOutputs(fluid('fluorinated_sulfolane_mixture') * 1000)
            .fluidOutputs(fluid('hydrogen') * 18000)
            .duration(200)
            .EUt(VA[LV])
            .buildAndRegister()
    
        DISTILLERY.recipeBuilder()
            .fluidInputs(fluid('fluorinated_sulfolane_mixture') * 1000)
            .fluidOutputs(fluid('perfluorobutanesulfonyl_fluoride') * 900)
            .duration(200)
            .EUt(VA[LV])
            .buildAndRegister()

        BR.recipeBuilder()
            .fluidInputs(fluid('perfluorobutanesulfonyl_fluoride') * 1000)
            .fluidInputs(fluid('distilled_water') * 2000)
            .fluidOutputs(fluid('nonaflic_acid_solution') * 2000)
            .duration(200)
            .EUt(VA[LV]) 
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('nonaflic_acid_solution') * 2000)
            .fluidOutputs(fluid('nonaflic_acid') * 1000)
            .fluidOutputs(fluid('hydrofluoric_acid') * 1000)
            .duration(200)
            .EUt(VA[LV]) 
            .buildAndRegister()

        // Synthesis of diaryliodonium salt

        FIXED_BR.recipeBuilder()
            .notConsumable(metaitem('catalystBedSupportedPolyphosphoricAcid'))
            .fluidInputs(fluid('isobutylene') * 50)
            .fluidInputs(fluid('hot_hp_benzene') * 50)
            .fluidOutputs(fluid('tert_butylbenzene') * 50)
            .duration(10)
            .EUt(VA[LV])
            .buildAndRegister()

        CSTR.recipeBuilder()
            .fluidInputs(fluid('tert_butylbenzene') * 50)
            .fluidInputs(fluid('nitration_mixture') * 100)
            .fluidOutputs(fluid('acidic_para_tert_butylnitrobenzene_mixture') * 150)
            .duration(5)
            .EUt(VA[MV])
            .buildAndRegister()

        PHASE_SEPARATOR.recipeBuilder()
            .fluidInputs(fluid('acidic_para_tert_butylnitrobenzene_mixture') * 3000)
            .fluidOutputs(fluid('para_tert_butylnitrobenzene_mixture') * 1000)
            .fluidOutputs(fluid('diluted_sulfuric_acid') * 2000)
            .duration(50)
            .buildAndRegister()

        FIXED_BR.recipeBuilder()
            .notConsumable(ore('catalystBedSupportedPalladium'))
            .fluidInputs(fluid('para_tert_butylnitrobenzene_mixture') * 50)
            .fluidInputs(fluid('hot_hp_hydrogen') * 150)
            .fluidOutputs(fluid('para_tert_butylaniline') * 50)
            .fluidOutputs(fluid('water') * 100)
            .duration(100)
            .EUt(VA[MV])
            .buildAndRegister()

        BR.recipeBuilder()
            .inputs(ore('dustSodiumNitrite') * 4)
            .inputs(ore('dustPotassiumIodide') * 2)
            .fluidInputs(fluid('para_tert_butylaniline') * 1000)
            .fluidInputs(fluid('hydrochloric_acid') * 2000)
            .fluidOutputs(fluid('para_tertbutyliodobenzene_solution') * 5000)
            .fluidOutputs(fluid('nitrogen') * 1000)
            .duration(120)
            .EUt(VA[MV])
            .buildAndRegister()

        SIEVE_DT.recipeBuilder()
            .fluidInputs(fluid('dense_steam') * 1000)
            .fluidInputs(fluid('para_tertbutyliodobenzene_solution') * 5000)
            .fluidOutputs(fluid('para_tertbutyliodobenzene') * 1000)
            .fluidOutputs(fluid('wastewater') * 5000)
            .duration(120)
            .EUt(VA[MV])
            .buildAndRegister()

        LCR.recipeBuilder()
            .fluidInputs(fluid('para_tertbutyliodobenzene') * 500)
            .fluidInputs(fluid('nonaflic_acid') * 500)
            .inputs(ore('dustTinyMetaChloroperoxybenzoicAcid'))
            .outputs(fluid('dustDiFourTertButylphenyliodoniumNonaflate') * 42)
            .duration(200)
            .EUt(VA[MV])
            .buildAndRegister()

    // Acrylate polymer

        // 2-methyl-2-adamantyl methacrylate (MAMA)

        FIXED_BR.recipeBuilder()
            .notConsumable(ore('cataylstBedSupportedPlatinum'))
            .fluidInputs(fluid('dicyclopentadiene') * 1000)
            .fluidInputs(fluid('hydrogen') * 4000)
            .outputs(metaitem('dustTricyclodecane'))
            .duration(200)
            .EUt(VA[MV])
            .buildAndRegister()

        FIXED_BR.recipeBuilder()
            .notConsumable(ore('catalystBedSupportedAluminiumChloride'))
            .inputs(ore('dustTricyclodecane'))
            .outputs(metaitem('dustAdamantane'))
            .duration(200)
            .EUt(VA[MV])
            .buildAndRegister()

        BR.recipeBuilder()
            .inputs(ore('dustAdamantane'))
            .fluidInputs(fluid('sulfuric_acid') * 2000)
            .outputs(metaitem('dustAdamantanone'))
            .fluidOutputs(fluid('wastewater') * 3000)
            .fluidOutputs(fluid('sulfur_dioxide') * 2000)
            .duration(200)
            .EUt(VA[MV])
            .buildAndRegister()

        BR.recipeBuilder()
            .inputs(ore('dustAdamantanone'))
            .fluidInputs(fluid('methylmagnesium_chloride_solution') * 1000)
            .fluidInputs(fluid('diluted_hydrochloric_acid') * 2000)
            .fluidOutputs(fluid('two_methyl_two_adamantanol_solution') * 3000)
            .duration(200)
            .EUt(VA[MV])
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('two_methyl_two_adamantanol_solution') * 3000)
            .outputs(metaitem('dustTwoMethylTwoAdamantanol'))
            .fluidOutputs(fluid('magnesium_chloride_solution') * 2000)
            .fluidOutputs(fluid('tetrahydrofuran') * 3000)
            .duration(80)
            .EUt(VA[MV])
            .buildAndRegister()

        BR.recipeBuilder()
            .inputs(ore('dustTwoMethylTwoAdamantanol'))
            .fluidInputs(fluid('methacrylic_acid') * 1000)
            .fluidInputs(fluid('sulfuric_acid') * 1000)
            .fluidOutputs(fluid('two_methyl_two_adamantyl_methacrylate') * 1000)
            .fluidOutputs(fluid('diluted_sulfuric_acid') * 200)
            .duration(10)
            .EUt(VA[LV])
            .buildAndRegister()

        // γ-butyrolactone methacrylate

            // α-hydroxy-γ-butyrolactone

            CSTR.recipeBuilder()
                .fluidInputs(fluid('gamma_butyrolactone') * 1000)
                .fluidInputs(fluid('bromine') * 1000)
                .fluidOutputs(fluid('alpha_bromo_gamma_butyrolactone') * 1000)
                .duration(100)
                .EUt(VA[LV])
                .buildAndRegister()
            
            CSTR.recipeBuilder()
                .fluidInputs(fluid('alpha_bromo_gamma_butyrolactone') * 1000)
                .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
                .fluidOutputs(fluid('alpha_hydroxy_gamma_butyrolactone') * 1000)
                .fluidOutputs(fluid('sodium_bromide_solution') * 1000)
                .duration(100)
                .EUt(VA[LV])
                .buildAndRegister()


// (EUV/tin plasma resists, 13.5 nm)

// SU-8 photoresist (MEMS, i-line)

    // Bisphenol A Novolac Epoxy

    POLYMERIZATION_TANK.recipeBuilder()
        .fluidInputs(fluid('epoxy') * 1008)
        .fluidInputs(fluid('formaldehyde') * 3000)
        .outputs(metaitem('dustBisphenolANovolacEpoxy') * 7)
        .duration(100)
        .EUt(VA[EV])
        .buildAndRegister()

    // Propylene Carbonate

    BCR.recipeBuilder()
        .fluidInputs(fluid('propylene_oxide') * 50)
        .fluidInputs(fluid('carbon_dioxide') * 50)
        .fluidOutputs(fluid('propylene_carbonate') * 50)
        .duration(5)
        .EUt(VA[LV])
        .buildAndRegister()

    // Triarylsulfonium Hexafluoroantimonate

    BR.recipeBuilder()
        .fluidInputs(fluid('antimony_trifluoride') * 576)
        .fluidInputs(fluid('fluorine') * 2000)
        .fluidOutputs(fluid('antimony_pentafluoride') * 1000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustSodiumFluoride') * 2)
        .fluidInputs(fluid('antimony_pentafluoride') * 1000)
        .outputs(metaitem('dustSodiumHexafluoroantimonate') * 8)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustSulfur') * 2)
        .fluidInputs(fluid('chlorine') * 2000)
        .fluidOutputs(fluid('disulfur_dichloride') * 1000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('benzene') * 2000)
        .fluidInputs(fluid('disulfur_dichloride') * 1000)
        .outputs(metaitem('dustSulfur'))
        .outputs(metaitem('dustDiphenylSulfide'))
        .fluidOutputs(fluid('hydrogen_chloride') * 2000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    BR.recipeBuilder()
        .notConsumable(ore('dustAluminiumChloride'))
        .fluidInputs(fluid('benzene') * 2000)
        .fluidInputs(fluid('sulfur_dioxide') * 1000)
        .outputs(metaitem('dustDiphenylSulfoxide'))
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustTinyPotassiumPersulfate'))
        .fluidInputs(fluid('methane') * 1000)
        .fluidInputs(fluid('oleum') * 3000)
        .fluidOutputs(fluid('methanesulfonic_acid_solution') * 3000)
        .duration(100)
        .EUt(VA[HV])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('methanesulfonic_acid_solution') * 3000)
        .fluidOutputs(fluid('sulfuric_acid') * 2000)
        .fluidOutputs(fluid('methanesulfonic_acid') * 1000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    MIXER.recipeBuilder()
        .inputs(ore('dustPhosphorusPentoxide'))
        .fluidInputs(fluid('methanesulfonic_acid') * 4000)
        .fluidOutputs(fluid('sulfonium_preparation_mixture') * 4000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustDiphenylSulfoxide'))
        .inputs(ore('dustDiphenylSulfide'))
        .inputs(ore('dustSodiumHexafluoroantimonate') * 8)
        .fluidInputs(fluid('sulfonium_preparation_mixture') * 28000)
        .outputs(metaitem('dustTriarylsulfoniumHexafluoroantimonate') * 52)
        .fluidOutputs(fluid('spent_sulfonium_preparation_mixture') * 28000)
        .duration(100)
        .EUt(VA[HV])
        .buildAndRegister()

/*
Bisphenol-A Novolac Epoxy
    Average Molar Mass: "430" g/mol (not real)
    Percent Weight: 50%
Gamma-Butyrolactone
    Molar Mass: 86.090 g/mol
    Percent Weight: 45%
Propylene Carbonate
    Molar Mass: 102.089 g/mol
    Percent Weight: 2.5%
Triarylsulfonium Hexafluoroantimonate
    Molar Mass: 607.29 g/mol
    Percent Weight: 2.5%

Assume 100g of material.
    50g Novolac
    45g Gamma Butyrolactone
    2.5g Propylene Carbonate
    2.5g Triarylsulfonium Hexafluoroantimonate

    116 mmol Bisphenol-A Novolac Epoxy
    523 mmol Gamma-Butyrolactone
    24.5 mmol Propylene Carbonate
    4.12 mmol Triarylsulfonium Hexafluoroantimonate

Total: 667.62 mmol.
    17.4% Bisphenol-A Novolac Epoxy
    78.3% Gamma-Butyrolactone
    3.67% Propylene Carbonate
    0.617% Triarylsulfonium Hexafluoroantimonate
*/

BLENDER.recipeBuilder()
    .inputs(ore('dustTriarylsulfoniumHexafluoroantimonate'))
    .inputs(ore('dustBisphenolANovolacEpoxy') * 7)
    .fluidInputs(fluid('propylene_carbonate') * 200)
    .fluidInputs(fluid('gamma_butyrolactone') * 4800)
    .fluidOutputs(fluid('su_eight') * 5000)
    .duration(100)
    .EUt(VA[EV])
    .buildAndRegister()

// Hydrogen silsesquioxane (HSQ) photoresist (e-beam)

BCR.recipeBuilder()
    .fluidInputs(fluid('toluene') * 50)
    .fluidInputs(fluid('sulfur_trioxide') * 50)
    .fluidInputs(fluid('water') * 50)
    .fluidOutputs(fluid('tosylic_acid_solution') * 50)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()

CSTR.recipeBuilder()
    .fluidInputs(fluid('trichlorosilane') * 50)
    .fluidInputs(fluid('toluene') * 300)
    .fluidOutputs(fluid('trichlorosilane_solution') * 350)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .notConsumable(fluid('tosylic_acid_solution') * 3500)
    .fluidInputs(fluid('trichlorosilane_solution') * 3500)
    .fluidOutputs(fluid('acidic_hydrogen_silsesquioxane_solution') * 3000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('acidic_hydrogen_silsesquioxane_solution') * 3000)
    .fluidInputs(fluid('distilled_water') * 100)
    .fluidOutputs(fluid('hydrogen_silsesquioxane_solution') * 3050)
    .fluidOutputs(fluid('acidic_wastewater') * 50)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

VACUUM_DT.recipeBuilder()
    .fluidInputs(fluid('hydrogen_silsesquioxane_solution') * 3050)
    .chancedOutput(metaitem('dustHydrogenSilsesquioxane'), 625, 0)
    .fluidOutputs(fluid('water') * 50)
    .fluidOutputs(fluid('toluene') * 3000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

/*
Let us produce a 5% wt solution of hydrogen silsesquioxane (H8Si8O12) in MIBK.

Assume 100g.
5g HSQ / (424.744 g/mol) = 0.0117718 mol HSQ
95g MIBK / (100.16 g/mol) = 0.94848 mol MIBK

Thus, HSQ should be 1.24% molar in MIBK
*/

MIXER.recipeBuilder()
    .inputs(ore('dustTinyHydrogenSilsesquioxane'))
    .fluidInputs(fluid('methyl_isobutyl_ketone') * 11000)
    .fluidOutputs(fluid('hydrogen_silsesquioxane_photoresist') * 11000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()
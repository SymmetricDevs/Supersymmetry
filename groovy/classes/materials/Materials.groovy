import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

class Materials {
        // @gaming I already asked tech if it would be possible to make a handler for solutions built into materials
        // IE a new material property which you would give the solvent(s) and that outgens the fluid for you
        // TODO: Sort the materials.

        // Element Materials



        // Isotope Materials

        // Ore Materials

        public static Material Sperrylite;
        public static Material Enargite;
        public static Material Proustite;
        public static Material Arsenopyrite;
        public static Material Tenorite;
        public static Material Fluorapatite;
        public static Material PreciousMetal;
        public static Material Kaolinite;
        public static Material Cuprite;
        public static Material Dilithium;
        public static Material Lignite;
        public static Material Anthracite;
        public static Material Anglesite;
        public static Material Celestine;
        public static Material Azurite;
        public static Material Hydrozincite;
        public static Material Cerussite;
        public static Material Proustite;
        public static Material Stephanite;
        public static Material Smithsonite;
        public static Material Acanthite;
        public static Material Thortveitite;

        // Roasted Ores

        public static Material RoastedSperrylite;
        
        // Ore Leach Residue

        public static Material EnargiteResidue;
        

        // Unknown Composition Materials

        public static Material EarthGreenhouseGas;
        public static Material RawMolecularSieve;
        public static Material MolecularSieve;
        public static Material WetMolecularSieve;
        public static Material FlueGas;
        public static Material ExhaustSteam;
        public static Material SmokeBombMix;
        public static Material SulfurousWater;
        public static Material OxideWater;
        public static Material MineralizedWater;
        public static Material SilicateWater;
        public static Material GraphiteWater;
        public static Material PhosphateWater;
        public static Material PreciousRunoff;
        public static Material RadioactiveRunoff;
        public static Material SiliconSolution;
        public static Material CalciumCarbonateSolution;        // TODO: Maybe give those components? 
        public static Material BentoniteClaySolution;
        public static Material SugaryWater;
        public static Material ClarifiedSugaryWater;
        public static Material Brine;
        public static Material ImpureSodiumAluminateSolution;
        public static Material ImpureSodaAshSolution;
        public static Material RedMud;
        public static Material ConcentratedRedMud;
        public static Material AmmoniaReactionMix;
        public static Material AmmoniaRichGas;
        public static Material GraphiteMix;
        public static Material Mash;
        public static Material WeedKiller;
        public static Material Pesticide;
        public static Material GrainSolution;
        public static Material YeastSolution;
        public static Material ImpureEthanol;
        public static Material BorateLiquor;  
        public static Material Asphalt;
        public static Material BlackAsh;
        
        // Petrochem Materials

        public static Material DilutedOil;
        public static Material DesaltedOil;

        public static Material DilutedOilLight;
        public static Material DesaltedOilLight;

        public static Material DilutedOilHeavy;
        public static Material DesaltedOilHeavy;
        
        public static Material FuelOil;
        public static Material SulfuricFuelOil;
        public static Material TreatedSulfuricFuelOil;
        public static Material UpgradedFuelOilMix;
        
        public static Material CrudeNaturalGas;
        public static Material SulfuricNaturalGas;
        public static Material TreatedSulfuricNaturalGas;
        public static Material AlkylatedNaturalGas;
        
        public static Material SulfuricRefineryGas;
        public static Material TreatedSulfuricRefineryGas;
        public static Material AlkylatedRefineryGas;
        
        public static Material SulfuricDiesel;
        public static Material TreatedSulfuricDiesel;
        public static Material UpgradedDieselMix;
        
        public static Material Kerosene;
        public static Material SulfuricKerosene;
        public static Material TreatedSulfuricKerosene;
        public static Material LightlySteamcrackedKerosene;
        public static Material LightlySteamcrackedKeroseneMix;
        public static Material SeverelySteamcrackedKerosene;
        public static Material SeverelySteamcrackedKeroseneMix;
        public static Material LightlyHydrocrackedKerosene;
        public static Material LightlyHydrocrackedKeroseneMix;
        public static Material SeverelyHydrocrackedKerosene;
        public static Material SeverelyHydrocrackedKeroseneMix;
        public static Material UpgradedKeroseneMix;
        
        public static Material SulfuricGasoline;
        public static Material TreatedSulfuricGasoline;
        public static Material LightlySteamcrackedGasoline;
        public static Material LightlySteamcrackedGasolineMix;
        public static Material SeverelySteamcrackedGasoline;
        public static Material SeverelySteamcrackedGasolineMix;
        public static Material LightlyHydrocrackedGasoline;
        public static Material LightlyHydrocrackedGasolineMix;
        public static Material SeverelyHydrocrackedGasoline;
        public static Material SeverelyHydrocrackedGasolineMix;

        public static Material TreatedSulfuricNaphtha;
        public static Material LightlySteamcrackedNaphtha;
        public static Material LightlySteamcrackedNaphthaMix;
        public static Material SeverelySteamcrackedNaphtha;
        public static Material SeverelySteamcrackedNaphthaMix;
        public static Material LightlyHydrocrackedNaphtha;
        public static Material LightlyHydrocrackedNaphthaMix;
        public static Material SeverelyHydrocrackedNaphtha;
        public static Material SeverelyHydrocrackedNaphthaMix;
        public static Material NaphthaReformate; 
        public static Material UpgradedNaphthaMix;

        public static Material LubricatingOil;
        public static Material UpgradedLubricatingOilMix;
        
        public static Material OilyBrine;
        public static Material SulfuricOilResidue;    
        public static Material DissolvedBitumen;
        public static Material SourGas;
        public static Material SlackWax;
        public static Material Resin;
        public static Material UncatalyzedSulfurousGases;
        public static Material NaphthaReformate;
        public static Material BtexExtract;
        public static Material BTEX;
        public static Material Syngas;
        public static Material ReformedSyngas;
        
        // First Degree Materials

        public static Material PotassiumBisulfate;
        public static Material SodiumBicarbonate;
        public static Material AmmoniumNitrate;
        public static Material SodiumNitrate;
        public static Material CalciumHydroxide;
        public static Material PotassiumHydroxide;
        public static Material PotassiumCarbonate;
        public static Material SodiumSilicate;
        public static Material SodiumAluminate;
        public static Material AmmoniumSulfate;
        public static Material SodiumFluoride;
        public static Material PotassiumFluoride;
        public static Material PotassiumTetrafluoroborate;
        public static Material SodiumBromide;
        public static Material HydrogenChloride;
        public static Material HydrogenFluoride;
        public static Material DilutedSaltwater;
        public static Material SodiumHydroxideSolution;
        public static Material IronIIIChlorideSolution;
        public static Material DiluteSaltpeterSolution;               
        public static Material LithiumSolution;
        public static Material HydrogenBromide;
        public static Material DiluteCalciumChlorideSolution;
        public static Material DiluteRockSaltSolution;
        public static Material DryCarbonMonoxide;
        public static Material AmmoniaSolution;
        public static Material SaltpeterSolution;
        public static Material SaltySaltpeterSolution;
        public static Material CarbonDisulfide;
        public static Material HighPressureWater;
        public static Material Cryolite;
        public static Material EthanolSolution;
        public static Material HeavyWater;
        public static Material HeavyHydrogenSulfide;                
        public static Material SemiHeavyHydrogenSulfide;
        public static Material SemiHeavyWater;
        public static Material ImpureSemiheavyWater;
        public static Material IsotopicallyPureHydrogenSulfide;
        public static Material ImpureSemiheavyHydrogenSulfide;
        public static Material ImpureHeavyHydrogenSulfide;
        public static Material SeaWater;
        public static Material TetrafluoroboricAcid;    
        public static Material BoronTrichloride;    
        public static Material ThioarseniteSolution;
        public static Material TetrachloroantimonateSolution;
        public static Material Arsine;
        public static Material ThioarsenateSolution;
        public static Material CobaltiteLeachSolution;
        public static Material ArsenopyriteLeachSolution;
        public static Material ArsenousAcid;
        public static Material AlkalineArseniteSolution;
        public static Material SaltyArsenousAcid;
        public static Material SperryliteWaste;
        public static Material AcidicCopperSolution;
        public static Material Fluix;
        public static Material PigIron;
        public static Material GreenCoke;        
        public static Material IronIIISulfate;
        public static Material AluminiumHydroxide;
        public static Material AluminiumTrifluoride;
        public static Material GalliumPhosphate;
        public static Material LithiumNiobate;
        public static Material LeadZirconateTitanite;
        public static Material BoricAcid;
        public static Material AmorphousBoron;
        public static Material MagnesiumOxide;
        public static Material BoronTrioxide;
        public static Material ZincChloride;
        public static Material SodiumTetraborate;
        public static Material ElectrolyticBoron;
        public static Material CalciumSulfate;
        public static Material IronIISulfide;
        public static Material PotassiumSulfate;
        public static Material WetAntimonyTrifluoride;        
        public static Material CalciumSulfide;
        public static Material CalciumSulfate;
        public static Material VanadiumPentoxide;
        public static Material PotassiumPersulfate;
        public static Material LithiumHydroxide;
        public static Material CalciumCarbide;
        public static Material IronIIChloride;
        public static Material CuprousOxide;
        public static Material LithiumBromide;
        public static Material IronIIIOxide;
        public static Material CopperIIChloride;
        public static Material SiliconCarbide;
        public static Material TungstenTrioxide;
        public static Material Alumina;
        public static Material BoronCarbide;
        public static Material SilverChloride;
        public static Material ArsenicIIISulfide;
        public static Material SodiumArsenide;
        public static Material ArsenicVSulfide;
        public static Material CopperSulfate;
        
        // Second Degree Materials

        public static Material AmmoniumChlorideSolution;
        public static Material PotassiumChlorideSolution;
        public static Material PotassiumBisulfateSolution;
        public static Material SodiumBisulfateSolution;
        public static Material CalciumChlorideSolution;
        public static Material SodaAshSolution;
        public static Material SodiumBicarbonateSolution;
        public static Material AmmoniumNitrateSolution;
        public static Material NitrateSolution;
        public static Material SodiumNitrateSolution;
        public static Material PotassiumHydroxideSolution;
        public static Material CalciumHydroxideSolution;
        public static Material DilutePotassiumCarbonateSolution;
        public static Material SodiumSilicateSolution;
        public static Material SodiumAluminateSolution;
        public static Material SodiumFluorideSolution;
        public static Material PotassiumFluorideSolution;
        public static Material PotassiumTetrafluoroborateSolution;
        public static Material SodiumBromideSolution;
        public static Material NitrateSaltMix;
        
        // Organic Chemistry Materials

        public static Material NMethylIIPyrrolidone;
        public static Material FourNitrochlorobenzene;
        public static Material FourNitroaniline;
        public static Material TwoTwoDichlorohydrazobenzene;
        public static Material ParaPhenylenediamine;
        public static Material SodiumPhenoxide;
        public static Material PhthaloylDichloride;
        public static Material Dichloroethane;
        public static Material Dimethylacetamide;
        public static Material CaprolactamOxime;
        public static Material TNT;
        public static Material Polystyrene;
        public static Material OneTwoDichlorobenzene;   
        public static Material CrudeStyrene;   
        public static Material ChlorinatedMethaneMixture;
        public static Material ChlorinatedChloromethaneMixture;
        public static Material ChlorinatedDichloromethaneMixture;
        public static Material ChloromethaneSolution;
        public static Material AcidicChlorodifluoromethane;
        public static Material AcidicTetrafluoroethylene;
        public static Material TrinitromethaneSolution;
        public static Material TetranitronmethaneSolution;
        public static Material ImpureDimethyldichloroSilane;
        public static Material ChlorinatedGlycerol;
        public static Material EpichlorohydrinSolution;
        public static Material AllylAlcoholMix;
        public static Material DiluteEpichlorohydrin;
        public static Material Isobutane;
        public static Material Isobutyle;
        public static Material Cyclohexane;
        public static Material SaltyNMethylIIPyrrolidone;
        public static Material MethylAcetateSolution;
        public static Material TwoNitrochlorobenzeneSolution;
        public static Material FourNitrochlorobenzeneSolution;
        public static Material FourNitroanilineSolution;
        public static Material ParaPhenylenediamineSolution;
        public static Material TwoTwoDichlorohydrazobenzeneSolution;
        public static Material DichlorobenzidineSolution;
        public static Material Xylene;
        public static Material Phosgene;
        public static Material PhthaloylDichlorideSolution;
        public static Material SodiumPhenoxideSolution;
        public static Material DiphenylIsophthalateSolution;
        public static Material DiaminobenzidineSolution;
        public static Material PBIPolymerizationMix;
        public static Material PBIPrePolymerFoam;
        public static Material ImpurePBISolution;
        public static Material DimethylacetamideSolution;
        public static Material PBISolution;
        public static Material PBIWaste;
        public static Material Hydroxylamine;
        public static Material DilutedCyclohexanone;
        public static Material CaprolactamOximeSolution;
        public static Material BisphenolADiglycidylEther;
        public static Material ImpureEpoxyResin;
        public static Material UncuredEpoxyResin;
        public static Material TNTSolution;
        public static Material VinylChlorideSolution;
        public static Material PolyvinylChlorideSolution;
        public static Material StyreneSolution;
        public static Material PolystyreneSolution;
        public static Material VinylAcetateSolution;
        public static Material PolyvinylAcetateSolution;
        public static Material Bleach;
        public static Material ImpureBleach;
        public static Material OneFourDichlorobenzeneSolution;
        public static Material OneTwoDichlorobenzeneSolution;
        public static Material DryEthanol;
        public static Material StyreneButadieneSolution;
        public static Material DiethylEther;
        public static Material DiethylEtherSolution;
        public static Material Bromobutane;
        public static Material DilutedBromobutane;
        public static Material Butyllithium;
        public static Material DilutedButyllithium;
        public static Material PolymerizedStyreneButadieneSolution;
        public static Material MethylFormate;
        public static Material MethylFormateSolution;
        public static Material Acetylene;
        public static Material DilutedDichloroethane;
        public static Material Formaldehyde;
        public static Material MethylamineMix;
        public static Material Methylamine;
        public static Material Trimethylamine;
        public static Material Butynediol;
        public static Material Butanediol;
        public static Material GammaButyrolactone;
        public static Material DilutedMethylIIPyrrolidone;
        public static Material DimethyldichlorosilaneEmulsion;
        public static Material TetrafluoroethyleneEmulsion;
        public static Material Dichloromethane;
        public static Material CarbonTetrachloride;
        public static Material PhthalicAcidSolution;
        public static Material Butanol;
        public static Material PolytetrafluoroethyleneSolution;
        public static Material MixedNitrochlorobenzeneSolution;
        public static Material MixedDichlorobenzeneSolution;
        public static Material Novolacs;
        public static Material SiliconTetrachloride;
        public static Material PurifiedSiliconTetrachloride;
        public static Material Ethanolamine;
        public static Material Diethanolamine;
        public static Material Triethanolamine;
        public static Material EthyleneGlycol;
        public static Material EthyleneOxide;
        public static Material EthanolamineMix;
        public static Material RichAmine;
        public static Material Pentane;
        public static Material Hexane;
        public static Material Furfural;
        public static Material Xylene;
        public static Material Cresol;
        public static Material Guaiacol;
        public static Material Xylenol;
        public static Material Creosol;
        public static Material Anthracene;
        public static Material PolyvinylideneFluorine;
        public static Material Methylenedianiline;
        public static Material MethyleneDiphenylDiisocyanate;
        public static Material Triethylenediamine;
        public static Material Polyurethane;
        public static Material MemoryFoam;
        public static Material Rayon;
        public static Material AlkaliCellulose;
        public static Material SodiumCelluloseXanthate;
        public static Material PMMA;
        public static Material Polypropylene;  
        public static Material PhthalicAnhydride;
        public static Material ImpureCaprolactam;
        
        // Third Degree Materials

        public static Material FurfuralSolution;

        // Thermodynamics/Greenhouse Materials     
        
        public static Material EarthlikeAir;
        

}

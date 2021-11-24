#priority 10
import mods.gregtech.multiblock.Builder;
import mods.gregtech.multiblock.FactoryBlockPattern;
import mods.gregtech.multiblock.RelativeDirection;
import mods.gregtech.multiblock.IBlockMatcher;
import mods.gregtech.multiblock.MultiblockAbility;
import mods.gregtech.multiblock.FactoryMultiblockShapeInfo;
import mods.gregtech.multiblock.IBlockInfo;
import mods.gregtech.MetaTileEntities;
import mods.gregtech.recipe.FactoryRecipeMap;
import crafttweaker.world.IFacing;
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

import scripts.misc_classes.IQuenchingFluid.IQuenchingFluid;
import scripts.misc_classes.IIngotQuenchable.IIngotQuenchable;

var loc = "quencher";
var meta = 20003; // Choose something that won't conflict. You'll get a warning in the crafttweaker logs if something goes wrong.

var large_weapons_factory = Builder.start(loc, meta)
    .withPattern(
        FactoryBlockPattern.start(RelativeDirection.RIGHT, RelativeDirection.UP, RelativeDirection.BACK)		
			.aisle("G G", "DDD", "FFF", "DDD")
			.aisle("G G", "DCD", "VAV", "DCD")
			.aisle("   ", "DCD", "VAV", "DCD")
			.aisle("G G", "DCD", "VAV", "DCD")
			.aisle("G G", "DDD", "FSF", "DDD")
            .whereOr("C",
                <metastate:gregtech:metal_casing:4>,
                IBlockMatcher.abilityPartPredicate(
                    MultiblockAbility.IMPORT_FLUIDS,
					MultiblockAbility.EXPORT_FLUIDS
                ))
			.whereOr("F",
                <metastate:gregtech:metal_casing:4>,
                IBlockMatcher.abilityPartPredicate(
                    MultiblockAbility.INPUT_ENERGY,
                    MultiblockAbility.IMPORT_ITEMS,
                    MultiblockAbility.EXPORT_ITEMS
                ))
			.where("V", <chisel:technical:4>)
			.where("D", <metastate:gregtech:metal_casing:4>)
            .where("S", IBlockMatcher.controller(loc))
            .where(" ", IBlockMatcher.ANY)
			.where("G", <ore:frameGtSteel>.firstItem)
			.whereOr("A",
					<metastate:gtadditions:ga_conveyor_casing:0>,
					<metastate:gtadditions:ga_conveyor_casing:1>,
					<metastate:gtadditions:ga_conveyor_casing:2>,
					<metastate:gtadditions:ga_conveyor_casing:3>,
					<metastate:gtadditions:ga_conveyor_casing:4>,
					<metastate:gtadditions:ga_conveyor_casing:5>,
					<metastate:gtadditions:ga_conveyor_casing:6>,
					<metastate:gtadditions:ga_conveyor_casing:7>,
					<metastate:gtadditions:ga_conveyor_casing:8>,
					<metastate:gtadditions:ga_conveyor_casing:9>,
					<metastate:gtadditions:ga_conveyor_casing:10>,
					<metastate:gtadditions:ga_conveyor_casing:11>,
					<metastate:gtadditions:ga_conveyor_casing:12>,
					<metastate:gtadditions:ga_conveyor_casing:13>)
            .build()
			)
    .addDesign(
        FactoryMultiblockShapeInfo.start()
			.aisle(
				"G G",
				"CCC",
				"CEO",
				"CCC")
			.aisle(
				"G G",
				"CDC",
				"VAV",
				"CFC")
			.aisle(
				"G G",
				"CCC",
				"VAV",
				"CCC")
			.aisle(
				"G G",
				"CDC",
				"VAV",
				"CFC")
			.aisle(
				"G G",
				"CCC",
				"CSI",
				"CCC")
            .where("C", <metastate:gregtech:metal_casing:4>)
            .where("S", IBlockInfo.controller(loc))
            .where("I", MetaTileEntities.ITEM_IMPORT_BUS[1], IFacing.south())
            .where("F", MetaTileEntities.FLUID_IMPORT_HATCH[1], IFacing.up())
			.where("D", MetaTileEntities.FLUID_EXPORT_HATCH[1], IFacing.down())
            .where("O", MetaTileEntities.ITEM_EXPORT_BUS[1], IFacing.north())
            .where("E", MetaTileEntities.ENERGY_INPUT_HATCH[1], IFacing.north())
			.where("A", <metastate:gtadditions:ga_conveyor_casing:0>)
			.where("G", <ore:frameGtSteel>.firstItem)
			.where("V", <metastate:chisel:technical:4>)
            .where(" ", IBlockInfo.EMPTY)
            .build())
    .clearTooltips(true)
    .withRecipeMap(
        FactoryRecipeMap.start(loc)
		    .minInputs(1)
		    .maxInputs(2)
		    .minOutputs(1)
		    .maxOutputs(1)
		    .maxFluidInputs(2)
			.maxFluidOutputs(2)
		    .build())
    .buildAndRegister();
	
recipes.addShaped("quencher", <gregtech:machine:20003>, [
	[pumps[3], conveyors[3], pumps[3]],
	[circuits[3], <gregtech:metal_casing:4>, circuits[3]],
	[<ore:cableGtSingleGold>, circuits[3], <ore:cableGtSingleGold>]
]);
	
//IQuenchingFluid(cold fluid, hot fluid, amount, duration, isInert)
val Water as IQuenchingFluid = IQuenchingFluid(<liquid:water>, <liquid:warm_water>, 1000, 100, false);

val Air as IQuenchingFluid = IQuenchingFluid(<liquid:air>, <liquid:hot_air>, 10000, 1000, false);
val CompressedAir as IQuenchingFluid = IQuenchingFluid(<liquid:hp_air>, <liquid:hot_hp_air>, 5000, 500, false);

val Nitrogen as IQuenchingFluid = IQuenchingFluid(<liquid:nitrogen>, <liquid:hot_nitrogen>, 10000, 500, true);
val CompressedNitrogen as IQuenchingFluid = IQuenchingFluid(<liquid:hp_nitrogen>, <liquid:hot_hp_nitrogen>, 5000, 500, true);

val Brine as IQuenchingFluid = IQuenchingFluid(<liquid:brine>, <liquid:hot_brine>, 1000, 20, false);

val QuenchingFluids as IQuenchingFluid[] = [
	Water,
	Air,
	CompressedAir,
	Nitrogen,
	CompressedNitrogen,
	Brine
];


// The following list has been organized using JEI's order.
// Please, For the sanity of all of those involved in maintaining this list until we get a script to do it :
// KEEP IT IN THIS SORTED OUT ORDER. PLEASE. THIS IS AGONIZING.
//																			- Fleefie
//IIngotQuenchable(ingot, hot ingot, needsInert, EUt)
val Erbium as IIngotQuenchable = IIngotQuenchable(<ore:ingotErbium>.firstItem, <ore:ingotHotErbium>, false, 120);
val Iridium as IIngotQuenchable = IIngotQuenchable(<ore:ingotIridium>.firstItem, <ore:ingotHotIridium>, false, 120);
val Lutetium as IIngotQuenchable = IIngotQuenchable(<ore:ingotLutetium>.firstItem, <ore:ingotHotLutetium>, false, 120);
val Niobium as IIngotQuenchable = IIngotQuenchable(<ore:ingotNiobium>.firstItem, <ore:ingotHotNiobium>, false, 120);
val Osmium as IIngotQuenchable = IIngotQuenchable(<ore:ingotOsmium>.firstItem, <ore:ingotHotOsmium>, false, 120);
val Scandium as IIngotQuenchable = IIngotQuenchable(<ore:ingotScandium>.firstItem, <ore:ingotHotScandium>, false, 120);
val Thulium as IIngotQuenchable = IIngotQuenchable(<ore:ingotThulium>.firstItem, <ore:ingotHotThulium>, false, 120);
val Titanium as IIngotQuenchable = IIngotQuenchable(<ore:ingotTitanium>.firstItem, <ore:ingotHotTitanium>, false, 120);
val Tungsten as IIngotQuenchable = IIngotQuenchable(<ore:ingotTungsten>.firstItem, <ore:ingotHotTungsten>, false, 120);
val Vanadium as IIngotQuenchable = IIngotQuenchable(<ore:ingotVanadium>.firstItem, <ore:ingotHotVanadium>, false, 120);
val Yttrium as IIngotQuenchable = IIngotQuenchable(<ore:ingotYttrium>.firstItem, <ore:ingotHotYttrium>, false, 120);
val Kanthal as IIngotQuenchable = IIngotQuenchable(<ore:ingotKanthal>.firstItem, <ore:ingotHotKanthal>, false, 120);
val Nichrome as IIngotQuenchable = IIngotQuenchable(<ore:ingotNichrome>.firstItem, <ore:ingotHotNichrome>, false, 120);
val NiobiumNitride as IIngotQuenchable = IIngotQuenchable(<ore:ingotNiobiumNitride>.firstItem, <ore:ingotHotNiobiumNitride>, false, 120);
val NiobiumTitanium as IIngotQuenchable = IIngotQuenchable(<ore:ingotNiobiumTitanium>.firstItem, <ore:ingotHotNiobiumTitanium>, false, 120);
val Ultimet as IIngotQuenchable = IIngotQuenchable(<ore:ingotUltimet>.firstItem, <ore:ingotHotUltimet>, false, 120);
val VanadiumGallium as IIngotQuenchable = IIngotQuenchable(<ore:ingotVanadiumGallium>.firstItem, <ore:ingotHotVanadiumGallium>, false, 120);
val YttriumBariumCuprate as IIngotQuenchable = IIngotQuenchable(<ore:ingotYttriumBariumCuprate>.firstItem, <ore:ingotHotYttriumBariumCuprate>, false, 120);
val Osmiridium as IIngotQuenchable = IIngotQuenchable(<ore:ingotOsmiridium>.firstItem, <ore:ingotHotOsmiridium>, false, 120);
val BlackBronze as IIngotQuenchable = IIngotQuenchable(<ore:ingotBlackBronze>.firstItem, <ore:ingotHotBlackBronze>, false, 120);
val TungstenSteel as IIngotQuenchable = IIngotQuenchable(<ore:ingotTungstenSteel>.firstItem, <ore:ingotHotTungstenSteel>, false, 120);
val TungstenCarbide as IIngotQuenchable = IIngotQuenchable(<ore:ingotTungstenCarbide>.firstItem, <ore:ingotHotTungstenCarbide>, false, 120);
val Hssg as IIngotQuenchable = IIngotQuenchable(<ore:ingotHssg>.firstItem, <ore:ingotHotHssg>, false, 120);
val Hsse as IIngotQuenchable = IIngotQuenchable(<ore:ingotHsse>.firstItem, <ore:ingotHotHsse>, false, 120);
val Hsss as IIngotQuenchable = IIngotQuenchable(<ore:ingotHsss>.firstItem, <ore:ingotHotHsss>, false, 120);
val Naquadah as IIngotQuenchable = IIngotQuenchable(<ore:ingotNaquadah>.firstItem, <ore:ingotHotNaquadah>, false, 120);
val NaquadahAlloy as IIngotQuenchable = IIngotQuenchable(<ore:ingotNaquadahAlloy>.firstItem, <ore:ingotHotNaquadahAlloy>, false, 120);
val NaquadahEnriched as IIngotQuenchable = IIngotQuenchable(<ore:ingotNaquadahEnriched>.firstItem, <ore:ingotHotNaquadahEnriched>, false, 120);
val Naquadria as IIngotQuenchable = IIngotQuenchable(<ore:ingotNaquadria>.firstItem, <ore:ingotHotNaquadria>, false, 120);
val CosmicNeutronium as IIngotQuenchable = IIngotQuenchable(<ore:ingotCosmicNeutronium>.firstItem, <ore:ingotHotCosmicNeutronium>, false, 120);
val Periodicium as IIngotQuenchable = IIngotQuenchable(<ore:ingotPeriodicium>.firstItem, <ore:ingotHotPeriodicium>, false, 120);
val QcdConfinedMatter as IIngotQuenchable = IIngotQuenchable(<ore:ingotQcdConfinedMatter>.firstItem, <ore:ingotHotQcdConfinedMatter>, false, 120);
val SuperheavyLAlloy as IIngotQuenchable = IIngotQuenchable(<ore:ingotSuperheavyLAlloy>.firstItem, <ore:ingotHotSuperheavyLAlloy>, false, 120);
val SuperheavyHAlloy as IIngotQuenchable = IIngotQuenchable(<ore:ingotSuperheavyHAlloy>.firstItem, <ore:ingotHotSuperheavyHAlloy>, false, 120);
val HeavyQuarkDegenerateMatter as IIngotQuenchable = IIngotQuenchable(<ore:ingotHeavyQuarkDegenerateMatter>.firstItem, <ore:ingotHotHeavyQuarkDegenerateMatter>, false, 120);
val MetastableHassium as IIngotQuenchable = IIngotQuenchable(<ore:ingotMetastableHassium>.firstItem, <ore:ingotHotMetastableHassium>, false, 120);
val LithiumNiobate as IIngotQuenchable = IIngotQuenchable(<ore:ingotLithiumNiobate>.firstItem, <ore:ingotHotLithiumNiobate>, false, 120);
val GermaniumTungstenNitrade as IIngotQuenchable = IIngotQuenchable(<ore:ingotGermaniumTungstenNitride>.firstItem, <ore:ingotHotGermaniumTungstenNitride>, false, 120);
val TantalumHafniumSeaborgiumCarbide as IIngotQuenchable = IIngotQuenchable(<ore:ingotTantalumHafniumSeaborgiumCarbide>.firstItem, <ore:ingotHotTantalumHafniumSeaborgiumCarbide>, false, 120);
val MetastableFlevorium as IIngotQuenchable = IIngotQuenchable(<ore:ingotMetastableFlerovium>.firstItem, <ore:ingotHotMetastableFlerovium>, false, 120);
val MetastableOganesson as IIngotQuenchable = IIngotQuenchable(<ore:ingotMetastableOganesson>.firstItem, <ore:ingotHotMetastableOganesson>, false, 120);
val Titanium50 as IIngotQuenchable = IIngotQuenchable(<ore:ingotTitanium50>.firstItem, <ore:ingotHotTitanium50>, false, 120);
val LithiumTitanate as IIngotQuenchable = IIngotQuenchable(<ore:ingotLithiumTitanate>.firstItem, <ore:ingotHotLithiumTitanate>, false, 120);
val Taranium as IIngotQuenchable = IIngotQuenchable(<ore:ingotTaranium>.firstItem, <ore:ingotHotTaranium>, false, 120);
val TriniumTitanium as IIngotQuenchable = IIngotQuenchable(<ore:ingotTriniumTitanium>.firstItem, <ore:ingotHotTriniumTitanium>, false, 120);
val ProtoAdamantium as IIngotQuenchable = IIngotQuenchable(<ore:ingotProtoAdamantium>.firstItem, <ore:ingotHotProtoAdamantium>, false, 120);
val Vibranium as IIngotQuenchable = IIngotQuenchable(<ore:ingotVibranium>.firstItem, <ore:ingotHotVibranium>, false, 120);
val Adamantium as IIngotQuenchable = IIngotQuenchable(<ore:ingotAdamantium>.firstItem, <ore:ingotHotAdamantium>, false, 120);
val Trinium as IIngotQuenchable = IIngotQuenchable(<ore:ingotTrinium>.firstItem, <ore:ingotHotTrinium>, false, 120);
val Hdcs as IIngotQuenchable = IIngotQuenchable(<ore:ingotHdcs>.firstItem, <ore:ingotHotHdcs>, false, 120);
val Cinobite as IIngotQuenchable = IIngotQuenchable(<ore:ingotCinobite>.firstItem, <ore:ingotHotCinobite>, false, 120);
val UxcSuperconductorBase as IIngotQuenchable = IIngotQuenchable(<ore:ingotUxvSuperconductorBase>.firstItem, <ore:ingotHotUxvSuperconductorBase>, false, 120);
val UmvSuperconductorBase as IIngotQuenchable = IIngotQuenchable(<ore:ingotUmvSuperconductorBase>.firstItem, <ore:ingotHotUmvSuperconductorBase>, false, 120);
val UivSuperconductorBase as IIngotQuenchable = IIngotQuenchable(<ore:ingotUivSuperconductorBase>.firstItem, <ore:ingotHotUivSuperconductorBase>, false, 120);
val HastelloyK243 as IIngotQuenchable = IIngotQuenchable(<ore:ingotHastelloyK243>.firstItem, <ore:ingotHotHastelloyK243>, false, 120);
val HastelloyX78 as IIngotQuenchable = IIngotQuenchable(<ore:ingotHastelloyX78>.firstItem, <ore:ingotHotHastelloyX78>, false, 120);
val EnrichedNaquadahAlloy as IIngotQuenchable = IIngotQuenchable(<ore:ingotEnrichedNaquadahAlloy>.firstItem, <ore:ingotHotEnrichedNaquadahAlloy>, false, 120);
val Incoloy813 as IIngotQuenchable = IIngotQuenchable(<ore:ingotIncoloy813>.firstItem, <ore:ingotHotIncoloy813>, false, 120);
val UevSuperconductorBase as IIngotQuenchable = IIngotQuenchable(<ore:ingotUevSuperconductorBase>.firstItem, <ore:ingotHotUevSuperconductorBase>, false, 120);
val UhvSuperconductorBase as IIngotQuenchable = IIngotQuenchable(<ore:ingotUhvSuperconductorBase>.firstItem, <ore:ingotHotUhvSuperconductorBase>, false, 120);
val UvSuperconductorBase as IIngotQuenchable = IIngotQuenchable(<ore:ingotUvSuperconductorBase>.firstItem, <ore:ingotHotUvSuperconductorBase>, false, 120);
val AbyssalAlloy as IIngotQuenchable = IIngotQuenchable(<ore:ingotAbyssalAlloy>.firstItem, <ore:ingotHotAbyssalIngot>, false, 120);
val NaquadriaticTaranium as IIngotQuenchable = IIngotQuenchable(<ore:ingotNaquadriaticTaranium>.firstItem, <ore:ingotHotNaquadriaticTaranium>, false, 120);
val Zeron as IIngotQuenchable = IIngotQuenchable(<ore:ingotZeron>.firstItem, <ore:ingotHotZeron>, false, 120);
val Lafium as IIngotQuenchable = IIngotQuenchable(<ore:ingotLafium>.firstItem, <ore:ingotHotLafium>, false, 120);
val Pikyonium as IIngotQuenchable = IIngotQuenchable(<ore:ingotPikyonium>.firstItem, <ore:ingotHotPikyonium>, false, 120);
val InconelB as IIngotQuenchable = IIngotQuenchable(<ore:ingotInconelB>.firstItem, <ore:ingotHotInconelB>, false, 120);
val TitanSteel as IIngotQuenchable = IIngotQuenchable(<ore:ingotTitanSteel>.firstItem, <ore:ingotHotTitanSteel>, false, 120);
val TungstenTitaniumCarbide as IIngotQuenchable = IIngotQuenchable(<ore:ingotTungstenTitaniumCarbide>.firstItem, <ore:ingotHotTungstenTitaniumCarbide>, false, 120);
val BlackTitanium as IIngotQuenchable = IIngotQuenchable(<ore:ingotBlackTitanium>.firstItem, <ore:ingotHotBlackTitanium>, false, 120);
val Quantum as IIngotQuenchable = IIngotQuenchable(<ore:ingotQuantum>.firstItem, <ore:ingotHotQuantum>, false, 120);
val Ruridit as IIngotQuenchable = IIngotQuenchable(<ore:ingotRuridit>.firstItem, <ore:ingotHotRuridit>, false, 120);
val RhodiumPlatedPalladium as IIngotQuenchable = IIngotQuenchable(<ore:ingotRhodiumPlatedPalladium>.firstItem, <ore:ingotHotRhodiumPlatedPalladium>, false, 120);
val Rhodium as IIngotQuenchable = IIngotQuenchable(<ore:ingotRhodium>.firstItem, <ore:ingotHotRhodium>, false, 120);
val Ruthenium as IIngotQuenchable = IIngotQuenchable(<ore:ingotRuthenium>.firstItem, <ore:ingotHotRuthenium>, false, 120);
val IncoloyMa as IIngotQuenchable = IIngotQuenchable(<ore:ingotIncoloyMa>.firstItem, <ore:ingotHotIncoloyMa>, false, 120);
val HgAlloy as IIngotQuenchable = IIngotQuenchable(<ore:ingotHgAlloy>.firstItem, <ore:ingotHotHgAlloy>, false, 120);
val NitinolA as IIngotQuenchable = IIngotQuenchable(<ore:ingotNitinolA>.firstItem, <ore:ingotHotNitinolA>, false, 120);
val Enderium as IIngotQuenchable = IIngotQuenchable(<ore:ingotEnderium>.firstItem, <ore:ingotHotEnderium>, false, 120);
val ZpmSuperconductorBase as IIngotQuenchable = IIngotQuenchable(<ore:ingotZpmSuperconductorBase>.firstItem, <ore:ingotHotZpmSuperconductorBase>, false, 120);
val LuvSuperconductorBase as IIngotQuenchable = IIngotQuenchable(<ore:ingotLuvSuperconductorBase>.firstItem, <ore:ingotHotLuvSuperconductorBase>, false, 120);
val IvSuperconductorBase as IIngotQuenchable = IIngotQuenchable(<ore:ingotIvSuperconductorBase>.firstItem, <ore:ingotHotIvSuperconductorBase>, false, 120);
val EvSuperconductorBase as IIngotQuenchable = IIngotQuenchable(<ore:ingotEvSuperconductorBase>.firstItem, <ore:ingotHotEvSuperconductorBase>, false, 120);
val HvSuperconductorBase as IIngotQuenchable = IIngotQuenchable(<ore:ingotHvSuperconductorBase>.firstItem, <ore:ingotHotHvSuperconductorBase>, false, 120);
val Talonite as IIngotQuenchable = IIngotQuenchable(<ore:ingotTalonite>.firstItem, <ore:ingotHotTalonite>, false, 120);
val Stellite as IIngotQuenchable = IIngotQuenchable(<ore:ingotStellite>.firstItem, <ore:ingotHotStellite>, false, 120);
val HastelloyN as IIngotQuenchable = IIngotQuenchable(<ore:ingotHastelloyN>.firstItem, <ore:ingotHotHastelloyN>, false, 120);
val Staballoy as IIngotQuenchable = IIngotQuenchable(<ore:ingotStaballoy>.firstItem, <ore:ingotHotStaballoy>, false, 120);
val MaragingSteelA as IIngotQuenchable = IIngotQuenchable(<ore:ingotMaragingSteelA>.firstItem, <ore:ingotHotMaragingSteelA>, false, 120);
val InconelA as IIngotQuenchable = IIngotQuenchable(<ore:ingotInconelA>.firstItem, <ore:ingotHotInconelA>, false, 120);
val Grisium as IIngotQuenchable = IIngotQuenchable(<ore:ingotGrisium>.firstItem, <ore:ingotHotGrisium>, false, 120);

val Ingots as IIngotQuenchable[] = [
	Erbium,
	Iridium,
	Lutetium,
	Niobium,
	Osmium,
	Scandium,
	Thulium,
	Titanium,
	Tungsten,
	Vanadium,
	Yttrium,
	Kanthal,
	Nichrome,
	NiobiumNitride,
	NiobiumTitanium,
	Ultimet,
	VanadiumGallium,
	YttriumBariumCuprate,
	Osmiridium,
	BlackBronze,
	TungstenSteel,
	TungstenCarbide,
	Hssg,
	Hsse,
	Hsss,
	Naquadah,
	NaquadahAlloy,
	NaquadahEnriched,
	Naquadria,
	CosmicNeutronium,
	Periodicium,
	QcdConfinedMatter,
	SuperheavyLAlloy,
	SuperheavyHAlloy,
	HeavyQuarkDegenerateMatter,
	MetastableHassium,
	LithiumNiobate,
	GermaniumTungstenNitrade,
	TantalumHafniumSeaborgiumCarbide,
	MetastableFlevorium,
	MetastableOganesson,
	Titanium50,
	LithiumTitanate,
	Taranium,
	TriniumTitanium,
	ProtoAdamantium,
	Vibranium,
	Adamantium,
	Trinium,
	Hdcs,
	Cinobite,
	UxcSuperconductorBase,
	UmvSuperconductorBase,
	UivSuperconductorBase,
	HastelloyK243,
	HastelloyX78,
	EnrichedNaquadahAlloy,
	Incoloy813,
	UevSuperconductorBase,
	UhvSuperconductorBase,
	UvSuperconductorBase,
	AbyssalAlloy,
	NaquadriaticTaranium,
	Zeron,
	Lafium,
	Pikyonium,
	InconelB,
	TitanSteel,
	TungstenTitaniumCarbide,
	BlackTitanium,
	Quantum,
	Ruridit,
	RhodiumPlatedPalladium,
	Rhodium,
	Ruthenium,
	IncoloyMa,
	HgAlloy,
	NitinolA,
	Enderium,
	ZpmSuperconductorBase,
	LuvSuperconductorBase,
	IvSuperconductorBase,
	EvSuperconductorBase,
	HvSuperconductorBase,
	Talonite,
	Stellite,
	HastelloyN,
	Staballoy,
	MaragingSteelA,
	InconelA,
	Grisium
];

for ingot in Ingots {
	for fluid in QuenchingFluids {
		if(!ingot.NeedsInert()) {
			<multiblock:multiblocktweaker:quencher>.recipeMap.recipeBuilder()
				.inputs([ingot.getHotIngot()])
				.fluidInputs([fluid.getColdFluid()])
				.outputs(ingot.getIngot())
				.fluidOutputs(fluid.getHotFluid())
				.duration(fluid.getDuration())
				.EUt(ingot.getEUt())
				.buildAndRegister();
		} else if(fluid.isInert()) {
			<multiblock:multiblocktweaker:quencher>.recipeMap.recipeBuilder()
				.inputs([ingot.getHotIngot()])
				.fluidInputs([fluid.getColdFluid()])
				.outputs(ingot.getIngot())
				.fluidOutputs(fluid.getHotFluid())
				.duration(fluid.getDuration())
				.EUt(ingot.getEUt())
				.buildAndRegister();
		}
	}
}
import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import biomesoplenty.common.block.BlockBOPLog
import biomesoplenty.api.enums.BOPWoods
import net.minecraftforge.fml.common.registry.ForgeRegistries
import net.minecraft.util.ResourceLocation
import net.minecraft.init.Blocks
import net.minecraft.block.BlockLog
import gregtech.common.blocks.MetaBlocks
import gregtechfoodoption.worldgen.trees.GTFOTrees

//REMOVALS
furnace.removeByInput(item('minecraft:slime_ball'))
// Sticky Resin * 1
mods.gregtech.fluid_solidifier.removeByInput(8, [metaitem('shape.mold.ball')], [fluid('gtfo_rubber_sap') * 100])

//LATEX COLLECTOR RECIPES

def pineLogBlock = (BlockBOPLog) ForgeRegistries.BLOCKS.getValue(new ResourceLocation('biomesoplenty', 'log_2'))
def pineBase = pineLogBlock.getDefaultState()
    .withProperty(pineLogBlock.variantProperty, BOPWoods.PINE)

LATEX_COLLECTOR.recipeBuilder()
    .notConsumable(fluid('water') * 10)
    .fluidOutputs(fluid('latex') * 100)
    .blockStates("latex_logs", MetaBlocks.RUBBER_LOG.getBlockState())
    .info('recipe.latex_extraction')
    .duration(20)
    .EUt(VA[ULV])
    .buildAndRegister();

LATEX_COLLECTOR.recipeBuilder()
    .notConsumable(fluid('distilled_water') * 10)
    .fluidOutputs(fluid('resin') * 100)
    .blockStates("extractable_logs_1", Blocks.LOG.getBlockState())
    .duration(20)
    .EUt(VA[ULV])
    .buildAndRegister();

LATEX_COLLECTOR.recipeBuilder()
    .notConsumable(fluid('lubricant') * 10)
    .fluidOutputs(fluid('resin') * 100)
    .blockStates("extractable_logs_2", Blocks.LOG2.getBlockState())
    .duration(20)
    .EUt(VA[ULV])
    .buildAndRegister();

LATEX_COLLECTOR.recipeBuilder()
    .notConsumable(fluid('diluted_sulfuric_acid') * 10)
    .fluidOutputs(fluid('pine_resin') * 100)
    .blockStates("pine_logs",
        pineBase.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.X),
        pineBase.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y),
        pineBase.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Z),)
    .duration(20)
    .EUt(VA[ULV])
    .buildAndRegister();

LATEX_COLLECTOR.recipeBuilder()
    .notConsumable(fluid('hot_hp_air') * 10)
    .fluidOutputs(fluid('gtfo_rainbow_sap') * 100)
    .blockStates("rainbowwood_logs", GTFOTrees.RAINBOWWOOD_TREE.logState, 
        GTFOTrees.RAINBOWWOOD_TREE.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y),
        GTFOTrees.RAINBOWWOOD_TREE.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Z))
    .duration(20)
    .EUt(VA[ULV])
    .buildAndRegister();

//ADDITIONS

crafting.addShaped('gregtech:resin_item', metaitem('rubber_drop') * 4, [
    [null, null, null],
    [null, fluid('resin') * 1000, null],
    [null, metaitem('shape.mold.ball').reuse(), null]
])

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('resin') * 100)
    .fluidOutputs(fluid('glue') * 75)
    .duration(15)
    .EUt(VA[LV])
    .buildAndRegister()

SOLIDIFIER.recipeBuilder()
    .fluidInputs(fluid('resin') * 250)
    .outputs(metaitem('rubber_drop'))
    .duration(20)
    .EUt(2)
    .buildAndRegister()

// Raw Rubber Pulp * 3
mods.gregtech.centrifuge.removeByInput(5, [metaitem('rubber_drop')], null)
CENTRIFUGE.recipeBuilder()
    .inputs(metaitem('rubber_drop'))
    .fluidOutputs(fluid('resin') * 250)
    .duration(40)
    .EUt(VA[ULV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('pine_resin') * 4000)
    .outputs(metaitem('dustRosin') * 3)
    .fluidOutputs(fluid('gum_turpentine') * 1000)
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister()

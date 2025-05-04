import classes.*;
import net.minecraft.init.Blocks;

MINING_DRILL = recipemap('mining_drill')

MINING_DRILL.recipeBuilder()
        .notConsumable(item('susy:deposit_block'))
        .outputs(metaitem('rock.orthomagmatic'))
        .duration(20)
        .EUt(30)
        .buildAndRegister()

MINING_DRILL.recipeBuilder()
        .notConsumable(item('susy:deposit_block', 1))
        .outputs(metaitem('rock.metamorphic'))
        .duration(20)
        .EUt(30)
        .buildAndRegister()

MINING_DRILL.recipeBuilder()
        .notConsumable(item('susy:deposit_block', 2))
        .outputs(metaitem('rock.sedimentary'))
        .duration(20)
        .EUt(30)
        .buildAndRegister()

MINING_DRILL.recipeBuilder()
        .notConsumable(item('susy:deposit_block', 3))
        .outputs(metaitem('rock.hydrothermal'))
        .duration(20)
        .EUt(30)
        .buildAndRegister()

MINING_DRILL.recipeBuilder()
        .notConsumable(item('susy:deposit_block', 4))
        .outputs(metaitem('rock.alluvial'))
        .duration(20)
        .EUt(30)
        .buildAndRegister()

MINING_DRILL.recipeBuilder()
        .notConsumable(item('susy:deposit_block', 5))
        .outputs(metaitem('rock.magmatic_hydrothermal'))
        .duration(20)
        .EUt(30)
        .buildAndRegister()
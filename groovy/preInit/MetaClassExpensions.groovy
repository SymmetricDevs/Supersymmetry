import com.cleanroommc.groovyscript.api.IIngredient
import gregtech.api.recipes.ingredients.GTRecipeItemInput
import gregtech.api.unification.ore.OrePrefix
import gregtech.loaders.recipe.handlers.RecyclingRecipeHandler

import java.util.function.Predicate

IIngredient.metaClass.toGTIngredient = { ->
    new GTRecipeItemInput(delegate.first)
}

List.metaClass.trimIng = { ->
    delegate.flatten()
            .findAll { it }
            *.toGTIngredient()
}

OrePrefix.metaClass.shouldRecycle = { ->
    RecyclingRecipeHandler.CRUSHING_PREFIXES.any {
        it in OrePrefix && it == owner.delegate || it in Predicate<OrePrefix> && it.test(owner.delegate)
    }
}

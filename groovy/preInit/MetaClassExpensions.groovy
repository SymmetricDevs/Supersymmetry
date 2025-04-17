import com.cleanroommc.groovyscript.api.IIngredient
import gregtech.api.recipes.ingredients.GTRecipeItemInput

IIngredient.metaClass.toGTIngredient = { ->
    new GTRecipeItemInput(delegate.getFirst())
}

List.metaClass.trim = { ->
    delegate.flatten()
            .findAll { it }
            .collect { it.toGTIngredient() }
}
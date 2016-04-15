package cookbook.services

import cookbook.daos.CookbookDao
import cookbook.domain.Recipe
import cookbook.domain.RecipeIngredient
import cookbook.domain.RecipeInstruction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RecipeService {
    @Autowired CookbookDao dao

    public int createRecipe(Recipe recipe) {
        /*
            1. insert Recipe
            2. insert Ingredient(s)
            3. insert Measurement Type(s)
            4. insert RecipeIngredient(s)
            5. insert Instruction(s)
            6. insert RecipeInstruction(s)
         */
        dao.insertRecipe(recipe)
        recipe.ingredients.each { RecipeIngredient ri ->
            dao.insertIngredient(ri.ingredient)
            dao.insertMeasurementType(ri.measurementType)
            dao.insertRecipeIngredient(recipe.getId(), ri.ingredient.getId(), ri, ri.measurementType.getId())
        }

        recipe.instructions.each { RecipeInstruction ri ->
            dao.insertInstruction(ri.instruction)
            dao.insertRecipeInstruction(recipe.getId(), ri.instruction.getId(), ri)
        }

        return recipe.getId()
    }
}
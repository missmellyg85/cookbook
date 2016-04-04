package cookbook.services

import cookbook.daos.CookbookDao
import cookbook.domain.Recipe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RecipeService {
    @Autowired CookbookDao dao

    public void createRecipe(Recipe recipe) {
        /*
            1. insert Recipe
            2. insert Ingredient(s)
            3. insert Measurement Type(s)
            4. insert RecipeIngredient(s)
            5. insert Instruction(s)
            6. insert RecipeInstruction(s)
         */
    }
}

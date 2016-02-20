package cookbook.controllers

import cookbook.daos.CookbookDao
import cookbook.domain.Recipe
import cookbook.domain.RecipeIngredient
import cookbook.domain.RecipeInstruction
import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("/recipe")
class RecipeController {
    @Autowired Sql db
    CookbookDao dao

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Recipe getRecipe(@PathVariable(value="id") int id) {
        dao.getRecipe(id)
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Recipe> getAllRecipes() {
        dao.getAllRecipes()
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createRecipe(@Valid @RequestBody Recipe recipe) {
        db.withTransaction {
            def recipeId = dao.addRecipe(recipe)

            recipe.ingredients.each { RecipeIngredient ri ->
                dao.addRecipeIngredient(recipeId, ri)
            }
            recipe.instructions.each { RecipeInstruction ri ->
                dao.addRecipeInstruction(recipeId, ri)
            }
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRecipe(@PathVariable(value = "id") int id) {
        dao.deleteRecipe(id)
    }
}
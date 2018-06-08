package cookbook.controllers

import cookbook.daos.CookbookDao
import cookbook.domain.Recipe
import cookbook.services.RecipeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("/recipe")
class RecipeController {
    @Autowired CookbookDao cookbookDao
    @Autowired RecipeService service

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Recipe getRecipe(@PathVariable(value="id") int id) {
        def result = cookbookDao.getRecipe(id)
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Recipe> getAllRecipes() {
        cookbookDao.getAllRecipes()
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public int createRecipe(@Valid @RequestBody Recipe recipe) {
        service.createRecipe(recipe)
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRecipe(@PathVariable(value = "id") int id) {
        cookbookDao.deleteRecipe(id)
    }
}
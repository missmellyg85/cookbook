package cookbook.controllers

import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("/recipe")
class RecipeController {
    @Autowired Sql db

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map getRecipe(@PathVariable(value="id") int id) {
        db.firstRow("SELECT * from recipe where id=${id}")
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<?> getAllRecipes() {
        List<?> recipes = []
        db.eachRow("SELECT * FROM recipe") {
            recipes.push([id: it.id, name: it.name])
        }
        recipes
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createRecipe(@Valid @RequestBody Recipe recipe) {
        db.executeInsert("INSERT INTO recipe (name) VALUES (${recipe.name})")
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRecipe(@PathVariable(value = "id") int id) {
        db.execute("DELETE FROM recipe where id=${id}")
    }
}

class Recipe {
    String name
}
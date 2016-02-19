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
        db.withTransaction {
            def insertedRecipe = db.executeInsert("INSERT INTO recipe (name) VALUES (${recipe.name})")

            recipe.ingredients.each { RecipeIngredient ri ->
                def insertedIngredient = db.executeInsert("INSERT INTO ingredient (name) VALUES (${ri.ingredient.name})")
                def insertedMeasurementType = db.executeInsert("INSERT INTO measurement_type (name, abbreviation) values (${ri.measurementType.name}, ${ri.measurementType.abbreviation})")
                db.executeInsert("INSERT INTO recipe_ingredient (recipe_id, ingredient_id, measurement_amount, measurement_type_id) values (${insertedRecipe[0][0]}, ${insertedIngredient[0][0]}, ${ri.measurementAmount}, ${insertedMeasurementType[0][0]})")
            }
            recipe.instructions.each { RecipeInstruction ri ->
                def insertedInstruction = db.executeInsert("INSERT INTO instruction (text) values (${ri.instruction.text})")
                db.executeInsert("INSERT INTO recipe_instruction (recipe_id, instruction_id, instruction_number) values (${insertedRecipe[0][0]}, ${insertedInstruction[0][0]}, ${ri.instruction_number})")
            }
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRecipe(@PathVariable(value = "id") int id) {
        db.execute("DELETE FROM recipe where id=${id}")
    }
}

class Recipe {
    String name
    List<RecipeIngredient> ingredients
    List<RecipeInstruction> instructions
}

class RecipeIngredient {
    Ingredient ingredient
    Float measurementAmount
    MeasurementType measurementType
}

class RecipeInstruction {
    Instruction instruction
    int instruction_number
}

class Ingredient {
    String name
}

class MeasurementType {
    String name
    String abbreviation
}

class Instruction {
    String text
}
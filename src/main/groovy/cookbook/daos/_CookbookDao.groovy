package cookbook.daos

import cookbook.domain.Ingredient
import cookbook.domain.Instruction
import cookbook.domain.MeasurementType
import cookbook.domain.Recipe
import cookbook.domain.RecipeIngredient
import cookbook.domain.RecipeInstruction
import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.sql.DataSource

@Component
class _CookbookDao {
//    @Autowired Sql db
//
//    Map getRecipe(int id) {
//        def recipe = db.firstRow("SELECT * from recipe where id=${id}")
//        def ingredients = []
//        db.eachRow('''SELECT ingredient.name, ri.measurement_amount, mt.name
//            FROM recipe_ingredient ri
//            INNER JOIN ingredient ON ingredient.id = ri.ingredient_id
//            INNER JOIN measurement_type mt ON mt.id = ri.measurement_type_id
//            WHERE ri.recipe_id ='''+ id) {
//            ingredients.push(it)
//        }
//        def instructions = []
//        db.eachRow('''SELECT instruction.text, ri.instruction_number
//            FROM recipe_instruction ri
//            INNER JOIN instruction ON instruction.id = ri.instruction_id
//            WHERE ri.recipe_id = ''' + id) {
//            instructions.push(it)
//        }
//
//        println "recipe: " + recipe
//        println "ingredients: " + ingredients
//        println "instructions: " + instructions
//    }
//
//    List<Recipe> getAllRecipes() {
//
//        List<?> recipes = []
//        db.eachRow("SELECT * FROM recipe") {
//            recipes.push([id: it.id, name: it.name])
//        }
//        recipes
//    }
//
//    int addRecipe(Recipe recipe) {
//        def insertedRecipe = db.executeInsert("INSERT INTO recipe (name) VALUES (${recipe.name})")
//        insertedRecipe[0][0]
//    }
//
//    int addRecipeIngredient(int recipeId, RecipeIngredient ri) {
//        def ingredientId = _addIngredient(ri.ingredient)
//        def mtId = _addMeasurementType(ri.measurementType)
//        def insertedRecipeIngredient = _addRecipeIngredient(recipeId, ingredientId, ri.measurementAmount, mtId)
//        insertedRecipeIngredient[0][0]
//    }
//
//    int addRecipeInstruction(int recipeId, RecipeInstruction ri) {
//        def instructionId = _addInstruction(ri.instruction)
//        _addRecipeInstruction(recipeId, instructionId, ri.instruction_number)
//    }
//
//    void deleteRecipe(int id) {
//        db.execute("DELETE FROM recipe where id=${id}")
//    }
//
//    private int _addIngredient(Ingredient ingredient) {
//        def insertedIngredient = db.executeInsert("INSERT INTO ingredient (name) VALUES (${ingredient.name})")
//        insertedIngredient[0][0]
//    }
//
//    private int _addMeasurementType(MeasurementType measurementType) {
//        def insertedMT = db.executeInsert("INSERT INTO measurement_type (name, abbreviation) values (${measurementType.name}, ${measurementType.abbreviation})")
//        insertedMT[0][0]
//    }
//
//    private int _addRecipeIngredient(int recipeId, int ingredientId, float measurementAmount, int mtId) {
//        db.executeInsert("INSERT INTO recipe_ingredient (recipe_id, ingredient_id, measurement_amount, measurement_type_id) values (${recipeId}, ${ingredientId}, ${measurementAmount}, ${mtId})")
//    }
//
//    private int _addInstruction(Instruction instruction) {
//        def insertedInstruction = db.executeInsert("INSERT INTO instruction (text) values (${ri.instruction.text})")
//        insertedInstruction[0][0]
//    }
//
//    private int _addRecipeInstruction(int recipeId, int instructionId, int instructionNumber) {
//        db.executeInsert("INSERT INTO recipe_instruction (recipe_id, instruction_id, instruction_number) values (${recipeId}, ${instructionId}, ${instructionNumber})")
//    }

}

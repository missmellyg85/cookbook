package cookbook.daos

import cookbook.domain.Ingredient
import cookbook.domain.Instruction
import cookbook.domain.MeasurementType
import cookbook.domain.Recipe
import cookbook.domain.RecipeIngredient
import cookbook.domain.RecipeInstruction
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Param

public interface CookbookDao {

    public Recipe getRecipe(@Param("id")int id)

    public List<Recipe> getAllRecipes()

    @Insert('''INSERT into recipe (name)
            values (#{recipe.name})
            ''')
    @Options(useGeneratedKeys=true, keyProperty="recipe.id", keyColumn = "id")
    public int insertRecipe(@Param('recipe') Recipe recipe)

    @Insert('''INSERT into ingredient (name)
            values (#{ingredient.name})
            ''')
    @Options(useGeneratedKeys=true, keyProperty="ingredient.id", keyColumn = "id")
    public int insertIngredient(@Param('ingredient') Ingredient ingredient)

    @Insert('''INSERT into instruction (text)
            values (#{instruction.text})''')
    @Options(useGeneratedKeys=true, keyProperty="instruction.id", keyColumn = "id")
    public int insertInstruction(@Param('instruction') Instruction instruction)

    @Insert('''INSERT into recipe_ingredient
            (recipe_id, ingredient_id, measurement_amount)
            values (#{recipeId}, #{ingredientId}, #{recipeIngredient.measurementAmount})''')
    @Options(useGeneratedKeys=false)
    public void insertRecipeIngredient(@Param('recipeId') int recipeId,
                                       @Param('ingredientId') int ingredientId,
                                       @Param('recipeIngredient') RecipeIngredient recipeIngredient)

    @Insert('''INSERT into recipe_instruction
            (recipe_id, instruction_id, instruction_number)
            values (#{recipeId}, #{instructionId}, #{recipeInstruction.instructionNumber})''')
    @Options(useGeneratedKeys=false)
    public void insertRecipeInstruction(@Param('recipeId') int recipeId,
                                        @Param('instructionId') int ingredientId,
                                        @Param('recipeInstruction') RecipeInstruction recipeInstruction)
}

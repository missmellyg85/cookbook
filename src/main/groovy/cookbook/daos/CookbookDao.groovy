package cookbook.daos

import cookbook.domain.Ingredient
import cookbook.domain.Instruction
import cookbook.domain.MeasurementType
import cookbook.domain.Recipe
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param

public interface CookbookDao {

    public Recipe getRecipe(@Param("id")int id)

    public List<Recipe> getAllRecipes()

    public int insertRecipe(@Param('recipe') Recipe recipe)

    public int insertIngredient(@Param('ingredient') Ingredient ingredient)
    
    public int insertMeasurementType(@Param('measurementType') MeasurementType measurementType)
    
    public int insertInstruction(@Param('instruction') Instruction instruction)
    
}

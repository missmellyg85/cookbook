package cookbook.daos

import cookbook.domain.Recipe
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param

public interface CookbookDao {

    public Recipe getRecipe(@Param("id")int id)

    public List<Recipe> getAllRecipes()

    
}

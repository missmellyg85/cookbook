package cookbook.daos

import cookbook.domain.Recipe
import cookbook.domain.RecipeIngredient
import org.apache.ibatis.annotations.Param

public interface CookbookDao {

    public Recipe getRecipe(@Param("id")int id)

}

package cookbook.controllers

import cookbook.domain.Recipe
import spock.lang.Specification

class RecipeControllerTest extends Specification {
    RecipeController controller = new RecipeController()
    def recipes = []

    def setup() {
        recipes = [new Recipe(name:"enchilada")]
        controller.getRecipe(int) >> {id ->
            return recipes.first()
        }

    }

    def "getRecipe returns a recipe object"() {
        when:
            def recipe = controller.getRecipe(1)

        then:
            recipe == recipes.first()
    }

}

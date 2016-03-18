package cookbook.controllers

import cookbook.Application
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.WebIntegrationTest
import spock.lang.Specification


@WebIntegrationTest
@SpringApplicationConfiguration(Application.class)
class RecipeControllerTest extends Specification {

    @Autowired RecipeController recipeController

    def "its a test"() {
        given:
            def a = 2
            def b = 2

        when:
            def result = recipeController.getRecipe(27)

        then:
            result == 19
    }
}

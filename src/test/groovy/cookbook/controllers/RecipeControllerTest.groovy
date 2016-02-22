package cookbook.controllers

import cookbook.daos.CookbookDao
import cookbook.domain.Recipe
import groovy.sql.GroovyRowResult
import spock.lang.Specification

class RecipeControllerTest extends Specification {
    def controller = new RecipeController()
    def recipe = [name:"Enchilada"]
    def recipes = []

    def setup() {
        recipes = [recipe]

        def dao = [getRecipe: { int id ->
            recipes.get(id-1)
        }] as CookbookDao

        controller.dao = dao
    }

    def "getRecipe returns a recipe object"() {

        expect:
            controller.getRecipe(1) == recipes.first()
    }

}

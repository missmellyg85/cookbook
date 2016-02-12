package cookbook.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/recipe")
class RecipeController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public int getRecipe(@PathVariable(value="id") int id) {
      return id
    }
}

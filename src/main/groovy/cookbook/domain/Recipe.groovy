package cookbook.domain

class Recipe {
    int id
    String name
    List<RecipeIngredient> ingredients
    List<RecipeInstruction> instructions
}
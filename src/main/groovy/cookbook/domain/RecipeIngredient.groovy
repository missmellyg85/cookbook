package cookbook.domain

class RecipeIngredient {
    int recipeId
    int ingredientId
    Ingredient ingredient
    String measurementAmount
    MeasurementType measurementType
}
package cookbook.domain

class RecipeIngredient {
    int recipeId
    int ingredientId
    Ingredient ingredient
    Double measurementAmount
    MeasurementType measurementType
}
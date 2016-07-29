import RecipeComponent from './directive';

export default angular.module('app.recipes.recipe', [])
	.directive('recipeComponent', RecipeComponent)
	.name;

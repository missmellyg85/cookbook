import RecipeFromComponent from './directive';

export default angular.module('app.recipes.form', [])
	.directive('recipeFormComponent', RecipeFromComponent);

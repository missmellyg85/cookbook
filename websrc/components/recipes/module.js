import RecipesComponent from './directive';
import RecipeService from './service';

export default angular.module('app.recipes', [])
	.service('recipeService', RecipeService)
  .directive('recipesComponent', RecipesComponent);

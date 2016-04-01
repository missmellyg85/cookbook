import './components/recipe/module';

import RecipesComponent from './directive';
import RecipeService from './service';

export default angular.module('app.recipes',
	[
		'app.recipes.recipe'
	])
	.service('recipeService', RecipeService)
    .directive('recipesComponent', RecipesComponent);

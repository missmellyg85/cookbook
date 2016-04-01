import './components/recipe/module';
import './components/form/module';

import RecipesComponent from './directive';
import RecipeService from './service';

export default angular.module('app.recipes',
	[
		'app.recipes.recipe',
		'app.recipes.form'
	])
	.service('recipeService', RecipeService)
    .directive('recipesComponent', RecipesComponent);

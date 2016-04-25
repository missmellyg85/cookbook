import RecipeFromComponent from './directive';

import './style.scss';

export default angular.module('app.recipes.form', [])
	.directive('recipeFormComponent', RecipeFromComponent);

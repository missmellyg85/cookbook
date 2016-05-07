import RecipeFromComponent from './directive';
import RecipeFormController from './controller';

//import './style.scss';

export default angular.module('app.recipes.form', [])
	.directive('recipeFormComponent', RecipeFromComponent)
	.controller('recipeFormController', RecipeFormController)
	.name;

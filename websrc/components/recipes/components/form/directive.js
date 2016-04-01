import controller from './controller';

export default function RecipeFormComponent() {
	return {
		restrict: 'EA',
		replace: false,
		template: require('./template.html'),
		controller,
		controllerAs: 'newRecipeCtrl'
	}
}

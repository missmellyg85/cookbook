import controller from './controller';

export default function RecipeComponent() {
	return {
		restrict: 'EA',
		replace: false,
		template: require('./template.html'),
		controller,
		controllerAs: 'recipeCtrl'
	}
}

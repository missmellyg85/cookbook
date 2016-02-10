import controller from './controller';

export default function RecipesComponent() {
  return {
    restrict: 'EA',
    replace: false,
    templateUrl: require('./template.html'),
    controller: controller,
    controllerAs: 'recipesCtrl'
  }
}

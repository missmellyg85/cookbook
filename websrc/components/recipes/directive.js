import controller from './controller';

export default function RecipesComponent() {
  return {
    restrict: 'EA',
    replace: false,
    template: require('./template.html'),
    controller,
    controllerAs: 'recipesCtrl'
  }
}

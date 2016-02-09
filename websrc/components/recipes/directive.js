export default function recipesDirective() {
  return {
    restrict: 'E',
    templateUrl: require('./template.html'),
    controller: require('./controller'),
    controllerAs: 'recipesCtrl'
  }
}

import recipesDirective from './directive';

export default angular.module('app.recipes', [])
  .directive('recipesComponent', recipesDirective);

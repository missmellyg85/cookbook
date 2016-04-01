import angular from 'angular';
import uirouter from 'angular-ui-router';
import routing from './app.routes';

import './components/recipes/module';
import './components/static-components/module';

angular.module('app', [
    uirouter,
    'app.recipes',
    'app.static-components'
])
  .config(routing);

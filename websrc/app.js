import angular from 'angular';
import uirouter from 'angular-ui-router';
import routing from './app.routes';

import './components/recipes/module';

angular.module('app', [
    uirouter,
    'app.recipes'
])
  .config(routing);

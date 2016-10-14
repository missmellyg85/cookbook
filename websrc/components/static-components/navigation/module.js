import NavigationComponent from './directive';

import './style.scss';

export default angular.module('app.static-components.navigation', [])
	.directive('navigationComponent', NavigationComponent);

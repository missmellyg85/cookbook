routing.$inject = ['$stateProvider', '$urlRouterProvider'];

export default function routing($stateProvider, $urlRouterProvider) {
	"use strict";
	$urlRouterProvider.otherwise("/recipes");

	$stateProvider
		.state('recipes', {
			url: '/recipes',
			views: {
				page: {template: '<recipes-component/>'}
			}
		})
		.state('recipe', {
			url: '/recipe/:id',
			views: {
				page: { template: '<recipe-component/>' }
			}
		})
}
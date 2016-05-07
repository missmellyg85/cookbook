import module from './module';

describe('Controller: New Recipe', function(){

	let $controller, ctrl;

	beforeEach(angular.mock.module(module));

	beforeEach(angular.mock.inject(function(_$controller_){
		$controller = _$controller_;
		ctrl = $controller('recipeFormController', {
			recipeService: {}
		});
	}));

	it('should append more ingredients', function() {
		let originalLength = ctrl.newRecipe.ingredients.length;

		expect(originalLength).toBe(1);

		ctrl.addIngredient();

		expect(ctrl.newRecipe.ingredients.length).toBe(2);
	})

});
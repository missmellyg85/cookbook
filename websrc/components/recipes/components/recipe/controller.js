class Controller {
	constructor($stateParams, recipeService) {
		this.service = recipeService;
		this.recipe = "";
		this.loadRecipe($stateParams.id);
	}

	loadRecipe(id) {
		this.service.getRecipe(id)
			.then(response => {
				this.recipe = response.data;
			})
	}

}

Controller.$inject = ['$stateParams', 'recipeService'];

export default Controller;

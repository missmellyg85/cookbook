class Controller {
	constructor(recipeService) {
		this.service = recipeService;
		this.title = "Recipes Page";
		this.loadRecipes();
	}

	loadRecipes() {
		this.service.getAllRecipes()
			.then((response) => {
				this.recipes = response.data;
			});
	}


}

Controller.$inject = ['recipeService'];

export default Controller;

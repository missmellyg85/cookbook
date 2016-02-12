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

	createRecipe(recipe) {
		this.service.createRecipe(recipe)
			.then(() => {
				this.resetForm();
				this.loadRecipes();
			})
	}

	deleteRecipe(id) {
		this.service.deleteRecipe(id)
			.then(() => {
				this.loadRecipes();
			});
	}

	resetForm() {
		this.newRecipe = {};
	}
}

Controller.$inject = ['recipeService'];

export default Controller;

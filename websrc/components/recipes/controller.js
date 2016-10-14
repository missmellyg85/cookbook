class Controller {
	constructor(recipeService) {
		this.service = recipeService;
		this.title = "Recipes";
		this.loadRecipes();
	}

	loadRecipes() {
		this.service.getAllRecipes()
			.then((response) => {
				this.recipes = response.data;
			});
	}

	processDelete(recipe) {
		recipe.showDeleteButton = true;
	}

	cancelDelete(recipe) {
		delete recipe.showDeleteButton
	}
	
	deleteRecipe(deleteRecipe) {
		this.service.deleteRecipe(deleteRecipe.id)
			.then(() => {
				this.recipes = this.recipes
					.filter(function (recipe) {
							return recipe.id !== deleteRecipe.id;
						}
					);
			})
	}

}

Controller.$inject = ['recipeService'];

export default Controller;

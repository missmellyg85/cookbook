class Controller {
	constructor(recipeService) {
		this.service = recipeService;
		this.title = "Recipes Page";
		this.loadRecipes();

		let newRecipe = {
			name: null,
			ingredients: [{
				ingredient: {
					name: null
				},
				amount: null,
				measurementType: {
					name: null,
					abbreviation: null
				}
			}],
			instructions: [{
				instruction: {
					text: null
				},
				instruction_number: null,
			}]
		}
		this.newRecipe = newRecipe;
	}

	loadRecipes() {
		this.service.getAllRecipes()
			.then((response) => {
				this.recipes = response.data;
			});
	}

	createRecipe(recipe) {
		console.log("create recipe", recipe)
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
		this.newRecipe = {
			name: null,
			ingredients: [{
				ingredient: {
					name: null
				},
				measurementAmount: null,
				measurementType: {
					name: null,
					abbreviation: null
				}
			}],
			instructions: [{
				instruction: {
					text: null
				},
				instruction_number: null,
			}]
		};
	}

	addRecipeIngredientInput() {
		console.log("add more ingredients");
		this.newRecipe.ingredients.push({
			ingredient: {
				name: null
			},
			measurementAmount: null,
			measurementType: {
				name: null,
				abbreviation: null
			}
		});
	}

	addRecipeInstructionInput() {
		console.log("add more instructions");
		this.newRecipe.instructions.push({
			instruction: {
				text: null
			},
			instruction_number: null,
		});
	}
}

Controller.$inject = ['recipeService'];

export default Controller;

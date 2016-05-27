class Controller {
	constructor(recipeService) {
		this.service = recipeService;
		this.blankRecipeIngredient = {measurementAmount:"", measurementType:{name:"", abbreviation:""}, ingredient:{name:""}};
		this.blankRecipeInstruction = {instructionNumber:"", instruction: {text:""}};
		this.blankRecipe = {
			name: "",
			ingredients: [angular.copy(this.blankRecipeIngredient)],
			instructions: [angular.copy(this.blankRecipeInstruction)]
		}
		this.newRecipe = angular.copy(this.blankRecipe);
	}

	addIngredient() {
		this.newRecipe.ingredients.push(angular.copy(this.blankRecipeIngredient));
	}

	addInstruction() {
		this.newRecipe.instructions.push(angular.copy(this.blankRecipeInstruction));
	}

	submit() {
		this.service.createRecipe(this.newRecipe)
		.then(response => {

		})
		.catch(error => {
			this.error = error.data.message;
		});
	}
}

Controller.$inject = ['recipeService'];

export default Controller;
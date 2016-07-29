class Controller {
	constructor(recipeService) {
		this.service = recipeService;
		this.resetRecipe();
	}

	autoNewIngredient(index) {
		let end = this.newRecipe.ingredients.length-1;
		let current = this.newRecipe.ingredients[end]
		if(index == end && current.measurementAmount) {this.addIngredient()}
	}

	autoNewInstruction(last) {
		if(last) {this.addInstruction()}
	}

	addIngredient() {
		this.newRecipe.ingredients.push(angular.copy(this.blankRecipeIngredient));
	}

	addInstruction() {
		this.newRecipe.instructions.push(angular.copy(this.blankRecipeInstruction));
	}

	resetRecipe() {
		this.blankRecipeIngredient = {measurementAmount:"", ingredient:{name:""}};
		this.blankRecipeInstruction = {instructionNumber:"", instruction: {text:""}};
		this.blankRecipe = {
			name: "",
			ingredients: [angular.copy(this.blankRecipeIngredient)],
			instructions: [angular.copy(this.blankRecipeInstruction)]
		}
		this.newRecipe = angular.copy(this.blankRecipe);
	}

	submit() {
		this.success = false;
		this.service.createRecipe(this.newRecipe)
		.then(response => {
			this.success = true;
			this.resetRecipe()
		})
		.catch(error => {
			this.error = error.data.message;
		});
	}
}

Controller.$inject = ['recipeService'];

export default Controller;
class Controller {
	constructor(recipeService) {
		this.service = recipeService;
		this.blankRecipeIngredient = {amount:"", measurementType:{name:"", abbreviation:""}, ingredient:{name:""}};
		this.blankRecipeInstruction = {instruction_number:"", instruction: {text:""}};
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
		console.log("recipe",this.newRecipe);
	}
}

Controller.$inject = ['recipeService'];

export default Controller;

//{
//	"name":"Grilled Cheese",
//	"ingredients":[
//	{
//		"amount":"2",
//		"measurementType":{
//			"name":"pieces",
//			"abbreviation":""
//		},
//		"ingredient":{
//			"name":"bread"
//		}
//	},
//	{
//		"amount":"1",
//		"measurementType":{
//			"name":"teaspoon",
//			"abbreviation":""
//		},
//		"ingredient":{
//			"name":"mayonnaise"
//		}
//	},
//	{
//		"amount":"2",
//		"measurementType":{
//			"name":"slices",
//			"abbreviation":""
//		},
//		"ingredient":{
//			"name":"American cheese"
//		}
//	},
//	{
//		"amount":"2",
//		"measurementType":{
//			"name":"tablesoon",
//			"abbreviation":""
//		},
//		"ingredient":{
//			"name":"butter"
//		}
//	}
//],
//	"instructions":[
//	{
//		"instruction_number":1,
//		"instruction":{
//			"text":"Heat a skillet on the stove at medium heat"
//		}
//	},
//	{
//		"instruction_number":2,
//		"instruction":{
//			"text":"Spread butter on one side of each piece of bread"
//		}
//	},
//	{
//		"instruction_number":3,
//		"instruction":{
//			"text":"Spread mayo between cheese"
//		}
//	},
//	{
//		"instruction_number":4,
//		"instruction":{
//			"text":"Put it all together and cook it"
//		}
//	}
//]
//}
export default class Service {
	constructor($http) {
		this.$http = $http;
	}

	getAllRecipes() {
		return this.$http.get('/recipe/all');
	}

	getRecipe(id) {
		return this.$http.get(`/recipe/${id}`);
	}

	createRecipe(recipe) {
		return this.$http.post('/recipe', recipe);
	}

	deleteRecipe(id) {
		return this.$http.delete(`/recipe/${id}`)
	}

}

Service.$inject = ['$http'];
export default class Service {
	constructor($http) {
		this.$http = $http;
	}

	getAllRecipes() {
		return this.$http.get('http://localhost:8080/recipe/all');
	}

	getRecipe(id) {
		return this.$http.get(`http://localhost:8080/recipe/${id}`);
	}

	//createRecipe(recipe) {
	//	return this.$http.post('http://localhost:8080/recipe', recipe);
	//}
	//
	//deleteRecipe(id) {
	//	return this.$http.delete(`http://localhost:8080/recipe/${id}`)
	//}

}

Service.$inject = ['$http'];
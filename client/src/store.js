import {createStore} from 'redux';
//
// const ADD_TASK = 'add task';
// const TOGGLE_PENDING = 'toggle pending';
//
// const toggleTaskPending = (task) => ({ ...task, pending: !task.pending });
//

const sortRecipes = (recipes) => {
    const byName = (recipe1, recipe2) => recipe1.name.localeCompare(recipe2.name);
    return recipes.slice().sort(byName);
}

//
// const todoReducers = (tasks, action) => {
//     switch(action.type) {
//         case TOGGLE_PENDING:
//             return tasks.map(
//                 task => task.id === action.id ? toggleTaskPending(task) : task);
//
//         case ADD_TASK:
//             const { name } = action;
//             const id = tasks.length + 1;
//             return sortTasks([...tasks, {id, name, pending: true}]);
//
//         default:
//             return sortTasks(tasks);
//     }
// };

const recipeReducers = (recipes, action) => {
    switch(action.type) {
        default:
            return sortRecipes(recipes);
    }
}

//
// export const createAddTask = (name) => ({
//     type: ADD_TASK,
//     name
// });
//
// export const createTogglePending = (id) => ({
//     type: TOGGLE_PENDING,
//     id
// });
//
// export const createTODOStore = (tasks) => createStore(todoReducers, tasks);
export const createRecipeStore = (recipes) => createStore(recipeReducers, recipes);
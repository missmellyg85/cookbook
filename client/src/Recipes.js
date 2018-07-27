import React, {Component} from 'react';
import PropTypes from 'prop-types';
import RecipeIngredient from './recipe-ingredient';
import RecipeInstruction from './recipe-instruction';

class Recipes extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        const {store} = this.context;

        const recipes = store.getState();

        return (
            <div>
                {recipes.map(recipe =>
                    <div key={"recipe" + recipe.id}>
                        <h2>{recipe.name}</h2>
                        <h3>Ingredients</h3>
                        <ul>
                            {recipe.ingredients.map(ingredient =>
                                <RecipeIngredient recipeId={recipe.id} ingredient={ingredient}
                                                  key={recipe.id + "_ingredient" + ingredient.ingredientId}/>
                            )}
                        </ul>
                        <h3>Instructions</h3>
                        <ol>
                            {recipe.instructions.map(instruction =>
                                <RecipeInstruction recipeId={recipe.id} instruction={instruction}
                                                   key={recipe.id + "_instruction" + instruction.instructionId}/>
                            )}
                        </ol>
                    </div>
                )}
            </div>
        )
    }
}

Recipes.contextTypes = {
    store: PropTypes.object
}

export default Recipes;
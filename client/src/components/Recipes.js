import React, {Component} from 'react';
import PropTypes from 'prop-types';

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
                                <li key={recipe.id + "_ingredient" + ingredient.ingredientId}>
                                    {ingredient.measurementAmount} {ingredient.ingredient.name}
                                </li>
                            )}
                        </ul>
                        <h3>Instructions</h3>
                        <ul>
                            {recipe.instructions.map(instruction =>
                                <li key={recipe.id + "_instruction" + instruction.instructionId}>{instruction.instruction.text}</li>
                            )}
                        </ul>
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
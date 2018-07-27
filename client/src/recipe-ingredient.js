import React, {Component} from 'react';

class RecipeIngredient extends Component {
    constructor(props) {
        super(props)

        this.recipeId = props.recipeId
        this.ingredient = props.ingredient.ingredient
        this.measurementAmount = props.ingredient.measurementAmount
    }

    render() {
        return (
            <li>
                {this.measurementAmount} {this.ingredient.name}
            </li>
        )
    }
}

export default RecipeIngredient;
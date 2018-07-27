import React, {Component} from 'react';

class RecipeInstruction extends Component {
    constructor(props) {
        super(props)

        this.recipeId = props.recipeId
        this.instruction = props.instruction.instruction
        this.instructionId = props.instruction.instructionId
    }

    render() {
        return (
            <li>{this.instruction.text}</li>
        )
    }
}

export default RecipeInstruction;
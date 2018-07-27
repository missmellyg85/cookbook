import React, {Component} from 'react';
import {createRecipeStore} from "./store";
import PropTypes from 'prop-types';
import Recipes from './Recipes';


class App extends Component {
    constructor(props) {
        super(props)
    }

    componentWillMount() {
        fetch('http://localhost:8080/recipe/all')
            .then(response => response.json())
            .then(recipes => this.initializeStore(recipes));
    }

    initializeStore(recipes) {
        this.store = createRecipeStore(recipes);

        this.unsubscribe = this.store.subscribe(() => this.forceUpdate());
        this.forceUpdate();
    }

    callWillUnmount() {
        this.unsubscribe();
    }

    getChildContext() {
        return {
            store: this.store || {
                getState: function () {
                    return [];
                }
            }
        }
    }

    render() {
        return (
            <div className="App">
                <Recipes/>
            </div>
        );
    }
}

App.childContextTypes = {store: PropTypes.object.isRequired}

export default App;

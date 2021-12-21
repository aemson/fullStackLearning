import React from 'react'

export default class SecondJsx extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: 'Aemson',
            childName: 'Jonathan',
            times: 1
        }

    }

    render() {
        return (<div>
            <p>Hello From Inner {this.state.name}</p>
            <p>Hello From Child {this.state.childName}</p>
            <p>{this.state.times}</p>
            <button onClick={() => this.setState({name: 'Priyanka'})}> Change Name</button>
        </div>)
    }
}


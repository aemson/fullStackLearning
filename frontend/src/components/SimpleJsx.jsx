import React from 'react'
import SecondJsx from "./SecondJsx";

class SimpleJsx extends React.Component {

    render() {
        return (<div>
            <p>Hello</p>
            <SecondJsx/>
        </div>)
    }
}

export default SimpleJsx
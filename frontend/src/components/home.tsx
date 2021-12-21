import React from "react";
import {Link} from "react-router-dom";

export default () => {
    return (
        <>
            Welcome to awesome learning app
            <main>
                <Link to={"/orderPizza"}>Order your Pizza</Link> <br/>
                <Link to={"/orders"}>View your orders Pizza</Link>
            </main>
        </>
    )
}
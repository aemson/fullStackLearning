import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./components/home";
import OrderPizza from "./components/OrderPizza";
import SimpleJsx from "./components/SimpleJsx";
import Testing from "./components/Testing";

const App = () => {
    return (
        <BrowserRouter basename=''>
            <Routes>
                <Route path='/' element={<Home/>}/>
                <Route path='/orderPizza' element={<OrderPizza/>}/>
                <Route path='/orders' element={<Testing/>}/>
                <Route path='/react' element={<SimpleJsx/>}/>
            </Routes>
        </BrowserRouter>
    );

}

export default App;



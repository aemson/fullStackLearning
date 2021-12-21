import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./components/home";
import OrderPizza from "./components/OrderPizza";
import SimpleJsx from "./components/SimpleJsx";

const App = () => {
    return (
        <BrowserRouter basename=''>
            <Routes>
                <Route path='/' element={<Home/>}/>
                <Route path='/orderPizza' element={<OrderPizza/>}/>
                <Route path='/orders' element={<Home/>}/>
                <Route path='/react' element={<SimpleJsx/>}/>
            </Routes>
        </BrowserRouter>
    );

}

export default App;



import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Auth from "./Auth";
import Wallet from "./Wallet"; 
import Addfunds from "./Addfunds";
import HotelStore from "./HotelStore";
function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Auth />} />
                <Route path="/wallet" element={<Wallet />} />
                <Route path="/Addfunds" element={<Addfunds />} />
                <Route path="/HotelStore" element={<HotelStore />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;

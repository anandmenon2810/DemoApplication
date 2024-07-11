import React from 'react';
import { useNavigate } from 'react-router-dom';
import "./Wallet.css";
function Wallet() {
    const balance = 100.00;
    const navigate = useNavigate();

    return (
<div className="wallet-container">
    <h1>Welcome!</h1>
    <div className="balance-display">
        Balance: ${balance.toFixed(2)}
    </div>
    <button onClick={() => navigate('/HotelStore')}>
        Go to Hotel Store
    </button>
    <button onClick={() => navigate('/Addfunds')}>
        Add Funds
    </button>
</div>

    );
}

export default Wallet;

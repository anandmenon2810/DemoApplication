import "./App.css";
import { useState } from "react";
import { navigate, useNavigate } from "react-router-dom"; // Import useHistory
import MarriotBonvoy from "./MarriotBonvoy.png"

function Auth() {
  const [userId, setUserId] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");
  const navigate = useNavigate(); // Initialize useHistory

  let handleSubmit = async (e) => {
    e.preventDefault();
    try {
      let res = await fetch("http://localhost:8080/api/login", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
             Accept: 'application/json'
        },
        body: JSON.stringify({
          userId: userId,
          password: password,
        }),
      });
      let resJson = await res.json();
      console.log(resJson);
      if (resJson === true) {
        setUserId("");
        setPassword("");
        setMessage("Login Successful");
        navigate('/wallet'); // Redirect to Wallet screen
      } else {
        setMessage("Incorrect Email or Password");
      }
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <div className="App">
         <img src={MarriotBonvoy} alt="MarriotBonvoy" /> {/* Display logo */}
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={userId}
          placeholder="Email or Member Number"
          onChange={(e) => setUserId(e.target.value)}
        />
        <input
          type="password"
          value={password}
          placeholder="Password"
          onChange={(e) => setPassword(e.target.value)}
        />
        <button type="submit">Submit</button>
        <div className="message">{message ? <p>{message}</p> : null}</div>
      </form>
    </div>
  );
}

export default Auth;

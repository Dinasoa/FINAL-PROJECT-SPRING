import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
// import { auth, logInWithEmailAndPassword, signInWithGoogle, signInWithFacebook, signInWithGithub } from "../firebase";
// import { useAuthState } from "react-firebase-hooks/auth";
import '../styles/Login.css'
import { Navbar } from "./Navbar";
export function Login() {
  //   const [email, setEmail] = useState<string>("");
  //   const [password, setPassword] = useState<string>("");
  //   const [user, loading, error] = useAuthState(auth);
  const navigate = useNavigate();

  return (
    <>
      <Navbar />

      <div className="login bg">
        <div className="login__container">

          <h1>Se connecter</h1>

          <input
            type="text"
            className="login__textBox"
            // value={email}
            // onChange={(e) => setEmail(e.target.value)}
            placeholder="E-mail Address"
          />

          <input
            type="password"
            className="login__textBox"
            // value={password}
            // onChange={(e) => setPassword(e.target.value)}
            placeholder="Password"
          />

          <button
            className="login__btn"
            onClick={() => navigate("/")}
          // onClick={() => logInWithEmailAndPassword(email, password)/}
          // onSubmit={() => logInWithEmailAndPassword(email, password)}
          >
            Login
          </button>
          <div>
            Don't have an account? <Link to="/register">Sign Up</Link> now.
          </div>
        </div>
      </div>
    </>
  );
}


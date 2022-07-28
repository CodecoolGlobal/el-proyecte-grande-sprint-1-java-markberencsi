
import React, { useState } from "react";
import api from "./api";
import style from "./signup.module.css";

const getToken = async (emailOrUsername, password) => {
    try {
        const response = await api.post("/api/login", {
            email: emailOrUsername,
            password: password
        });
        return response.data;
    } catch (error) {
        console.log(error.response);
    }
}

// Define the Login form component
const LoginForm = () => {
    const [emailOrUsername, setEmailOrUsername] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = async (event) => {
        event.preventDefault();
        const accesToken = await getToken(emailOrUsername, password);
        localStorage.setItem("accesToken", accesToken);
    }

    return (
        <div className={style.signup_container}>
            <form onSubmit={handleSubmit}>
                <label>
                    Your e-mail
                    <input
                        name="emailOrUsername"
                        type="text"
                        value={emailOrUsername}
                        onChange={e => setEmailOrUsername(e.target.value)}
                    />
                </label>
                <label>
                    Password
                    <input
                        name="password"
                        type="password"
                        value={password}
                        onChange={e => setPassword(e.target.value)}
                    />
                </label>
                <button className={style.signup_button} type="submit">Log in</button>
            </form>
        </div>
    );
    
}

export { LoginForm };
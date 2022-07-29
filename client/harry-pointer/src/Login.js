
import React, { useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import { useAuth } from "./authentication/RequiredAuth";
import style from "./signup.module.css";

// Define the Login form component
const LoginForm = () => {
    const [emailOrUsername, setEmailOrUsername] = useState("");
    const [password, setPassword] = useState("");

    const navigate = useNavigate();
    const location = useLocation();
    const auth = useAuth();

    const handleSubmit = async (event) => {
        event.preventDefault();
        await auth.login(emailOrUsername, password, () => {
            navigate(location.state?.form?.pathname || "/", {replace: true});
        });
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
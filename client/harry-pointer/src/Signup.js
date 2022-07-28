import React, {useState} from "react";
import style from "./signup.module.css";

function SignupForm() {
    const [first_name, setFirstName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [last_name, setLastName] = useState("");
    const [message, setMessage] = useState("");

    let handleSubmit = async (e) => {
        console.log(first_name);
        console.log(email);
        console.log(password);
        e.preventDefault();
        try {
            let res = await fetch("http://localhost:8080/api/signup", {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json'
                    // 'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: JSON.stringify({
                    "first_name": first_name,
                    "last_name": last_name,
                    "email": email,
                    "password": password,
                }),
            });
            if (res.status === 200) {
                setFirstName("");
                setEmail("");
                setLastName("");
                setPassword("");
                console.log("OK")
                setMessage("User created successfully");
            } else {
                console.log("NOTOK")
                setMessage("This e-mail is not available");
            }
        } catch (err) {
            console.log(err);
        }
    };

    return (
        <div className={style.signup_container}>
            <form onSubmit={handleSubmit}>
                <label>First name
                <input
                    type="text"
                    value={first_name}
                    placeholder="First name"
                    onChange={(e) => setFirstName(e.target.value)}
                />
                </label>
                <label>Last name
                    <input
                        type="text"
                        value={last_name}
                        placeholder="First name"
                        onChange={(e) => setLastName(e.target.value)}
                    />
                </label>
                <label> Your Email
                <input
                    type="text"
                    value={email}
                    placeholder="Email"
                    onChange={(e) => setEmail(e.target.value)}
                />
                </label>
                <label> Password
                <input
                    type="password"
                    value={password}
                    placeholder="Password"
                    onChange={(e) => setPassword(e.target.value)}
                />
                </label>
                <button className={style.signup_button} type="submit">Create</button>

                <div className="message">{message ? <p>{message}</p> : null}</div>
            </form>
        </div>
    );
}

export { SignupForm };
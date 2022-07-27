
import Userfront from "@userfront/core";
import React from "react";
import style from "./signup.module.css";

Userfront.init("demo1234");

// Define the Login form component
class LoginForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            emailOrUsername: "",
            password: "",
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleInputChange(event) {
        event.preventDefault();
        const target = event.target;
        this.setState({
            [target.name]: target.value,
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        Userfront.login({
            method: "password",
            emailOrUsername: this.state.emailOrUsername,
            password: this.state.password,
        });
    }

    render() {
        return (
            <div className={style.signup_container}>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Your e-mail
                        <input
                            name="emailOrUsername"
                            type="text"
                            value={this.state.emailOrUsername}
                            onChange={this.handleInputChange}
                        />
                    </label>
                    <label>
                        Password
                        <input
                            name="password"
                            type="password"
                            value={this.state.password}
                            onChange={this.handleInputChange}
                        />
                    </label>
                    <button className={style.signup_button} type="submit">Log in</button>
                </form>
            </div>
        );
    }
}

export { LoginForm };
import { createContext, useState } from "react";
import api from "../api";

export const AuthContext = createContext(null);
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

const AuthProvider = ({children}) => {
    const [accessToken, setAccessToken] = useState(localStorage.getItem('accessToken'));

    const login = async (username, password, callback) => {
        const token = await getToken(username, password);
        if(token)
        {
            setAccessToken(token);
            localStorage.setItem("accessToken", token);
        }
        callback();
    }

    const logout = () => {
        localStorage.removeItem("accessToken");
        setAccessToken(null);
    }

    const values = {accessToken, login, logout};

    return <AuthContext.Provider value={values}>
        {children}
    </AuthContext.Provider>
}

export default AuthProvider;
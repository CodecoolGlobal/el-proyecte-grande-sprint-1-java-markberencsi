import axios from "axios";

const api = axios.create({
    baseURL: process.env.REACT_APP_BASE_URL
})

export const fetchGetAll = async () => {
    try {
        const response = await api.get("/api/houses/all");
        return response.data;
    } catch (error) {
        console.log(error.response);
    }
}

export const fetchGetByName = async (name) => {
    try {
        const response = await api.get("/api/houses/name/" + name);
        return response.data;
    } catch (error) {
        console.log(error.response);
    }
}
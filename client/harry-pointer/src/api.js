import axios from "axios";

const api = axios.create({
    baseURL: process.env.REACT_APP_BASE_URL
})

api.interceptors.request.use(
    request => {
        const accesToken = localStorage.getItem('accessToken');
        request.headers["Authorization"] = "Bearer " + accesToken;
        return request;
    },
    error => {
        return Promise.reject(error);
    }
)

api.interceptors.response.use(
    (response) => {
        return response;
    },
    error => {
        const response = error.response;
        if(response.status === 401) {
        }
        return Promise.reject(error);
    }
)
export default api;
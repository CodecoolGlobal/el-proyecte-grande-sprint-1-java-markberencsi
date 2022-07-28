import axios from "axios";

const api = axios.create({
    baseURL: process.env.REACT_APP_BASE_URL
})

api.interceptors.request.use(
    request => {
        const accesToken = localStorage.getItem('accesToken');
        request.headers["Authorization"] = "Bearer " + accesToken;
        return request;
    },
    error => {
        return Promise.reject(error);
    }
)

api.interceptors.response.use(
    (response) => {
        console.log(response.status);
        return response;
    },
    error => {
        console.log(error);
        const response = error.response;
        if(response.status === 401) {
            window.location.href = "/login";
        }
        console.log(error);
        return Promise.reject(error);
    }
)
export default api;
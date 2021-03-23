import axios from "axios"
const apiUrl = "http://localhost:8080/api/"

class ApiService {
    
    getPrices(endpoint){
        return axios.get(apiUrl+endpoint)
    }

}

export default new ApiService();
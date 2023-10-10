import axios from "axios"

const FARMER_BASE_REST_API_URL = "http://localhost:8082/farmer/ListFarmer";
const ADDFARMER_BASE_REST_API_URL = "http://localhost:8082/farmer/addFarmer";
const UPDATEFARMER_BASE_REST_API_URL = "http://localhost:8082/farmer/updateFarmer";
const DELETEFARMER_BASE_REST_API_URL = "http://localhost:8082/farmer/deleteFarmer";
class FarmerService{
    getAllFarmer(){
        return axios.get(FARMER_BASE_REST_API_URL)
    }

    addFarmer(farmer){
        return axios.post(ADDFARMER_BASE_REST_API_URL,farmer)
    }
    getFarmerById(farmerId){
        return axios.get(FARMER_BASE_REST_API_URL+'/'+farmerId);
    }
    updateFarmer(farmerId, farmer){
        return axios.put(UPDATEFARMER_BASE_REST_API_URL+'/'+farmerId,farmer);
    }
    deleteFarmer(farmerId){
        return axios.delete(DELETEFARMER_BASE_REST_API_URL+'/'+farmerId);
    }
}

export default new FarmerService();
import axios from "axios"

const DEALER_BASE_REST_API_URL = "http://localhost:8086/dealer/ListDealer";
const ADDDEALER_BASE_REST_API_URL = "http://localhost:8086/dealer/addDealer";
const UPDATEDEALER_BASE_REST_API_URL = "http://localhost:8086/dealer/updateDealer";
const DELETEDEALER_BASE_REST_API_URL = "http://localhost:8086/dealer/deleteDealer";
class DealerService{
    getAllDealer(){
        return axios.get(DEALER_BASE_REST_API_URL)
    }

    addDealer(dealer){
        return axios.post(ADDDEALER_BASE_REST_API_URL,dealer)
    }
    getDealerById(dealerId){
        return axios.get(DEALER_BASE_REST_API_URL+'/'+dealerId);
    }
    updateDealer(dealerId, dealer){
        return axios.put(UPDATEDEALER_BASE_REST_API_URL+'/'+dealerId,dealer);
    }
    deleteDealer(dealerId){
        return axios.delete(DELETEDEALER_BASE_REST_API_URL+'/'+dealerId);
    }
}

export default new DealerService();
import axios from 'axios'

const CROP_BASE_REST_API_URL = 'http://localhost:8080/crop/ListCrop';
const ADD_BASE_REST_API_URL = "http://localhost:8080/crop/addCrop";
const UPDATE_BASE_REST_API_URL = "http://localhost:8080/crop/updateCrop";
const DELETE_BASE_REST_API_URL = "http://localhost:8080/crop/deleteCrop";
const SEARCH_BASE_REST_API_URL = "http://localhost:8080/crop/s";


class cropservice{
    getAllCrop(){
        return axios.get(CROP_BASE_REST_API_URL)
    }

    addCrop(crop){
        return axios.post(ADD_BASE_REST_API_URL,crop)
    }

    getCropById(cropId) {
        return axios.get(CROP_BASE_REST_API_URL + '/' + cropId);
    }

    updateCrop(cropId, crop) {
        return axios.put(UPDATE_BASE_REST_API_URL + '/' + cropId, crop);
    }

    deleteCrop(cropId) {
        return axios.delete(DELETE_BASE_REST_API_URL + '/' + cropId);
    }

    findByName(name) {
        return axios.get(SEARCH_BASE_REST_API_URL + '/' + name);
    }

}
export default new cropservice();



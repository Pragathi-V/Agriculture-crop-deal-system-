import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:8080/crop",
  headers: {
    "Content-Type": "application/json",
  },
});
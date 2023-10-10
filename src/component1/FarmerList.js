import React from "react";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import bootstrap from "bootstrap/dist/css/bootstrap.min.css";
import FarmerService from "../services/farmer.service";
import {Delete,Done,Save} from "@mui/icons-material";
import ModeEditIcon from '@mui/icons-material/ModeEdit';
import {Button,Stack, IconButton} from "@mui/material";
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
const FarmerList = () => {
  const [farmer, setFarmer] = useState([])
  useEffect(() => {
    getAllFarmer();
 }, [])

 const getAllFarmer =() =>{
  FarmerService.getAllFarmer().then((response)=> {
      setFarmer(response.data)
      console.log(response.data);
  }).catch(error=>{
      console.log(error);
  })
}

const deleteFarmer=(farmerId)=>{
  FarmerService.deleteFarmer(farmerId).then((response)=>{
      getAllFarmer();
  }).catch(error=>{
      console.log(error);
  })
}
  return (
    <div className="tam">
      
      <h3
        style={{
          color: "black",
          fontWeight: "bolder",
          fontSize: "30px",
          textAlign: "center",
        }}
      >
        List of Farmers
      </h3>
      <hr />
      <div>
        <table
          className="table table-bordered table-transparent table-striped"
          style={{
            width: "80rem",
            marginLeft: "2rem",
            fontSize: "20px",
          }}
        >
          <thead className="thead-light">
            <tr style={{background:"#34532b",color:"white"}}>
            <th> ID</th>
              <th> NAME</th>
              <th> EMAIL</th>
              {/* <th> Password</th> */}
              <th>ACTIONS</th>
            </tr>
          </thead>
          <tbody>
            {farmer.map((farmer) => (
              <tr key={farmer.id} >
                <td>{farmer.id}</td>
                <td>{farmer.name}</td>
                <td>{farmer.email}</td>
                {/* <td>{farmer.password}</td> */}
                <td><Button variant="contained" color="error" onClick={() => deleteFarmer(farmer.id)} style={{marginLeft:"7px"}} endIcon={<Delete />}></Button></td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <><br></br>
        <Link to="/adminprofile">
          <button className="bckc">Back{<ArrowBackIcon/>}</button>
        </Link>
      </>
    </div>
  );
};

export default FarmerList;

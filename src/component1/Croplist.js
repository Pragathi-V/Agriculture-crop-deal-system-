import React from "react";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import ModeEditIcon from '@mui/icons-material/ModeEdit';
import {Button,Stack, IconButton} from "@mui/material";
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import AddIcon from '@mui/icons-material/Add';
import cropservice from "../services/cropservice";
let p = localStorage.getItem("jwt");
const Croplist = () => {
  const [crop, setCrops] = useState([]);
  const booking = (p) => {
    if (!p) {
      window.alert("Please login before you want to buy crops!");
      window.location.href = "/DL";
    } else {
      window.location.href = "/payment";
    }
  };
  const init = () => {
    cropservice
      .getAllCrop()
      .then((response) => {
        console.log("Printing crop data", response.data);
        setCrops(response.data);
      })
      .catch((error) => {
        console.log("Something went wrong", error);
      });
  };

  useEffect(() => {
    init();
  }, []);
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
        List of Crops
      </h3>
      <hr />
      <div>
        <table className="table table-bordered table-transparent table-striped" style={{width:"78rem", textAlign: "center", fontWeight:"bold",fontSize:"17px", marginLeft:"3rem"}}>
          <thead className="thead-dark">
            <tr style={{background:"#34532b",color:"white"}}>
              <th>CROP_ID</th>
              <th>TYPE</th>
              <th>NAME</th>
              <th>PRICE</th>
              <th>ACTIONS</th>
            </tr>
          </thead>
          <tbody>
            
            {crop.map((Crop) => (
              <tr key={Crop.id}>
                <td>{Crop.id}</td>
                <td>{Crop.type}</td>
                <td>{Crop.name}</td>
                <td>{Crop.price}</td>
                <td>
                  <button className="btn btn-success ml-2" onClick={()=>booking(p)}>
                    Buy
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <>

      <Link to="/">
          <button className="bckc">Back {<ArrowBackIcon/>} </button>
        </Link>
      </>
    </div>
  );
};

export default Croplist;
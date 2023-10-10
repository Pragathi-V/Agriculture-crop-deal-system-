import React from "react";
import { useEffect, useState } from "react";
// import { Link } from "react-router-dom";
import AuthService from "../services/auth-service";
import { Link, useHistory, useNavigate } from "react-router-dom";
import cropservice from "../services/cropservice";
import {Logout, LogoutRounded} from "@mui/icons-material";
import ModeEditIcon from '@mui/icons-material/ModeEdit';
import {Button,Stack, IconButton} from "@mui/material";
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import AddIcon from '@mui/icons-material/Add';
import { green } from "@mui/material/colors";
let p = localStorage.getItem("jwt");
const Profile = () => {
  function disableBackButton() 
{ window. history. forward(); } 
setTimeout(disableBackButton(), 0);
  const navigate = useNavigate();
  const [crop, setCrop] = useState([]);
  const buying = (p) => {
      window.location.href = "/payment";
  };
  const init = () => {
    cropservice
      .getAllCrop()
      .then((response) => {
        console.log("Printing crop data", response.data);
        setCrop(response.data);
      })
      .catch((error) => {
        console.log("Something went wrong", error);
      });
  };

  useEffect(() => {
    init();
  }, []);
  const logOut = () => {
    AuthService.logout();
    navigate("/");
  };
  return (
    <div>
      
      <div class="grid-container1">
        <div class="item12">
        
          <h2
            style={{
              fontFamily: "Hanalei Fill'",
              textAlign: "center",
              color: "black",
              fontWeight:"bolder"
            }}
          >
            Welcome Dealer!
            <button
            style={{ marginLeft: "75%" }}
            className="btn btn-danger "
            onClick={() => {
              logOut();
            }}
          >
            
            {<LogoutRounded />}
          </button>
          </h2>
        
        </div>
      </div>
      <div className="tam">
      
      <h3
        style={{
          color: "black",
          fontWeight: "bolder",
          fontSize: "30px",
          textAlign: "center",
        }}
      >
        List of Crops to buy from... 
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
                {
                  localStorage.setItem("crop",Crop.price)
                }
                  {/* <button className="btn btn-success ml-2" onClick={()=>buying(p)}>
                    Buy
                  </button> */}
                  <Link to={`/payment/${Crop.id}`} style={{border:"1px solid green" , padding:"5px",background:"#34532b",color:"white"}}>BUY</Link>
                </td>
              
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <>

      {/* <Link to="/DL">
          <button className="bckc">Back {<ArrowBackIcon/>} </button>
        </Link> */}
      </>
      
    </div>
    </div>
  );
};
export default Profile;
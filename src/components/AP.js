import React from "react";
import AuthService from "../services/auth-service";
import { Link, renderMatches, useHistory, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";


import farmer from "../assets/farmer.png";
import dealer from "../assets/dealer.jpg";
import crop from "../assets/crop.png";
import add from "../assets/add.jpg";
import "./AP.css";

let p = localStorage.getItem("username");




const Adminprofile = () => {
  const navigate = useNavigate();
  const logOut = () => {
    AuthService.logout();
    navigate("/");
  };
  const [user, setUser] = useState([]);
  const init = () => {
    AuthService.getUser(p)
      .then((response) => {
        console.log("Printing user data", response.data);
        setUser(response.data);
      })
      .catch((error) => {
        console.log("Something went wrong", error);
      });
  };
  useEffect(() => {
    init();
  }, []);

  return (
    <div>
      <div class="grid-container1">
        <div class="item1">
          <h2
            style={{
              fontFamily: "Hanalei Fill'",
              textAlign: "center",
              color: "black",
              fontWeight:"bolder"
            }}
          >
           Welcome Admin - <strong>{p}</strong> !
          </h2>
          
        </div>
        <div class="item2">
          <div >
      <h1 >Farmers</h1>
          
          
            
            <div className="container">
        <div className="row">
            <div className="card-container1 mb-4">
            <div className="column">
                    <div className="card"> 
                    <div className="card-body">
                    <Link to="/FarmerList"><img className=" img1 " src={farmer} alt={farmer} width="150" height="200"/>
                    </Link>                                                
                    </div>
                    </div>
                    </div></div></div></div></div></div>

                    <div class="item21">
                    <div className="card2">
      <h1 >Dealers</h1>
                    <div className="container">
                    <div className="card">
                    <div className="card-body">
                    <Link to="/listdealer"><img className=" img1 " src={dealer} alt={dealer} width="150" height="200"/>
                    </Link>                                                
                    
                    
            
           </div>
        </div>
    </div>  
    </div>
        </div>
        <div class="item22">
                    <div className="card2">
      <h1 >Crops</h1>
                    <div className="container">
                    <div className="card">
                    <div className="card-body">
                    <Link to="/croplist1"><img className=" img1 " src={crop} alt={crop} width="150" height="200"/>
                    </Link>   
                    </div>
        </div>
    </div>  
    </div>
        </div>


        <div class="item23">
                    <div className="card2">
      <h1 >Add Crops</h1>
                    <div className="container">
                    <div className="card">
                    <div className="card-body">
                    <Link to="/AddCrop"><img className=" img1 " src={add} alt={add} width="150" height="200"/>
                    </Link>   
                    </div>
        </div>
    </div>  
    </div>
        </div>
      </div>
    </div>
  );
};
export default Adminprofile;
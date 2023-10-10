import React from 'react'
import AuthService from "../services/auth-service";
import { Link, renderMatches, useHistory, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

import image2 from "../assets/image2.jpg";
import farmer from "../assets/farmer.png";
import dealer from "../assets/dealer.jpg";
import crop from "../assets/crop.png";
import add from "../assets/add.jpg";
import admin from "../assets/admin.png";

const Showcase = () => {
  const navigate = useNavigate();
  return (
    <div className='showcase'>
      <div class="grid-container2"style={{ paddingTop: "180px" }}>
         
          <div className="container">
      <div className="row">
          <div className="card-container1 mb-4">
          <div className="column">
          <h2>Farmers</h2>
                  <div className="card"> 
                  
                  <div className="card-body">
                  <Link to="/Farmerlogin"><img className=" img1 " src={farmer} alt={farmer} width="150" height="200"/>
                  </Link>                                                
                  </div>
                  </div>
                  </div></div></div></div>

                  <div class="item21">
                  <div className="card2">
                  <h2>Dealers</h2>
                  <div className="container">
                  <div className="card">
                  <div className="card-body">
                  <Link to="/DL"><img className=" img1 " src={dealer} alt={dealer} width="150" height="200"/>
                  </Link>                                                
                  
                  
                  </div>
      </div>
         
      </div>
  </div>  
  </div>
  <div class="item22">
                    <div className="card2">
                    <h2 >Crops</h2>
                    <div className="container">
                    <div className="card">
                    <div className="card-body">
                    <Link to="/croplist"><img className=" img1 " src={crop} alt={crop} width="150" height="200"/>
                    </Link>   
                    </div>
        </div>
    </div>  
    </div>
        </div>
        <div class="item21">
                  <div className="card2">
                  <h2>Admin</h2>
                  <div className="container">
                  <div className="card">
                  <div className="card-body">
                  <Link to="/Adminlogin"><img className=" img1 " src={admin} alt={admin} width="150" height="200"/>
                  </Link>                                                
                  
                  
                  </div>
      </div>
         
      </div>
  </div>  
  </div>
       </div>
       {/* </div> */}
    </div>
  )
}

export default Showcase

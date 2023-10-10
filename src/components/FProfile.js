import React from "react";
import AuthService from "../services/auth-service";
import { Link, useHistory, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import crop from "../assets/crop.png";
import add from "../assets/add.jpg";
import {Logout, LogoutRounded} from "@mui/icons-material";
// import images1 from "../assets/images1.jpg";
import image2 from "../assets/image2.jpg";
let p = localStorage.getItem("username");
let j = localStorage.getItem("jwt");
const FProfile = () => {
  function disableBackButton() 
  { window. history. forward(); } 
  setTimeout(disableBackButton(), 0);
  const navigate = useNavigate();
  const logOut = () => {
    AuthService.logout();
    navigate("/");
  };
  const [user, setFaculty] = useState([]);
  const init = () => {
    AuthService.getUser(p)
      .then((response) => {
        console.log("Printing faculty data", response.data);
        setFaculty(response.data);
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
      
        
        {/* <button
            style={{ marginLeft: "88rem", marginTop:"10px" }}
            className="btn btn-danger "
            onClick={() => {
              logOut();
            }}
          >
            LOGOUT
          </button> */}
          
         {/* <h3
            style={{
              color: "green",
              textAlign: "center",
              paddingTop: "10px",
            }}
          >
            {/* <strong>{p}</strong>
          </h3> */}

          
        {/* </div> */}
        <div class="item2">
          {" "}
          {/* <p style={{ color: "black", textAlign: "center", fontSize: "medium" }}>
            <strong>Email:</strong> {user.emailId}
          </p>
          <br></br>
          <p style={{ color: "black", textAlign: "center", fontSize: "medium" }}>
            <strong>Age:</strong> {user.age}
          </p>
          <br></br>
          <p style={{ color: "black", textAlign: "center", fontSize: "medium" }}>
            <strong>Gender:</strong> {user.gender}
          </p>
          <br></br>
          <p style={{ color: "black", textAlign: "center", fontSize: "medium" }}>
            <strong>Contact No:</strong> {user.ph_no}
          </p> */}
           {/* <Link
            className="btn btn-success"
            to={`/Croplist3`}
            style={{ marginLeft: "10px" , marginTop:"70px"}}
          >
            Show Crops
          </Link>
          
          <Link
            className="btn btn-warning"
            to={`/Addcrop1`}
            style={{ marginLeft: "30px", marginTop:"70px" }}
          >
            Add Crops
          </Link>
        </div> */}
        <div class="item11">
        <h2
            style={{
              fontFamily: "Hanalei Fill'",
              textAlign: "center",
              color: "black",
              fontWeight:"bolder"
            }}
          >
            Welcome Farmer!  <button
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
        <div class="grid-container3 "style={{paddingLeft:"30%", paddingTop: "10px" }}>
        
  <div class="item22">
                    <div className="card2">
      <h1 >Crops</h1>
                    <div className="container">
                    <div className="card">
                    <div className="card-body">
                    <Link to="/Croplist3"><img className=" img1 " src={crop} alt={crop} width="150" height="200"/>
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
                    <Link to="/AddCrop1"><img className=" img1 " src={add} alt={add} width="150" height="200"/>
                    </Link>   
                    </div>
        </div>
    </div>  
    </div>
        </div>
        </div>
        {/* <div class="item3">
       
            <table className="table table-bordered table-dark table-striped">
              <thead className="thead-light">
                <tr>
                  <th> UserName</th>
                  <th> EmailId</th>
                  <th> PhoneNo</th>
                  <th> Roles</th>
                  <th> Actions</th>
                </tr>
              </thead>
              <tbody>
                <tr key={user.id}>
                  <td>{user.username}</td>
                  <td>{user.emailId}</td>
                  <td>{user.ph_no}</td>
                  <td>{user.roles}</td>
                  <td><Link
                    className="btn btn-warning"
                    to={`/user/edit/${user.id}`}
                  >
                    Update
                  </Link></td>
                </tr>
              </tbody>
            </table> */}
           
        </div>

        {/* <div class="item5">
          {" "}
          <footer id="footer">
            <ul class="navbar-nav">
              <li>
                Get connected with us on
                <img
                  src={image2}
                  alt="My Image"
                  style={{ height: "3rem", width: "27rem" }}
                />
              </li>
            </ul>
          </footer>
        </div> */}
      
    </div>
  );
};
export default FProfile;
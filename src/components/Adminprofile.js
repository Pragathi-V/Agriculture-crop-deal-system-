import React from "react";
import AuthService from "../services/auth-service";
import { Link, renderMatches, useHistory, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

import image2 from "../assets/image2.jpg";
import farmer from "../assets/farmer.png";
import dealer from "../assets/dealer.jpg";
import crop from "../assets/crop.png";
import add from "../assets/add.jpg";
// let o = localStorage.getItem("id");
let p = localStorage.getItem("username");
let q=localStorage.getItem("email");
let r=localStorage.getItem("roles");
let j = localStorage.getItem("jwt");



const Adminprofile = () => {
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

// render() {
//   const{user:currentUser}=this.props;
//   if(!currentUser){
//     return <Redirect to="/"/>;
//   }
// }



  return (
    <div>
      <div class="grid-container1"style={{paddingLeft:"10%", paddingTop: "10px" }}>
        <div class="item1">
          <h2
            style={{
              fontFamily: "Hanalei Fill'",
              textAlign: "center",
              color: "black",
              fontWeight:"bolder"
            }}
          >
           Welcome Admin - <strong>{p}</strong>!
          </h2>
          {/* <h3
            style={{
              color: "green",
              textAlign: "center",
              paddingTop: "10px",
            }}
          >
            
          </h3> */}
        </div>
        <div class="item2">
          {/* {" "}
          <p style={{ color: "black", textAlign: "center", fontSize: "small" }}>
            <strong>Email:</strong> {user.emailId}
          </p>
          <br></br>
          <p style={{ color: "black", textAlign: "center", fontSize: "small" }}>
            <strong>Age:</strong> {user.age}
          </p>
          <br></br>
          <p style={{ color: "black", textAlign: "center", fontSize: "small" }}>
            <strong>Gender:</strong> {user.gender}
          </p>
          <br></br>
          <p style={{ color: "black", textAlign: "center", fontSize: "small" }}>
            <strong>Contact No:</strong> {user.ph_no}
          </p> */}
          
          





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
        {/* <div class="item3">
          <table className="table table-bordered table-dark table-striped">
            <thead className="thead-light">
              <tr>
                <th> UserName</th>
                <th> EmailId</th>
                <th> Roles</th>
              </tr>
            </thead>
            <tbody>
            {
        user.map(
          user => 
          <tr key = {user.id}>
                <td>{p}</td>
                <td>{q}</td>
                <td>{r}</td>
            </tr>
        )
    }
            </tbody>
          </table>
        </div> */}

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
    </div>
  );
};
export default Adminprofile;
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";
import AuthService from "../services/auth-service";
import Form from "react-bootstrap/Form";
import logo1 from "../assets/logo1.png";
// import "./Header.css";
import {Logout, LogoutRounded} from "@mui/icons-material";
import HomeIcon from '@mui/icons-material/Home';
import CallIcon from '@mui/icons-material/Call';
import AdminPanelSettingsIcon from '@mui/icons-material/AdminPanelSettings';
// import {Home} from "@mui/icons-material";
// import {Button,Stack, IconButton} from "@mui/material";


let b = localStorage.getItem("username");
let s = false;
if (b != undefined) {
  s = true;
}
const Header = () => {

 
  const [crop, setCrop] = useState([]);
  const [name, setName] = useState([]);

  const search = (e) => {
    const val = {
      name,
    };

    localStorage.setItem("n", name);
    window.location.href = "/CropDetails";
  };

  // const HomeIcon = createSvgIcon(
  //   <path d="M10 20v-6h4v6h5v-8h3L12 3 2 12h3v8z" />,
  //   'Home',
  // );
  

  return (
    <header className="header">
      <div>
        <img
          src={logo1}
          alt=""
          style={{
            height: "40px",
            width: "120px",
            paddingRight: "20px",
          }}
        />
      </div>

      <nav className="navbar" style={{ height: "40px", paddingRight: "235px" }}>
        <ul className = "navlinks">
          <Link className="links" to="/">
            {< HomeIcon/>}

          </Link>
          {/* <Link className="links" to="/Adminlogin">
            Admin{<AdminPanelSettingsIcon/>}
          </Link> */}
          {/* <Link className="links" to="/Farmerlogin">
            Farmer
          </Link>
          <Link className="links" to="/DL">
            Dealer
          </Link> */}
          <Link className="links" to="/Contact">
          Contact{< CallIcon />}
          </Link>
          {/* <Link className="btn btn-warning"  style={{marginLeft:"14px", width:"88px", fontSize:"15px"}} to="/Croplist">
            Crop
          </Link> */}
         { s
          ?<button
              // style={{ marginLeft: "30rem", marginTop:"9px" }}
              className="btn btn-danger "
              style={{marginLeft:"1rem", width:"50px", fontSize:"13px"}}
              onClick={(e) => {
                window.location.href="/Logout"
              }}
            >
             {<LogoutRounded />}
            </button>
            :<> </>
          }
        </ul>
      </nav>
      <Form className="d-flex">
        <Form.Control
          type="search"
          placeholder="Search by crop name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          className="me-2"
          aria-label="Search"
          style={{ marginLeft: "330px", height: "35px", width: "270px" }}
        />
        
        <button
          type="button"
          style={{ width: "78px", height: "32px", textAllign: "center" }}
          class="btn btn-warning homecontactbtn1"
          onClick={search}
        >
          Search 
        </button>
      </Form>
    </header>
  );
};

export default Header;

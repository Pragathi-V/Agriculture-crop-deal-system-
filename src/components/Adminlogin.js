import React, { useState, useRef } from "react";
import { Link, useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";
import auth from "../services/auth-service";
// import Form from "react-bootstrap/Form";
import image2 from "../assets/image2.jpg";
// import Input from "react-validation/build/input";
// import CheckButton from "react-validation/build/button";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import LoginRounded from "@mui/icons-material/LoginRounded";


const Adminlogin = () => {
  function disableBackButton() 
{ window. history. forward(); } 
setTimeout(disableBackButton(), 0);
  const [username, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  const Regi = (e) => {
    e.preventDefault();

    const val = {
      username,
      password,
    };

    auth
      .auth(val)
      .then((response) => {
        console.log("Feedback added successfully", response.data);
        localStorage.setItem("jwt", response.data.jwt);
        localStorage.setItem("username", val.username);

        window.location.href = "/Adminprofile";
      })
      .catch((error) => {
        console.log("Something went wrong", error);
      });
  };

  

  let loginSchema = Yup.object().shape({
    username: Yup.string()      
      .required("Username is mandatory"),
    password: Yup.string()
      .required("Password is mandatory"),
  });
  

  return (
    <div >
      <div style={{textAlign:"center"}}> <h1> Admin Login</h1></div> 
      <div class="container d-flex justify-content-center">
      <Formik
        initialValues={{ username: "", password: "" }}
        onSubmit={(e) => Adminlogin(e)}
        validationSchema={loginSchema}
      >
        <form
          className="form-control"
          style={{
            width: "33rem",
            height: "12rem",
            marginTop: "7rem",
            marginRight: "15rem",
            boxShadow: '1px 2px 9px #F4AAB9',
            backgroundColor: "#6B8E23 "
          }}
        >
          <div class="form-group pt-2 pl-1">
            <label
              for="exampleInputName"
              style={{ fontSize: "20px",fontWeight:"bolder", color: "black" }}
            >
              
              UserName
            </label>
            {/* <Field type="username" name="username" className="form-control" /> */}
            <input
              type="text"
              class="form-control"
              id="exampleInputName"
              value={username}
              placeholder="Enter your UserName"
              onChange={(e) => setUserName(e.target.value)}
              
            />
            <ErrorMessage name="username">
                {(error) => <p className="error-info">{error}</p>}
              </ErrorMessage>
          </div>

          <div class="form-group pl-1">
            <label for="password" style={{ fontSize: "20px",fontWeight:"bolder", color: "black" }}>
              Password
            </label>
            {/* <Field type="password" name="password" className="form-control" /> */}
            <input
              type="password"
              class="form-control"
              id="exampleInputPassword"
              value={password}
              placeholder="Enter your Password"
              onChange={(e) => setPassword(e.target.value)}
            />
            <ErrorMessage name="password">
                {(error) => <p className="error-info">{error}</p>}
              </ErrorMessage>
          </div>
          <div>
            <div class="row homecontactbtn">
              <button
                class="btn btn-primary homecontactbtn1"
                onClick={(e) => {
                  Regi(e);
                }}
                style={{
                  marginTop: "3rem",
                  fontFamily: "serif",
                  paddingTop: "10px",
                  width: "10rem",
                  alignItems: "center",
                  marginLeft: "190px",
                  fontSize: "20px",
                }}
              >
                Login{<LoginRounded/>}
              </button>
            </div>
          </div>
        </form></Formik>
      </div>
    </div>
  );
};

export default Adminlogin;

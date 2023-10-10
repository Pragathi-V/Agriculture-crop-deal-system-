// import React, { useState, useEffect } from "react";
// import auth from "../services/auth-service";
// import { Link, useNavigate, useParams } from "react-router-dom";
//  const Dealerlogin = () => {
//    const [username, setUserName] = useState("");
//    const [password, setPass] = useState("");
//    const navigate = useNavigate();
//    const Regi = (e) => {
//      e.preventDefault();

//      const val = {
//        username,
//        password,
//      };

//      auth
//        .auth(val)
//        .then((response) => {
//          console.log("Feedback added successfully", response.data);
//          localStorage.setItem("jwt", response.data.jwt);
//          localStorage.setItem("username", val.username);

//          window.location.href = "/Dprofile";
//        })
//        .catch((error) => {
//          console.log("Something went wrong", error);
//        });
//    };

//    return (
//      <div>
//        <div style={{textAlign:"center"}}> <h1> Dealer Login</h1></div> 
//        <div class="container d-flex justify-content-center" >
//          <form
//            className="form-control"
//            style={{
//             width: "33rem",
//             height: "12rem",
//             marginTop: "9rem",
//             marginRight: "15rem",
//             boxShadow: '1px 2px 9px #F4AAB9',
//             backgroundColor: "tan"
//           }}
//          >
//            <div class="form-group pt-2 pl-1">
//              <label
//                for="exampleInputName"
//                style={{ fontSize: "20px",fontWeight:"bolder",color: "black" }}
//              >
//                {" "}
//                Enter your UserName
//              </label>
//              <input
//                type="text"
//                class="form-control"
//                id="exampleInputName"
//                value={username}
//                onChange={(e) => setUserName(e.target.value)}
//              />
//            </div>

//            <div class="form-group pl-1">
//              <label for="password" style={{ fontSize: "20px", fontWeight:"bolder",color: "black" }}>
//                Enter your Password
//              </label>
//              <input
//                type="password"
//                class="form-control"
//                id="exampleInputPassword"
//                value={password}
//                onChange={(e) => setPass(e.target.value)}
//              />
//            </div>
//            <div>
//              <div class="row homecontactbtn">
//                <button
//                  class="btn btn-primary homecontactbtn1"
//                  onClick={(e) => {
//                    Regi(e);
//                  }}
//                  style={{
//                   marginTop: "3rem",
//                   fontFamily: "serif",
//                   paddingTop: "10px",
//                   width: "10rem",
//                   alignItems: "center",
//                   marginLeft: "190px",
//                   fontSize: "20px",
//                  }}
//                >
//                  Login
//                </button>
//              </div>
//            </div>
//          </form>
//        </div>
//      </div>
//    );
//  };
//  export default Dealerlogin;


// import { Formik, Form, Field, ErrorMessage } from "formik";
// import * as Yup from "yup";
// import "./login.css";
// import axios from "axios";
// import { useNavigate, Link } from "react-router-dom";
// function Dealerlogin() {
//   const navigate = useNavigate();
//   let login = (values) => {
//     let username = values.username;
//     let password = values.password;

//     axios.get("http://localhost:8086/dealer/Listdealer").then((response)=>{
//         let users=response.data;
//         let validUser=users.filter((users)=> {
//             return users.username === username && users.password === password;
//         });
//         if(validUser.length>0){
//             alert("success");
//             navigate("/Dprofile");

//         }
//         else{
//             alert("login failed");
//         }
//     });
// }


//   let loginSchema = Yup.object().shape({
//     username: Yup.string()
//       // .username("Enter valid username")
//       .required("Email is mandatory"),
//     password: Yup.string()
//       .required("password is mandatory"),
//   });
//   return (
//     <div className="login-container d-flex flex-column align-items-center ">
//       <h1 className="heading">LOGIN</h1>

//       <Formik
//         initialValues={{ username: "", password: "" }}
//         onSubmit={(e) => login(e)}
//         validationSchema={loginSchema}
//       >
//         {(props) => (
//           <Form>
//             <div className="field-container">
//               <label className="form-label">Username</label>
//               <Field type="username" name="username" className="form-control" />
//               <ErrorMessage name="username">
//                 {(error) => <p className="error-info">{error}</p>}
//               </ErrorMessage>
//             </div>
//             <div className="field-container">
//               <label className="form-label">Password</label>
//               <Field type="password" name="password" className="form-control" />
//               <ErrorMessage name="password">
//                 {(error) => <p className="error-info">{error}</p>}
//               </ErrorMessage>
//             </div>
//             <div className="d-flex align-items-center justify-content-center">
//               <button type="submit" className="btn btn-primary login-btn">      
//                 Login            
//               </button>
//             </div>
//           </Form>
//         )}
//       </Formik>
//       <p className="new">
//         New User?<button className="sbutton"> <Link to="/SignUp1">Signup</Link></button>
//       </p>
//     </div>
//   );
// }

// export default Dealerlogin;






import React, { useState, useRef } from "react";
import { Link, useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";
import auth from "../services/auth-service";
import Form from "react-bootstrap/Form";
import image2 from "../assets/image2.jpg";

const Dealerlogin = () => {
  
  const [username, setUserName] = useState("");
  const [password, setPass] = useState("");
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

        window.location.href = "/Dprofile";
      })
      .catch((error) => {
        console.log("Something went wrong", error);
      });
  };

  return (
    <div style={{backgroundColor:"white"}}>
      <div style={{textAlign:"center"}}> <h1> Dealer Login</h1></div> 
      <div class="container d-flex justify-content-center">
        
        <form
          className="form-control"
          style={{
            width: "33rem",
            height: "12rem",
            marginTop: "9rem",
            marginRight: "17rem",
            boxShadow: '1px 2px 9px #F4AAB9',
            backgroundColor: "thistle "
          }}
        >
          <div class="form-group pt-2 pl-1">
            <label
              for="exampleInputName"
              style={{ fontSize: "20px",fontWeight:"bolder", color: "black" }}
            >
              
              Enter your UserName
            </label>
            <input
              type="text"
              class="form-control"
              id="exampleInputName"
              value={username}
              onChange={(e) => setUserName(e.target.value)}
            />
          </div>

          <div class="form-group pl-1">
            <label for="password" style={{ fontSize: "20px",fontWeight:"bolder", color: "black" }}>
              Enter your Password
            </label>
            <input
              type="password"
              class="form-control"
              id="exampleInputPassword"
              value={password}
              onChange={(e) => setPass(e.target.value)}
            />
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
                Login
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Dealerlogin;

import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import "./login.css";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";
import PeopleIcon from '@mui/icons-material/People';
import LoginRounded from "@mui/icons-material/LoginRounded";
function DL() {
  function disableBackButton() 
{ window. history. forward(); } 
setTimeout(disableBackButton(), 0);
  const navigate = useNavigate();
  let login = (values) => {
    let email = values.email;
    let password = values.password;

    axios.get("http://localhost:8086/dealer/ListDealer").then((response)=>{
        let users=response.data;
        let validUser=users.filter((users)=> {
            return users.email === email && users.password === password;
        });
        if(validUser.length>0){
            alert("success");
            navigate("/Dprofile");

        }
        else{
            alert("login failed");
        }
    });
}


  let loginSchema = Yup.object().shape({
    email: Yup.string()
      .email("Enter valid email")
      .required("Email is mandatory"),
    password: Yup.string()
      .required("Password is mandatory"),
  });
  return (
    <div style={{backgroundColor:"white"}}>
    <div style={{textAlign:"center"}}><h1>Dealer Login</h1></div>
    <div className="container d-flex justify-content-center ">
    

      <Formik
        initialValues={{ email: "", password: "" }}
        onSubmit={(e) => login(e)}
        validationSchema={loginSchema}
      >
        {/* {(props) => ( */}
          <Form
          className="form-control"
          style={{
            width: "33rem",
            height: "25rem",
            marginTop: "2rem",
            marginRight: "15rem",
            boxShadow: '1px 2px 9px #F4AAB9',
            backgroundColor: "#6B8E23 "
          }}
          >
            <div className="form-group pt-2 pl-1">
              <label style={{ fontSize: "20px",fontWeight:"bolder", color: "black" }}>Email</label>
              <Field type="email" name="email" className="form-control" />
              <ErrorMessage name="email">
                {(error) => <p className="error-info">{error}</p>}
              </ErrorMessage>
            </div>
            <div className="form-group pt-2 pl-1">
              <label className="form-label" style={{ fontSize: "20px",fontWeight:"bolder", color: "black" }}>Password</label>
              <Field type="password" name="password" className="form-control" />
              <ErrorMessage name="password">
                {(error) => <p className="error-info">{error}</p>}
              </ErrorMessage>
            </div>
              <Link className = "btn btn-primary login-btn" to = {`/add-dealer`} style={{marginLeft: "28%"}} > New user? Please register! {< PeopleIcon/>}
</Link>
            <div className="row homecontactbtn">
              <button type="submit" className="btn btn-primary login-btn" style={{
                  marginTop: "1rem",
                  fontFamily: "serif",
                  paddingTop: "10px",
                  width: "10rem",
                  alignItems: "center",
                  marginLeft: "190px",
                  fontSize: "20px",
                }}>      
                Login {<LoginRounded/>}            
              </button>
            </div>
          </Form>
        
      </Formik>
      
    </div></div>
  );
}

export default DL;
// import { Formik, Form, Field, ErrorMessage } from "formik";
// import * as Yup from "yup";
// import "./login.css";
// import axios from "axios";
// import { useNavigate, Link } from "react-router-dom";
// import PeopleIcon from '@mui/icons-material/People';
// import LoginRounded from "@mui/icons-material/LoginRounded";
// function DL() {
//   const navigate = useNavigate();
//   let login = (values) => {
//     let email = values.email;
//     let password = values.password;

//     axios.get("http://localhost:8086/dealer/ListDealer").then((response)=>{
//         let users=response.data;
//         let validUser=users.filter((users)=> {
//             return users.email === email && users.password === password;
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
//     email: Yup.string()
//       .email("Enter valid email")
//       .required("Email is mandatory"),
//     password: Yup.string()
//       .required("Password is mandatory"),
//   });
// //   return (
// //     <div style={{backgroundColor:"white"}}>
// //     <div style={{textAlign:"center"}}><h1>Dealer Login</h1></div>
// //     <div className="container d-flex justify-content-center ">
    

// //       <Formik
// //         initialValues={{ email: "", password: "" }}
// //         onSubmit={(e) => login(e)}
// //         validationSchema={loginSchema}
// //       >
// //         {/* {(props) => ( */}
// //           <Form
// //           className="form-control"
// //           style={{
// //             width: "33rem",
// //             height: "19rem",
// //             marginTop: "4rem",
// //             marginRight: "15rem",
// //             boxShadow: '1px 2px 9px #F4AAB9',
// //             backgroundColor: "thistle "
// //           }}
// //           >
// //             <div className="form-group pt-2 pl-1">
// //               <label style={{ fontSize: "20px",fontWeight:"bolder", color: "black" }}>Email</label>
// //               <Field type="email" name="email" className="form-control" />
// //               <ErrorMessage name="email">
// //                 {(error) => <p className="error-info">{error}</p>}
// //               </ErrorMessage>
// //             </div>
// //             <div className="form-group pt-2 pl-1">
// //               <label className="form-label" style={{ fontSize: "20px",fontWeight:"bolder", color: "black" }}>Password</label>
// //               <Field type="password" name="password" className="form-control" />
// //               <ErrorMessage name="password">
// //                 {(error) => <p className="error-info">{error}</p>}
// //               </ErrorMessage>
// //             </div>
// //             <Link className="links" to="/add-dealer">
// //             SignUp
// //           </Link>
// //             <div className="row homecontactbtn">
// //               <button type="submit" className="btn btn-primary login-btn" style={{
// //                   marginTop: "3rem",
// //                   fontFamily: "serif",
// //                   paddingTop: "10px",
// //                   width: "10rem",
// //                   alignItems: "center",
// //                   marginLeft: "190px",
// //                   fontSize: "20px",
// //                 }}>      
// //                 Login            
// //               </button>
// //             </div>
// //           </Form>
        
// //       </Formik>
      
// //     </div></div>
// //   );
// // }
// return (
//   <div className="login-container d-flex flex-column align-items-center ">
//     <h1 className="heading">Dealer Login</h1>

//     <Formik
//       initialValues={{ email: "", password: "" }}
//       onSubmit={(e) => login(e)}
//       validationSchema={loginSchema}
//     >
//       {(props) => (
//         <Form>
//           <div className="field-container">
//             <label className="form-label">Email</label>
//             <Field type="email" name="email" className="form-control" />
//             <ErrorMessage name="email">
//               {(error) => <p className="error-info">{error}</p>}
//             </ErrorMessage>
//           </div>
//           <div className="field-container">
//             <label className="form-label">Password</label>
//             <Field type="password" name="password" className="form-control" />
//             <ErrorMessage name="password">
//               {(error) => <p className="error-info">{error}</p>}
//             </ErrorMessage>
//           </div>
//           <div className="d-flex align-items-center justify-content-center">
//             <button type="submit" className="btn btn-primary login-btn">      
//               Login {<LoginRounded/>}           
//             </button>
//           </div>
//         </Form>
//       )}
//     </Formik>
//     <Link className="links" to="/add-dealer">
//           New user? Please register!{<PeopleIcon/>}
//         </Link>
//   </div>
// );
// }
// export default DL;
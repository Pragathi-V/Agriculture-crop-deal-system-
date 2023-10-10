import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import "./login.css";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";
import PeopleIcon from '@mui/icons-material/People';
import LoginRounded from "@mui/icons-material/LoginRounded";
function Farmerlogin() {
  function disableBackButton() 
{ window. history. forward(); } 
setTimeout(disableBackButton(), 0);
  
const navigate = useNavigate();
  let login = (values) => {
    let email = values.email;
    let password = values.password;

    axios.get("http://localhost:8082/farmer/ListFarmer").then((response)=>{
        let users=response.data;
        let validUser=users.filter((users)=> {
            return users.email === email && users.password === password;
        });
        if(validUser.length>0){
            alert("success");
            navigate("/Fprofile");

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
    <div style={{textAlign:"center"}}><h1>Farmer Login</h1></div>
    <div className="container d-flex justify-content-center ">
    

      <Formik
        initialValues={{ email: "", password: "" }}
        onSubmit={(e) => login(e)}
        validationSchema={loginSchema}
      >
       
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
            <Link className = "btn btn-primary login-btn" to = {`/Farmersignup`} style={{marginLeft: "28%"}} > New user? Please register! {< PeopleIcon/>}
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

export default Farmerlogin;
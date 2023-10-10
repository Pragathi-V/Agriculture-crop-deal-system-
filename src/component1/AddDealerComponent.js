
import React, { useEffect, useState } from 'react'
import {Link, useParams, useNavigate} from 'react-router-dom'
import DealerService from '../services/DealerService'
import {Delete,Done,Save,Edit} from "@mui/icons-material";
import {Button,Stack, IconButton} from "@mui/material";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import CancelIcon from '@mui/icons-material/Cancel';
export const AddDealerComponent = () => {
  const [name,setName] = useState('')
  const [email,setEmail] = useState('')
  const [password,setPassword] = useState('')
  const{id} = useParams();
  const navigate = useNavigate();
  const saveorUpdateDealer = (e)=> {
    e.preventDefault();

    const dealer = {name, email, password}
  
    if(id){
        DealerService.updateDealer(id,dealer).then((response)=>{
            navigate("/");
        }).catch(error =>{
            console.log(error);
        })
    }else{
        DealerService.addDealer(dealer).then((response)=>{
            console.log(response.data)
            navigate("/DL");
           }).catch(error=>{
            console.log(error)
           })
          }
    }

  

  useEffect(()=>{
    DealerService.getDealerById(id).then((response)=>{
        setName(response.data.name)
        setEmail(response.data.email)
        setPassword(response.data.password)
    }).catch(error => {
        console.log(error)
    })
    },[])

    const title = () =>{
        if(id){
            return <h2 className="text-center">Update Dealer</h2>
        }
        else{
                return <h2 className="text-center">Dealer Registration</h2>
        }
        
    }
    function SubmitBtn() {
      if (
        name &&
        email &&
        password 
      )
        return (
          
          <Button variant="contained" color="success"  onClick={(o) => saveorUpdateDealer(o)} endIcon={<Save />}></Button>
        );
      else
        return (
          
          <Button variant="contained" color="success" endIcon={<Save />} disabled></Button>
        );
    }

    // let SignSchema = Yup.object().shape({
    //   name: Yup.string()
    //   .matches(/^[aA-zZ .\s]+$/, "Only alphabets are allowed for this field ").min(4)
    //   .required("Name is mandatory"),
    //   email: Yup.string()
    //     .email("Enter valid email id")
    //     .required("Email is mandatory"),
    //   password: Yup.string()
    //     .matches(/[A-Z]([a-z])(\d)(\W)/, "password must conatin 1-upper case letter, 1-digit, 1-special symbol ")
    //     .min(6)
    //     .required("Password is mandatory"),
    // });

    return (
    <div>
        <br/>
        <br/>
        <br/>
        <div className = "container">
            <div className = "row">
                <div className = "card col-md-6 offset-md-3 offset-md-3">
                   {
                    title()
                   }

                    <div className="card-body">
                    <Formik
        initialValues={{ name: "",email: "", password: "" }}
        // validationSchema={SignSchema}
        onSubmit={(e) => AddDealerComponent(e)}
      >
                 <form>
                    <div className = "form-group mb-2">
                        <label className = "form-label">Name : </label>
                        <Field 
                        type="name" 
                        name="name" 
                        className="form-control"  
                        placeholder = "Enter Name"
                        value = {name}
                        onChange = {(e) => setName(e.target.value)}
                        
                        />
                    {/* <input 
                    type = "text"
                    placeholder = "Enter Name"
                    name = "Name"
                    className="form-control"
                    value = {name}
                    onChange = {(e) => setName(e.target.value)}
                    required
                    pattern='^[A-Za-z -]+$'
                    ></input> */}
                    <ErrorMessage name="name">
                {(error) => <p className="error-info">{error}</p>}
              </ErrorMessage>
                </div>
          
                
                <div className = "form-group mb-2">
                        <label className = "form-label">Email : </label>
                        <Field 
                        type="email" 
                        name="email" 
                        className="form-control"
                        placeholder = "Enter Email"
                        value = {email}
                        onChange = {(e) => setEmail(e.target.value)}
                        />
                    {/* <input 
                    type = "email"
                    placeholder = "Enter Email"
                    name = "Email"
                    className="form-control"
                    value = {email}
                    onChange = {(e) => setEmail(e.target.value)}
                    required
                   ></input> */}
                    <ErrorMessage name="email">
                {(error) => <p className="error-info">{error}</p>}
              </ErrorMessage>
                </div>


                <div className = "form-group mb-2">
                        <label className = "form-label">Password : </label>
                        <Field 
                        type="password" 
                        name="password" 
                        className="form-control" 
                        placeholder = "Enter Password"
                        value = {password}
                        onChange = {(e) => setPassword(e.target.value)}
                   />
                    {/* <input 
                    type = "text"
                    placeholder = "Enter Password"
                    name = "Password"
                    className="form-control"
                    value = {password}
                    onChange = {(e) => setPassword(e.target.value)}
                    required
                    pattern='^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()â€“[{}]:;,?/*~$^+=<>]).{8,20}$'
                    ></input> */}
                    <ErrorMessage name="password">
                {(error) => <p className="error-info">{error}</p>}
              </ErrorMessage>
                </div>

                {/* <button className="btn btn-success" onClick = {(e)=> saveorUpdateDealer(e)}>Add</button> */}
                {/* <Button color="success" onClick = {(e)=> saveorUpdateDealer(e)}  endIcon={<Save />}></Button> */}
                <SubmitBtn />
                <Link to="/DL" className="btn btn-danger" style={{marginLeft: "75%"}}>{<CancelIcon/>}</Link>
            </form></Formik>
                </div>

                </div>
                
            </div>
            </div>
            </div>
  )
}
export default AddDealerComponent
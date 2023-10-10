import React, { useEffect, useState } from 'react'
import {Link, useParams, useNavigate} from 'react-router-dom'
import FarmerService from '../services/farmer.service'
import {Save,Cancel} from "@mui/icons-material";
import {Button,Stack, IconButton} from "@mui/material";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import CancelIcon from '@mui/icons-material/Cancel';

export const FarmerSignUp = () => {
  const [name,setName] = useState('')
  const [email,setEmail] = useState('')
  const [password,setPassword] = useState('')
  const{id} = useParams();
  const navigate = useNavigate();

  
  const saveorUpdateFarmer = (e)=> {
    e.preventDefault();

    const farmer = {name, email, password}
  
    if(id){
        FarmerService.updateFarmer(id,farmer).then((response)=>{
            navigate("/");
        }).catch(error =>{
            console.log(error);
        })
    }else{
        FarmerService.addFarmer(farmer).then((response)=>{
            console.log(response.data)
            navigate("/Farmerlogin");
           }).catch(error=>{
            console.log(error)
           })
          }
    }

  

  useEffect(()=>{
    FarmerService.getFarmerById(id).then((response)=>{
        setName(response.data.name)
        setEmail(response.data.email)
        setPassword(response.data.password)
    }).catch(error => {
        console.log(error)
    })
    },[])

    const title = () =>{
        if(id){
            return <h2 className="text-center">Update Farmer</h2>
        }
        else{
                return <h2 className="text-center">Farmer Registration</h2>
        }
        
    }
    function SubmitBtn() {
      if (
        name &&
        email &&
        password 
      )
        return (
          
          <Button variant="contained" color="success"  onClick={(o) => saveorUpdateFarmer(o)} endIcon={<Save />}></Button>
        );
      else
        return (
          
          <Button variant="contained" color="success" endIcon={<Save />} disabled></Button>
        );
    }





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
        onSubmit={(e) => FarmerSignUp(e)}
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
                    
                    <ErrorMessage name="password">
                {(error) => <p className="error-info">{error}</p>}
              </ErrorMessage>
                </div>

                
                <SubmitBtn />
                <Link to="/Farmerlogin" className="btn btn-danger" style={{marginLeft: "75%"}}>{<CancelIcon/>}</Link>
            </form></Formik>
                </div>

                </div>
                
            </div>
            </div>
            </div>
  )
}
export default FarmerSignUp
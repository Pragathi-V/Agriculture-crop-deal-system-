import React from "react";
import { useEffect, useState } from "react";
// import bootstrap from "bootstrap/dist/css/bootstrap.min.css";
import Modal from "react-bootstrap/Modal";
// import Button from "react-bootstrap/Button";
import cropservice from "../services/cropservice";
import { Link } from "react-router-dom";
import {Delete,Done,Save,Edit} from "@mui/icons-material";
import ModeEditIcon from '@mui/icons-material/ModeEdit';
import {Button,Stack, IconButton} from "@mui/material";
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import AddIcon from '@mui/icons-material/Add';

const Croplist1 = () => {
    function disableBackButton() 
{ window. history. forward(); } 
setTimeout(disableBackButton(), 0);
  const [crop, setCrop] = useState([])

  useEffect(() => {
      getAllCrop();

  }, [])

  const getAllCrop =() =>{
      cropservice.getAllCrop().then((response) => {
          setCrop(response.data)
          console.log(response.data);
      }).catch(error =>{
          console.log(error);
      })

  }

  const deleteCrop = (cropId) => {
      cropservice.deleteCrop(cropId).then((response) => {
          getAllCrop();

      }).catch(error => {
          console.log(error);
              })
  }

return (
    <div className="tam"><br></br>
  <div className = "container">
      <h2 className = "text-center">Crop List</h2>
      <Link to = "/Addcrop" className = "btn btn-primary mb-2"> Add Crops {<AddIcon/>} </Link>
      
      <table className = "table table-bordered table-striped">
          <thead style={{background:"#34532b",color:"white"}}>
              <th>CROP_ID</th>

              <th>NAME</th>

              <th>TYPE</th>

              <th>PRICE</th>

              <th>ACTIONS</th>

          </thead>
          <tbody>
              {
                  crop.map(
                      crop =>
                      <tr key = {crop.id} >
                          <td> {crop.id} </td>
                          <td> {crop.name} </td>
                          <td> {crop.type} </td>
                          <td> {crop.price} </td>
                          
                          <td>
                              <Link className = "btn btn-info" to = {`/edit-Crop/${crop.id}`} > {<ModeEditIcon/>}</Link>
                              {/* <button className = "btn btn-danger" onClick={() => deleteCrop(crop.id) }style = {{marginLeft:"20px"}}> Delete </button> */}
                              {/* <Button color="success" onClick ={() => /edit-Crop/${crop.id} style={{marginLeft:"20px"}} endIcon={<Edit />}></Button> */}
                              <Button color="success" onClick={() => deleteCrop(crop.id)} style={{marginLeft:"20px"}} endIcon={<Delete />}></Button>
                          </td>
                          

                      </tr>

                  )
              }
          </tbody>
      </table><Link to = "/Adminprofile" className = "btn btn-primary mb-2"> Back {<ArrowBackIcon/>} </Link>
  </div>
  </div>
)
}


export default Croplist1;
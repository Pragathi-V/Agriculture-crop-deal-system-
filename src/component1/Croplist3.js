import React from "react";
import { useEffect, useState } from "react";
// import bootstrap from "bootstrap/dist/css/bootstrap.min.css";
import Modal from "react-bootstrap/Modal";
// import Button from "react-bootstrap/Button";
import cropservice from "../services/cropservice";
// import { Link } from "react-router-dom";
import {Delete,Done,Save,Edit} from "@mui/icons-material";
import AuthService from "../services/auth-service";
import { Link, useHistory, useNavigate } from "react-router-dom";
import {Logout, LogoutRounded} from "@mui/icons-material";
import ModeEditIcon from '@mui/icons-material/ModeEdit';
import {Button,Stack, IconButton} from "@mui/material";
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import AddIcon from '@mui/icons-material/Add';
// const Croplist1 = () => {
//   const [crop, setCrops] = useState([]);

//   const init = () => {
//     cropservice
//       .getAll()
//       .then((response) => {
//         console.log("Printing crop data", response.data);
//         setCrops(response.data);
//       })
//       .catch((error) => {
//         console.log("Something went wrong", error);
//       });
//   };
//   const handleDelete = (id) => {
//     console.log("Printing id", id);
//     cropservice
//       .remove(id)
//       .then((response) => {
//         console.log("Crop details has been Deleted", response.data);
//         init();
//       })
//       .catch((error) => {
//         console.log("Something went wrong", error);
//       });
//   };

//   useEffect(() => {
//     init();
//   }, []);
//   const [show, setShow] = useState(false);

//   const handleClose = () => setShow(false);
//   const handleShow = () => setShow(true);
//   return (
//     <section className="tam">
//       <div >
//         <div className="container">
//           {}
//           <br></br>

//           <div>
//             <table className="table table-bordered table-transparent table-striped" style={{width:"70rem",fontSize:"17px", textAlign: "center", fontWeight:"bold"}}>
//               <thead className="thead-light">
//                 <tr>
//                   <th>Crop No</th>
//                   <th> Crop Type</th>
//                   <th> Crop Name</th>
//                   <th> Crop Price</th>
//                   <th> Actions </th>
//                 </tr>
//               </thead>
//               <tbody>
//               {crop.map((Crop) => (
//                   <tr key={Crop.id}>
//                     <td>{Crop.id}</td>
//                     <td>{Crop.type}</td>
//                     <td>{Crop.name}</td>
//                     <td>{Crop.price}</td>
//                     <td>
//                       <Link
//                         className="btn btn-warning"
//                         to={`/updateCrop/${Crop.id}`}
//                       >
//                         Update
//                       </Link>

//                       <button
//                         className="btn btn-danger ml-2"
//                         onClick={() => {
//                           handleDelete(Crop.id);
//                         }}>Delete
//                       </button>

//                       {/* <Modal show={show} onHide={handleClose}>
//                         <Modal.Header closeButton>
//                           <Modal.Title>Want to Delete?</Modal.Title>
//                         </Modal.Header>
//                         <Modal.Body>If yes , Click on Delete</Modal.Body>
//                         <Modal.Footer>
//                           <Button variant="secondary" onClick={handleClose}>
//                             Close
//                           </Button>
//                           <Button
//                             variant="danger"
//                             onClick={() => {
//                               handleDelete(crops.id);
//                             }}
//                           >
//                             <Link
//                               to="/Adminprofile"
//                               style={{ color: "white", textDecoration: "none" }}
//                             >
//                               Delete
//                             </Link>
//                           </Button>
//                         </Modal.Footer>
//                       </Modal> */}
//                     </td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>
//           </div>
//         </div>
//         <Link to="/adminprofile">
//           <button className="bckc">Back </button>
//         </Link>
//       </div>
//     </section>
//   );
// };

const Croplist3 = () => {
    const navigate = useNavigate();
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
  const logOut = () => {
    AuthService.logout();
    navigate("/");
  };
return (
    <div className="tam"><br></br>
    <h2 style={{
              fontFamily: "Hanalei Fill'",
              textAlign: "center",
              color: "black",
              fontWeight:"bolder"
            }}>Crop List
      <button
            style={{ marginLeft: "85%" }}
            className="btn btn-danger"
            onClick={() => {
              logOut();
            }}
          >
           {<LogoutRounded/>}
          </button>
      </h2>
  <div className = "container">
      
      <Link to = "/Addcrop1" className = "btn btn-primary mb-2"> Add Crops {<AddIcon/>} </Link>
      
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
                      <tr key = {crop.id}>
                          <td> {crop.id} </td>
                          <td> {crop.name} </td>
                          <td> {crop.type} </td>
                          <td> {crop.price} </td>
                          
                          <td>
                              <Link className = "btn btn-info" to = {`/croplist3/edit/${crop.id}`} > {<ModeEditIcon/>}</Link>
                              {/* <button className = "btn btn-danger" onClick={() => deleteCrop(crop.id) }style = {{marginLeft:"20px"}}> Delete </button> */}
                              {/* <Button color="success" onClick ={() => /edit-Crop/${crop.id} style={{marginLeft:"20px"}} endIcon={<Edit />}></Button> */}
                              <Button color="success" onClick={() => deleteCrop(crop.id)} style={{marginLeft:"20px"}} endIcon={<Delete />}></Button>
                          </td>
                          

                      </tr>

                  )
              }
          </tbody>
      </table>
      <Link to = "/Fprofile" className = "btn btn-primary mb-2"> Back {<ArrowBackIcon/>}</Link>
      
  </div>
  
  </div>
)
}


export default Croplist3;
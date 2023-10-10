import React, {useState, useEffect} from 'react'
import  {useNavigate, useParams } from 'react-router-dom';
import { Link } from 'react-router-dom'
import CropService from '../services/cropservice'
import {Delete,Done,Save} from "@mui/icons-material";
import {Button,Stack, IconButton} from "@mui/material";
import CancelIcon from '@mui/icons-material/Cancel';

const Addcrop1 = () => {
  function disableBackButton() 
  { window. history. forward(); } 
  setTimeout(disableBackButton(), 0);
  const [type, settype] = useState('')
  const [name, setname] = useState('')
  const [price, setprice] = useState('')
  //const [farmerid, setfarmerid] = useState('')
  const types = ['Vegetable', 'Fruit', 'Flower','Cereals']
  const navigate = useNavigate();
  const {id} = useParams();

  const addCrop = (e) => {
    e.preventDefault();

    const crop = {type, name, price}

    if(id){
            CropService.updateCrop(id, crop).then((response) => {
              navigate("/croplist3");
      
            }).catch(error => {
              console.log(error);
            })
      
        }else{
            CropService.addCrop(crop).then((response)=>{
                console.log(response.data);navigate("/croplist3")
               }).catch(error=>{
                console.log(error)
               })
              }
        }

  useEffect(() => {
    CropService.getCropById(id).then((response) => {
      settype(response.data.type)
      setname(response.data.name)
      setprice(response.data.price)
      // setfarmerid(response.data.farmerid)

    }).catch(error => {
      console.log(error)
    })
   
  }, [])
  
  function SubmitBtn() {
        if (
          type &&
          name &&
          price 
        )
          return (
            // <button onClick={(o) => addCrop(o)} className="btn btn-success">
            //   Save
            // </button>
            <Button variant="contained" color="success" onClick={(o) => addCrop(o)}  endIcon={<Save />}></Button>
          );
        else
          return (
            // <button className="btn btn-success" disabled>
            //   Save
            // </button>
            <Button variant="contained" color="success"  endIcon={<Save />} disabled></Button>
          );
      }


  const title = () => {
    if(id) {
      return <h2 className = "text-center"> Update Crop</h2>
    }else{
      return <h2 className = "text-center"> Add Crop</h2>

    }
  }
  const preventPasteNegative = (e) => {
    const clipboardData = e.clipboardData || window.clipboardData;
    const pastedData = parseFloat(clipboardData.getData('text'));

    if (pastedData < 0) {
        e.preventDefault();
    }
};
const preventMinus = (e) => {
  if (e.code === 'Minus') {
      e.preventDefault();
  }
};

  return (
    <div>
      <br></br>
      <div className = "container">
        <div className = "row">
          <div className = "card col-md-6 offset-md-3 offset-md-3">
            {
              title()
            }
              <div className="card-body">
                <form>
                  <div className = "form-group mb-2">
                    <label className = "form-label">Crop Type :</label>
                    <select
                      type = "text"
                      className = "form-control"
                      name = "type"
                      //value = {type}
                      onChange = {(e) => settype(e.target.value)}
                      placeholder = "select crop type">
                        {types.map((type, index) => (
                        <option value={type} key={index}>{type}</option>
                      ))}
                    </select>
                      
                  
                </div>
                <div className = "form-group mb-2">
                <label className = "form-label">Crop Name :</label>
                  <input
                      type = "text"
                      className = "form-control"
                      name = "name"
                      value = {name}
                      onChange = {(e) => setname(e.target.value)}
                      placeholder = "Enter crop name"
                      //required
                  >
                  </input>
                </div>
                
                <div className = "form-group mb-2">
                <label className = "form-label">Crop Price :</label>
                  <input
                      type = "number"
                      className = "form-control"
                      name = "price"
                      value = {price}
                      min="0"
                      onPaste={preventPasteNegative}
                      onKeyPress={preventMinus}
                      onChange = {(e) => setprice(e.target.value)}
                      placeholder = "Enter crop price"
                      //required
                  >
                  </input>
                </div>
                <div><br></br>
           
         </div>
         <SubmitBtn />
                <Link to = "/Croplist3" className = "btn btn-danger" style={{marginLeft: "75%"}}> {<CancelIcon/>} </Link>

              </form>
              </div>
              </div>
              </div>
            </div>
          </div>
        
  )
}
 
export default Addcrop1
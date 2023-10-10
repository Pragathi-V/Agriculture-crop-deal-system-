import React from "react";
import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import findByName from "../services/cropservice";

let p = localStorage.getItem("n");
console.log(p);

const CropDetails = () => {

  const [search, setSearch] = useState([]);
  const [crop, setCrop] = useState("");

 
  
    findByName
    .findByName(p)
    .then((response) => {
      setSearch(response.data);
      
    });
    
  

  return (
    <div className="tam">
      <h3
        style={{
          color: "black",
          fontWeight: "bolder",
          fontSize: "40px",
          textAlign: "center",
        }}
      >
        List of Crops
      </h3>

      <div className="tlist" >
       
        <table className="table table-bordered table-transparent table-striped">
          <thead className="thead-light">
          <tr style={{background:"#34532b",color:"white"}}>
              <th> Crop ID</th>
              <th> Crop Type</th>
              <th> Crop Name</th>
              <th> Crop Price</th>
            </tr>
          </thead>
          <tbody>
          {
            <tr >
              <td>{search.id}</td>
              <td>{search.type}</td>
              <td>{search.name}</td>
              <td>{search.price}</td>
            </tr>
          }
          </tbody>
        </table>
      </div>
      <Link to="/">
          <button className="bckc">Back </button>
        </Link>
    </div>
  );

};

export default CropDetails;

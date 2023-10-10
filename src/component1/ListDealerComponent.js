import React, {useEffect, useState} from 'react'
import DealerService from '../services/DealerService'
import { Link } from 'react-router-dom'
import {Delete,Done,Save} from "@mui/icons-material";
import ModeEditIcon from '@mui/icons-material/ModeEdit';
import {Button,Stack, IconButton} from "@mui/material";
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
const ListDealerComponent = () => {
    const[dealer, setDealer] = useState([])
    useEffect(() => {
       getAllDealer();
    }, [])

    const getAllDealer =() =>{
        DealerService.getAllDealer().then((response)=> {
            setDealer(response.data)
            console.log(response.data);
        }).catch(error=>{
            console.log(error);
        })
    }

    const deleteDealer=(dealerId)=>{
        DealerService.deleteDealer(dealerId).then((response)=>{
            getAllDealer();
        }).catch(error=>{
            console.log(error);
        })
    }
  return (
    <div className='tam'>
    <div className="container"><br></br>
        <h2 className = "text-center">Dealer List</h2>
        {/* <Link to = "/add-dealer" className = "btn btn-primary mb-2"style={{marginTop:"30px"}}> Add Dealer </Link>  */}
        <table className = "table table-bordered table-striped">
<thead style={{background:"#34532b",color:"white"}}>
    <th>DEALER_ID</th>
    <th>NAME</th>
    <th>EMAIL</th>
    <th>ACTIONS</th>
</thead>
<tbody>
    {
        dealer.map(
            dealer => 
            <tr key = {dealer.id} >
                <td>{dealer.id}</td>
                <td>{dealer.name}</td>
                <td>{dealer.email}</td>
                <td>
                    {/* <Link className="btn btn-info" to={`/edit-dealer/${dealer.id}`}>{<ModeEditIcon/>}</Link> */}
                        <Button variant="contained" color="error" onClick={() => deleteDealer(dealer.id)} style={{marginLeft:"7px"}} endIcon={<Delete />}></Button>
                    
                </td>
            </tr>
        )
    }
</tbody>
        </table><Link to = "/Adminprofile" className = "btn btn-primary mb-2"> Back{<ArrowBackIcon/>} </Link>
    </div></div>
  )
}
export default ListDealerComponent;
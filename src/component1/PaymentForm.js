import { CardElement, useElements, useStripe } from "@stripe/react-stripe-js"
import axios from "axios"
import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import { useNavigate, useParams } from 'react-router-dom';
import CropService from '../services/cropservice'


export default function PaymentForm() {
  const [success, setSuccess] = useState(false)
  const stripe = useStripe()
  const elements = useElements()
  const [isLoading, setIsLoading] = useState(false)

  const [type, settype] = useState('')
  const [name, setname] = useState('')
  const [price, setprice] = useState('')

  const navigate = useNavigate();
  const { id } = useParams();
  const current = new Date();
  const date = `${current.getDate()}/${current.getMonth()+1}/${current.getFullYear()} ${current.getHours() }:${current.getMinutes() }:${current.getSeconds()}:${current.getMilliseconds()}`;

  const addCrop = (e) => {
    e.preventDefault();

    const crop = { type, name, price }

    if (id) {
      CropService.updateCrop(id, crop).then((response) => {
        navigate("/croplist3");

      }).catch(error => {
        console.log(error);
      })

    }
  }

  useEffect(() => {
    CropService.getCropById(id).then((response) => {
      settype(response.data.type)
      setname(response.data.name)
      setprice(response.data.price)


    }).catch(error => {
      console.log(error)
    })

  }, [])

  

  const handleSubmit = async (e) => {
    e.preventDefault()
    const { error, paymentMethod } = await stripe.createPaymentMethod({
      type: "card",
      card: elements.getElement(CardElement)
    })


    if (!error) {
      try {
        setIsLoading(true)
        const { id } = paymentMethod
        const response = await axios.post("http://localhost:4000/payment", {
          amount: 1000,
          id
        })


        if (response.data.success) {
          console.log("Successful payment")
          setIsLoading(false)
          setSuccess(true)
        }

      } catch (error) {
        console.log("Error", error)
      }
    } else {
      console.log(error.message)
    }
  }
  if (isLoading) {
    return (
      <div className="container"><div className="loader-container">

        <div className="spinner"></div>
      </div></div>


    )
  }
  return (

    <div className="container m-150 text-center">



      {!success ?
        <form onSubmit={handleSubmit}>
          


          <fieldset className="">
            <div className="card-body" style={{
              width: "500px",
              // height:"270px",
              boxShadow: '1px 2px 9px #F4AAB9',
              // marginLeft: "28%",
              // marginTop: "10px"
              margin:"0 auto",
              marginTop: "50px"

            }}>

              <h2
                style={{
                  fontFamily: "Hanalei Fill'",
                  textAlign: "center",
                  color: "black",
                  fontWeight: "bolder"
                }}
              >
                Order Details!
              </h2>

              <div className="form-group mb-2">
                <label className="form-label" style={{
                  fontWeight: "bolder"
                }}>Crop Name :

                  <input
                    style={{
                      width: "100px",
                      boxShadow: '1px 2px 9px #F4AAB9',
                      backgroundColor: "#34532b",
                      color: "white"
                    }}
                    type="text"
                    className="form-control"
                    name="name"
                    value={name}
                    onChange={(e) => setname(e.target.value)}
                    required={true} readOnly={true}
                  
                  >
                  </input>
                </label>

              </div>

              <div className="form-group mb-2">
                <label className="form-label" style={{
                  fontWeight: "bolder"
                }}>Crop Price :
                  <input
                    style={{
                      width: "100px",
                      boxShadow: '1px 2px 9px #F4AAB9',
                      backgroundColor: "#34532b",
                      color: "white"
                    }}
                    //type = "number"
                    className="form-control"
                    name="price"
                    value={price}
                    onChange={(e) => setprice(e.target.value)}
                    required={true} readOnly={true}
              
                  >
                  </input>
                </label>

              </div>
              <h6 className="text-center" style={{
                fontFamily: "Hanalei Fill'",
                textAlign: "center",
                color: "black",
                fontWeight: "bolder"
              }}>Enter Your Card Details</h6>
              <CardElement className="card-header" />
            </div>
          </fieldset>
          <button className=" text-center btn btn-success" style={{ width: "10%", margin: "5rem" }} >Pay </button>
          <Link to="/DProfile" className=" text-center btn btn-danger" style={{ width: "10%", margin: "5rem" }} >Cancel </Link>
        </form>
        :
        <div>
          <img className="img"
            src="https://thumbs.dreamstime.com/b/confirmation-approval-order-operation-payment-successful-completion-girl-confirms-business-success-man-hand-shows-class-239104068.jpg"
            style={{ width: "400px", margin: "0 rem" }}
            alt="" />
          <h2>Yayy! Your order for {name} at Rs. {price} on {date} IST is Successful</h2>
          <Link to="/DProfile" className="btn btn-dark"> Back to Browse</Link>
        </div>
        
      }

    </div>
  )
}

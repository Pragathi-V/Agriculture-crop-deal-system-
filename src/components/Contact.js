import React, { useState } from "react";
import emailjs from '@emailjs/browser';

const Result =() => {
  return(
    <p>Your message has been sent successfully. We will get back to you shortly. Thank you for using our services!</p>
  );
};
function ContactComponent(props) {
  const [result, showResult] = useState(false);


  const sendEmail = (e) => {
    e.preventDefault();

    emailjs.sendForm('service_muxl2ok', 'template_z55kk7h', e.target, 'BgcmAmC6PFHUUVjkw')
      .then((result) => {
          console.log(result.text);
      }, 
      (error) => {
          console.log(error.text);
      });
      e.target.reset();
      showResult(true);
  };
  

  return (
    <div className="tam">
      
      <form
        id="body"
        action ="" onSubmit={sendEmail}>
      
       <marquee> <p className="con" style={{color:"black",fontSize:"27px" }}><b>Contact Us at <i style={{color:"cadetblue"}}> team7@gmail.com</i></b></p></marquee> 
        <br></br>
        <br></br>
        <br></br>
        <div className="mb-3 pt-0">
          <label className="lab1" style={{fontFamily:"serif", fontWeight:"bolder", fontSize:"25px", alignItems:"center"}}>Enter your name: </label>
          <input
            id="ip1"
            type="text"
            placeholder="Your name"
            name="name"
            className="px-3 py-3 placeholder-gray-400 text-gray-600 relative bg-white bg-white rounded text-sm border-0 shadow outline-none focus:outline-none focus:ring w-full"
            required
          />
        </div>
        <div className="mb-3 pt-0">
          <label className="lab2" style={{fontFamily:"serif", fontWeight:"bolder", fontSize:"25px" }}>Enter your email: </label>
          <input
            id="ip2"
            type="email"
            placeholder="Email"
            name="email"
            className="px-3 py-3 placeholder-gray-400 text-gray-600 relative bg-white bg-white rounded text-sm border-0 shadow outline-none focus:outline-none focus:ring w-full"
            required
          />
        </div>
        <div className="mb-3 pt-0">
          <label className="lab3" style={{fontFamily:"serif", fontWeight:"bolder", fontSize:"25px" }}>Enter message/feedback: </label>
          <textarea
            placeholder="Your message"
            id="ip3"
            name="message"
            className="px-3 py-3 placeholder-gray-400 text-gray-600 relative bg-white bg-white rounded text-sm border-0 shadow outline-none focus:outline-none focus:ring w-full"
            required
          />
        </div>
        <div className="mb-3 pt-0">
          <button
            id="btnc"
            className=" font-bold uppercase text-sm px-6 py-3 rounded focus:outline-none mr-1 mb-1"
            type="submit"
            style={{fontFamily:"san-serif", fontWeight:"bolder", fontSize:"20px" }}
          >
           
            Send
          </button>
          <div className = "row">
            {result ? <Result/> : null}
          </div>
        </div>
      </form>
    </div>
  );
};

export default ContactComponent;
import React from 'react'
import { Link } from "react-router-dom";
const Error = () => {
  return (
    <div
      style={{
        height: '70vh',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center'
      }}
    >
      <h3>Looks like the page you were looking for does not exist
      <Link to = "/"> Go Back </Link></h3>
    </div>
  )
}

export default Error

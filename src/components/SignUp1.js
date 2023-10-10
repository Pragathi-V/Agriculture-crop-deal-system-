import React from "react";
import { useState, useEffect } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import userservice from "../services/farmer.service";
const SignUp1 = () => {
   
  const [username, setName] = useState("");
  const [emailId, setEmail] = useState("");

  const [password, setPass] = useState("");
  const [age, setAge] = useState("");

  const [gender, setGender] = useState("");
  const [ph_no, setPhone] = useState("");
  const [roles, setRoles] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();

  const saveUser = (e) => {
    e.preventDefault();

    const user = { username, emailId, password, age, gender, ph_no, roles, id };

    if (id) {
      //update
      userservice
        .update(user)
        .then((response) => {
          console.log("user data updated successfully", response.data);
          navigate("/profile");
        //   setUser(response.data)
        })
        .catch((error) => {
          console.log("Something went wrong", error);
        });
    } else {
      // create
      userservice
        .create(user)
        .then((response) => {
          console.log("user added successfully", response.data);
        })
        .catch((error) => {
          console.log("Something went wrong", error);
        });
    }
  };
  useEffect(() => {
    if (id) {
      userservice
        .getUserId(id)
        .then((users) => {
          setName(users.data.username);
          setEmail(users.data.emailId);
          setPass(users.data.password);
          setAge(users.data.age);
          setGender(users.data.gender);
          setPhone(users.data.ph_no);
          setRoles(users.data.roles);
        })
        .catch((error) => {
          console.log("Something went wrong", error);
        });
    }
  }, []);
  return (
    <div style={{ backgroundColor: "#ddccff" }}>
      <Form id="registrationform">
        <h5
          style={{
            textAlign: "center",
            // textShadow: "2px 2px black",
            color: "black",
          }}
        >
         Update User Details
        </h5>

        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label style={{ color: "#000066" }}>Name</Form.Label>
          <Form.Control
            type="text"
            placeholder="Name"
            value={username}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label style={{ color: "#000066" }}>Email address</Form.Label>
          <Form.Control
            type="email"
            pattern="/^[a-zA-Z0-9.!#$%&’+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)$/"
            placeholder="Enter email"
            value={emailId}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
          <Form.Text className="text" style={{ color: "coral" }}>
            We'll never share your email with anyone else.
          </Form.Text>
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label style={{ color: "#000066" }}>Password</Form.Label>
          <Form.Control
            required
            type="password"
            pattern="(?=.\d)(?=.[a-z])(?=.*[A-Z]).{8,}"
            placeholder="Password"
            value={password}
            onChange={(e) => setPass(e.target.value)}
          />
          <Form.Text className="text" style={{ color: "coral" }}>
            Password should contains atleast 8 characters
          </Form.Text>
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label style={{ color: "#000066" }}>Age</Form.Label>
          <Form.Control
            required
            type="number"
            placeholder="Age"
            value={age}
            onChange={(e) => setAge(e.target.value)}
          />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label style={{ color: "#000066" }}>Gender</Form.Label>
          <Form.Control
            required
            type="text"
            placeholder="Gender"
            value={gender}
            onChange={(e) => setGender(e.target.value)}
          />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label style={{ color: "#000066" }}>Mobile No.</Form.Label>
          <Form.Control
            required
            type="number"
            placeholder="Mobile No."
            value={ph_no}
            onChange={(e) => setPhone(e.target.value)}
          />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label style={{ color: "#000066" }}>
            Roles(farmer/dealer)
          </Form.Label>
          <Form.Control
            required
            type="text"
            placeholder="user/admin"
            value={roles}
            onChange={(e) => setRoles(e.target.value)}
          />
        </Form.Group>
        {/* <Form.Group className="mb-3" controlId="formBasicCheckbox">
          <Form.Check type="checkbox" label="Check me out" />
        </Form.Group> */}
        {/* <Button
          onClick={(o) => saveUser(o)}
          variant=" #2c7f86;"
          type="submit"
          id="submit"
        >
          Submit
        </Button> */}

        <Button variant="primary" onClick={(o) => saveUser(o)}>
          Submit 
        </Button>
      </Form>
    </div>
  );
};

export default SignUp1;
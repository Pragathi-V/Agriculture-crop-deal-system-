import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import Showcase from "./components/Showcase";
import Footer from "./components/Footer";
import Farmerlogin from "./components/Farmerlogin";
import FarmerSignUp from "./components/FarmerSignUp";
import Error from "./components/Error";
import Contact from "./components/Contact";
import Croplist from "./component1/Croplist";
import Farmerlist from "./component1/FarmerList";
import DProfile from "./components/DProfile";
import FProfile from "./components/FProfile";
import Dealerlogin from "./components/Dealerlogin";
import ListDealerComponent from './component1/ListDealerComponent';
import AddDealerComponent from './component1/AddDealerComponent';
import CropDetails from "./component1/CropDetails";
import Croplist1 from "./component1/Croplist1";
import Addcrop from "./component1/Addcrop";
import Addcrop1 from "./component1/Addcrop1";
import Adminprofile from "./components/Adminprofile";
import Adminlogin from "./components/Adminlogin";
import SignUp1 from "./components/SignUp1";
import { Logout } from "./components/Logout";
import DL from "./components/DL";
import Croplist3 from "./component1/Croplist3";
import AP from "./components/AP";
import StripeContainer from "./component1/StripeContainer";
function App() {
  return (
    
    <BrowserRouter>
      <Header />

      

      <Routes>
        
        <Route path="/" element={<Showcase />} />
        <Route path="/Farmersignup" element={<FarmerSignUp />} />
        <Route path="/Farmerlogin" element={<Farmerlogin />} />
        <Route path="/Dealerlogin" element={<Dealerlogin />} />
        <Route path="/Croplist" element={<Croplist />} />
        <Route path="/Contact" element={<Contact />} />
        <Route path="/FarmerList" element={<Farmerlist />} />
        <Route path="/Dprofile" element={<DProfile />} />
        <Route path="/Fprofile" element={<FProfile />} />
        <Route path="/CropDetails" element={<CropDetails />} />
        <Route path="/Addcrop" element={<Addcrop />} />
        <Route path="/adminprofile" element={<Adminprofile />} />
        <Route path="/croplist1" element={<Croplist1 />} />
        <Route path="/croplist/edit/:id" element={<Addcrop />} />
        <Route path="/Adminlogin" element={<Adminlogin />} />
        <Route path="/Addcrop1" element={<Addcrop1 />} />
        <Route path="/Logout" element={<Logout />} />
        <Route path="/croplist3" element={<Croplist3 />} />
        <Route path="/user/edit/:id" element={<SignUp1/>} />
        <Route path="*" element={<Error />} />
        <Route path = "/edit-Crop/:id" element = {<Addcrop/>} />
        <Route path="/listdealer" element={<ListDealerComponent />} />
        <Route path="/add-dealer" element={<AddDealerComponent />} />
        <Route path="/edit-dealer/:id" element={<AddDealerComponent />} />
        <Route path="/croplist3/edit/:id" element={<Addcrop1 />} />
        <Route path="/DL" element={<DL />} />
        <Route path="/AP" element={<AP />} />
        <Route path="/payment/:id" element={<StripeContainer />} />
      </Routes>
      <Footer />
    </BrowserRouter>
    
  );
}

export default App;
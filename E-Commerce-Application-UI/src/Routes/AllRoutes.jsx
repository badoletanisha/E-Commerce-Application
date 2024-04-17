import React from "react";
import { Route, Routes } from "react-router-dom";
import App from "../App";
import AddAddress from "../private/Common/addAddress";
import EditProfile from "../private/Common/EditProfile"
import Cart from "../private/Customer/Cart";
import Explore from "../private/Customer/Explore";
import Wishlist from "../private/Customer/Wishlist";
import AddProduct from "../private/Seller/AddProduct";
import SellerDashboard from "../private/Seller/SellerDashboard";
import Home from "../Public/Home";
import Login from "../Public/Login";
import Register from "../Public/Register";


const AllRoutes = () => {
  const user = {
    userId: "1",
    userName: "tanisha",
    role: "CUSTOMER",
    authenticated: false,
    accessExpiration: "3600",
    refreshExpiration: "1296000",
  };
  const { role, authenticated } = user;
  let routes = [];
  if (authenticated) {
    role == "SELLER"
      ? routes.push(
          <Route
            key={"sellerdashboard"}
            path="/sellerdashboard"
            element={<SellerDashboard />}
          />,
          <Route
            key={"addproduct"}
            path="/addproduct"
            element={<AddProduct />}
          />
        )
      : role == "CUSTOMER" &&
        routes.push(
          <Route key={"explore"} path="/explore" element={<Explore />} />,
          <Route key={"cart"} path="/cart" element={<Cart />} />,
          <Route key={"wishlist"} path="/wishlist" element={<Wishlist />} />,
          <Route key={"register"} path="/register-customer" element={<Register role={"CUSTOMER"} />} />
          
        );
    routes.push(
      <Route key={"home"} path="/" element={<Home />} />,
      <Route key={"addaddress"} path="/addaddress" element={<AddAddress />} />,
      <Route
        key={"editprofile"}
        path="/editprofile"
        element={<EditProfile />}
      />
    );
  } else {
    role === "CUSTOMER" &&
      routes.push(
        <Route key={"home"} path="/" element={<Home />} />,
        <Route key={"login"} path="/login" element={<Login />} />,
        <Route key={"explore"} path="/explore" element={<Explore />} />,
        <Route key={"register"} path="/register" element={<Register />} />,
        <Route key={"register"} path="/register-seller" element={<Register role={"SELLER"}/>} />,
        
      );
  }
  return (
    <Routes>
      <Route path="/" element={<App />}>
        {routes}
      </Route>
      ;
    </Routes>
  );
};

export default AllRoutes;

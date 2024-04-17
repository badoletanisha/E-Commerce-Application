import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter } from "react-router-dom";
import "./index.css";

import AllRoutes from "./Routes/AllRoutes.jsx";


ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <BrowserRouter>   
        <AllRoutes/>     
    </BrowserRouter>
  </React.StrictMode>
);



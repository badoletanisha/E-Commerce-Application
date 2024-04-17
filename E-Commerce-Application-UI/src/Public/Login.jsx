import React from "react";
import img1 from "../images/flipkart-logo.png";
import { useState } from "react";
const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errors, setErrors] = useState({});

  const validateEmail = (value) => {
    if (!value) {
      return "Email is required";
    }
    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
      errors.email = "Invalid email address";
    }
    if (!email.endsWith("@gmail.com")) {
      errors.email = "Email should end with @gmail.com";
    }

    return "";
  };

  const validatePassword = (value) => {
    if (!value) {
      return "Password is required";
    }
    if (
      !/(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}/.test(value)
    ) {
      return "Password must contain at least one alphabet, one number, and one special character";
    }
    return "";
  };

  const handleEmailChange = (e) => {
    const value = e.target.value;
    setEmail(value);
    setErrors((prevErrors) => ({
      ...prevErrors,
      email: validateEmail(value),
    }));
  };

  const handlePasswordChange = (e) => {
    const value = e.target.value;
    setPassword(value);
    setErrors((prevErrors) => ({
      ...prevErrors,
      password: validatePassword(value),
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validateEmail(email) === "" && validatePassword(password) === "") {
      // Submit form
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="flex justify-center items-center mt-32">
        <div id="loginbody" className="w-[800px] h-[400px]  flex">
          <div
            id="loginsec1"
            className="w-[400px] h-[400px]   flex flex-col justify-center   items-center bg-blue-700 "
          >
            <div>
              <img src={img1} alt="" height="150px" width="150px" />
            </div>
            <div id="logoandname">
              <p className="italic text-white text-2xl">Flipkart</p>
            </div>
          </div>
          <div
            id="loginsec2"
            className="w-[400px] bg-gray-100 flex justify-around items-center h-[400px] "
          >
            <div
              id="logsubsec"
              className=" h-[300px] w-[300px] flex flex-col justify-around "
            >
              <div id="loginpara" className=" text-center text-lg font-bold">
                <p>LogIn</p>
              </div>
              <div id="textbox">
                <p className="font-mono">Enter the Username</p>
                <input
                  type="text"
                  placeholder="example@gmail.com"
                  className="w-full rounded-md  border-blue-300 border-2 focus:outline-blue-500 sm:text-sm h-10 placeholder:italic placeholder:text-gray-400 block pr-3 shadow-sm font-mono text-2"
                  value={email}
                  onChange={handleEmailChange}
                />
                {errors.email && (
                  <p className="text-red-500 text-xs italic">{errors.email}</p>
                )}
                <p className="mt-2 font-mono">Enter the Password</p>
                <input
                  type="text"
                  className="w-full rounded-md  border-blue-300 border-2 focus:outline-blue-500 sm:text-sm h-10 placeholder:italic placeholder:text-gray-400 block pr-3 shadow-sm"
                  placeholder="***********"
                  value={password}
                  onChange={handlePasswordChange}
                />
                {errors.password && (
                  <p className="text-red-500 text-xs italic">
                    {errors.password}
                  </p>
                )}
              </div>
              <div className="flex justify-around items-center">
                <button className="bg-blue-600 hover:bg-blue-800 font-mono rounded-full w-[70px] text-white text-xl">
                  Login
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </form>
  );
};

export default Login;

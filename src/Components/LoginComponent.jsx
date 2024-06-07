import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { loginAPICall, saveLoggedInUser, storeToken } from '../service/AuthService';

const LoginComponent = () => {
    const [username,setUsername]=useState("");
    const [password,setPassword]=useState("");
    const navigate=useNavigate();
async function handleLoginForm(e){
    e.preventDefault();
    try{
    console.log(username);
    console.log(password);
    const response=await loginAPICall(username,password);
    const token="Bearer " +  response.data.accessToken;
    const role=response.data.role;
    storeToken(token);
    saveLoggedInUser(username,role);
    navigate("/employees")
}catch(error){
    console.error(error);
}
};
  return (

<div className="container">
    <br /> <br />
     <div className="row">
        <div className="card-col-md-6 offser-md-3">
        <div className="card">
        <div className="card-header">
            <h2 className="text-center">Login Form</h2>
            </div>
            <div className="card-header">
            <form>
              <div className="row mb-3">
                <label className="col-md-3 control-label">Username</label>
                <div className="col-md-9">
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter UserName"
                  name="username"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                />
              </div>
              </div>
              <div className="row mb-3">
                <label className="col-md-3 control-label">Password</label>
                <div className="col-md-9">
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter Password"
                  name="password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                />
              </div>
              </div>
              <div className="form-group mb-3">
                <button 
                className="btn btn-primary"
                    onClick={(e)=>handleLoginForm(e)} >Submit</button>
              </div>
              </form>
              </div>
              </div>
              </div>  
        </div>
        </div>
  )
}

export default LoginComponent
 
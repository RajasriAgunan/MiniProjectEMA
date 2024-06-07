import React, { useState } from 'react'
import { registerAPICall } from '../service/AuthService';

const RegisterComponent = () => {
    const [username,setUsername]=useState("");
    const [name,setName]=useState("");
    const [email,setEmail]=useState("");
    const [password,setPassword]=useState("");
    
  async function handleRegistrationForm(e){
    e.preventDefault();
    const register={username:username,name:name,email:email,password:password};
    try{
     const response= await registerAPICall(register);
     console.log(response.data);
     alert('Registration successful');

    }catch (error){
        console.error(error);
    }

   }

  return (
  
<div className="container">
    <br /> <br /> 
     <div className="row">
        <div className="card-col-md-6 offser-md-3">
        <div className="card">
        <div className="card-header">
            <h2 className="text-center">Register Form</h2>
            </div>
            <div className="card-header">
            <form>
            <div className="row mb-3">
                <label className="col-md-3 control-label">Username</label>
                <div className="col-md-9">
                <input
                  type="text"
                  name="username"
                  className="form-control"
                  placeholder="Enter UserName"
                  value={username}
                  onChange={(e)=>setUsername(e.target.value)}
               />
              </div>
              </div>

              <div className="row mb-3">
                <label className="col-md-3 control-label">Name</label>
                <div className="col-md-9">
                <input
                  type="text"
                  name="name"
                  className="form-control"
                  placeholder="Enter Name"
                  value={name}
                  onChange={(e)=>setName(e.target.value)}

                  
                />
              </div>
              </div>
              
              <div className="row mb-3">
                <label className="col-md-3 control-label">Email</label>
                <div className="col-md-9">
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter Email"
                  name="email"
                  value={email}
                  onChange={(e)=>setEmail(e.target.value)}

                />
              </div>
              </div>
              
              <div className="row mb-3">
                <label className="col-md-3 control-label">Password</label>
                <div className="col-md-9">
                <input
                  type="text"
                  name="password"
                  className="form-control" 
                  placeholder="Enter Password"
                  value={password}
                  onChange={(e)=>setPassword(e.target.value)}

                />
              </div>
              </div>

              <div className="form-group mb-3">
                <button 
                className="btn btn-primary"
                    onClick={(e)=>handleRegistrationForm(e)} >Submit</button>
              </div>
              </form>
              </div>
              </div>
              </div>  
        </div>
        </div>
  )
}

export default RegisterComponent

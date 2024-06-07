import React from 'react'
import {NavLink, useNavigate} from "react-router-dom";
import { isUserLoggedIn, logout } from '../service/AuthService';


const Headercomponent = () => {
  const navigate=useNavigate();
  const isAuth=isUserLoggedIn();
  
  function handleLogout(){
    logout();
    navigate("/login");
  }
    
   return (
    <div>
      <header>
        <nav className="navbar navbar-expand-md navbar-dark-bg-dark navbar bg-dark border-bottom border-body" data-bs-theme="dark">
            <div>
                <a href="http://localhost:3000" className="navbar-brand">Employee Management System</a>
            </div>
             <div className="collapse navbar-collapse">
              <ul className="navbar-nav">
                {isAuth && ( <li className="nav-item"> 
                <NavLink to="/employees" className="nav-link">Employees</NavLink>
                </li>)}
                {!isAuth && (  <li className="nav-item"> 
                <NavLink to="/register" className="nav-link">Register</NavLink>
                </li>)}
              {!isAuth && (<li className="nav-item"> 
                <NavLink to="/login" className="nav-link">Login</NavLink>
                </li>)}
              {isAuth && (
                <li className="nav-item"> 
                <NavLink to="/logout" className="nav-link" onClick={handleLogout}>Logout</NavLink>
                </li>)}
              </ul>
              </div> 
        </nav>
      </header>
    </div>
  );
}

export default Headercomponent

import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Headercomponent from './Components/Headercomponent'
import FooterComponent from './Components/FooterComponent'
import ListEmployeeDetails from './Components/ListEmployeeDetails'
import EmployeeDetails from './Components/EmployeeDetails'
import LoginComponent from './Components/LoginComponent'
import RegisterComponent from './Components/RegisterComponent'
import ViewEmployee from './Components/ViewEmployee'

function App() {

  return (
    <>
      <BrowserRouter>
      <Headercomponent />
      
       <Routes>
          <Route path="/" element={<LoginComponent />}></Route>
          <Route path="/employees" element={<ListEmployeeDetails />}></Route>
         <Route path="/add-employee" element={<EmployeeDetails />}></Route>
          <Route path="/update-employee/:id" element={<EmployeeDetails />}></Route>
          <Route path="/view-employee/:id" element={<ViewEmployee />}></Route>
          <Route path="/login" element={<LoginComponent />}></Route>
          <Route path="/register" element={<RegisterComponent />}></Route>

        </Routes>   
    
      <FooterComponent />
      </BrowserRouter>
    </>
  );
}

export default App;

import React, { useEffect, useState } from 'react'
import { getEmployee, view } from '../service/EmployeeService';
import { useNavigate, useParams } from 'react-router-dom';

const ViewEmployee = () => {
    const { id } = useParams();
  const [firstname, setFirstname] = useState("");
  const [lastname, setLastname] = useState("");
  const [email, setEmail] = useState("");
  const navigate = useNavigate();
 
 
  const back=async (e) => {
  
    e.preventDefault();
    const employee = { firstname: firstname, lastname: lastname, email: email };
    console.log(employee);

    try {
       await view(id);
        navigate("/employees");
      
    } catch(error) {
      console.error(error);
    }
  };


      useEffect(() => {
        const fetchData = async () => {
          try {
            if (id) {
              const response = await getEmployee(id);
              console.log(response.data);
              setFirstname(response.data.firstname);
              setLastname(response.data.lastname);
              setEmail(response.data.email);
            }
          } catch (error) {
            console.error(error);
          }
        };
        fetchData();
      }, [id]);
  return (

    <div className="container">
    <div className="row">
      <div className="card-col-md-6 offser-md-3">
        <div className="card-body">
          <form>
            <div className="form-group mb-2">
              <label className="form-label">Firstname</label>
              <span>{firstname}</span>
            </div>
            <div className="form-group mb-2">
              <label className="form-label">Lastname</label>
              <span>{lastname}</span>
            </div>
            <div className="form-group mb-2">
              <label className="form-label">EmailAdress</label>
              <span>{email}</span>
            </div>
            <button
                className="btn btn-success"
                onClick={(e) => back(e)}
              >
                Back
              </button>
           
         </form>
        </div>
      </div>
    </div>
  </div>
    
  )
}

export default ViewEmployee

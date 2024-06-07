import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { getEmployee, saveEmp, updateEmployee } from "../service/EmployeeService";

const EmployeeDetails = () => {
  const { id } = useParams();
  const [firstname, setFirstname] = useState("");
  const [lastname, setLastname] = useState("");
  const [email, setEmail] = useState("");
  const navigate = useNavigate();
  const pageTitle = () => {
    return id ? (
      <h2 className="text-center">Update Details</h2>
    ) : (
      <h2 className="text-center">Add Employee</h2>
    );
  };
  const saveOrUpdateEmployee = async (e) => {
    e.preventDefault();

    const employee = { firstname: firstname, lastname: lastname, email: email };
    console.log(employee);

    try {
      if (id) {
        await updateEmployee(id, employee);
        navigate("/employees");
      } else {
        const response = await saveEmp(employee);
        console.log(response.data);
        navigate("/employees");
      }
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
          {pageTitle()}
          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                <label className="form-label">Firstname</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter FirstName"
                  name="firstname"
                  value={firstname}
                  onChange={(e) => setFirstname(e.target.value)}
                />
              </div>
              <div className="form-group mb-2">
                <label className="form-label">Lastname</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter LastName"
                  name="lastname"
                  value={lastname}
                  onChange={(e) => setLastname(e.target.value)}
                />
              </div>
              <div className="form-group mb-2">
                <label className="form-label">EmailAdress</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter EmailId"
                  name="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
              </div>
              <button
                className="btn btn-success"
                onClick={(e) => saveOrUpdateEmployee(e)}
              >
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default EmployeeDetails;

import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { deleteEmployee, getAllEmployees  } from "../service/EmployeeService";
import Table from "react-bootstrap/Table";


const ListEmployeeDetails = () => {
  const [employees, setEmployees] = useState([]);
  const navigate = useNavigate();
  useEffect(() => {
    listEmployees();
  }, []);
  const listEmployees = async () => {
    try {
      const response = await getAllEmployees();
      setEmployees(response.data);
      console.log(response.data);
      console.log(employees);
    } catch (error) {
      console.error(error);
    }
  };

  function addEmployee() {
    navigate("/add-employee");
  }
  function updateEmployee(id) {
    navigate(`/update-employee/${id}`);
  }
  function view(id) {
    navigate(`/view-employee/${id}`);
  }

  const removeEmployee = async (id) => {
    try {
      const response = await deleteEmployee(id);
      listEmployees();
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="container">
      <h2 className="text-center">Employees List</h2>
      <button className="btn btn-primary mb-2" onClick={addEmployee}>
        Add Employee
      </button>
      <div>
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>Firstname </th>
              <th>Lastname </th>
              <th>EmailAddress</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {employees.map((employee) => (
              <tr key={employee.id}>
                <td>{employee.firstname}</td>
                <td>{employee.lastname}</td>
                <td>{employee.email}</td>
                <td>
                  <button
                    className="btn btn-info"
                    style={{ marginLeft: "10px" }}
                    onClick={() => updateEmployee(employee.id)}
                  >
                    Update
                  </button>
                  <button
                    className="btn btn-danger"
                    style={{ marginLeft: "10px" }}
                    onClick={() => removeEmployee(employee.id)}
                  >
                    Delete
                  </button>
                  <button
                    className="btn btn-success"
                    style={{ marginLeft: "10px" }}
                    onClick={() => view(employee.id)}
                  >
                    View</button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    </div>
  );
};
export default ListEmployeeDetails;

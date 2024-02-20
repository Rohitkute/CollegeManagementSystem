import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

import DepartmentService from "../../services/DepartmentService"

const ListDepartmentComponent = () => {
  
    const [departments, setDepartments] = useState([])

    useEffect(() => {
        getAllDepartments();
    }, [])


    const getAllDepartments = () => 
    {
        DepartmentService.getAllDepartments()
      .then((response) => {
        setDepartments(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
    }


    const deleteDepartment = (departmentId) =>
    {
        DepartmentService.deleteDepartment(departmentId).then((response)=>{
            getAllDepartments();
        }).catch(error=> {console.log(error);})
    }

  return (
    <div>
      {/* JSX Code */}
      <h1 className="text-center">Department List </h1>
      <Link to="/add-department">
        <div className="row">
          <button className="btn btn-primary">Add Department</button>
        </div>{" "}
        <br />
      </Link>

      <div className="row">
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <th>Department Id</th>
              <th>Department Name</th>
              <th>Phone Number</th>
              <th>Actions</th>
              <th>Status</th>
            </tr>
          </thead>

          <tbody>
            {departments.map((department) => (
                <tr key={department.departmentId}>
                  <td>{department.departmentId}</td>
                <td>{department.departmentName}</td>
                <td>{department.phoneNo}</td>
                <center>
                  <td>
                     <Link className="btn btn-info btn-block mb-4" to={`/edit-department/${department.departmentId}`}>Edit</Link> 
                    

                     <button className="btn btn-danger btn-block mb-4" onClick={()=> deleteDepartment(department.departmentId)} style={{marginLeft : "10px"}}>Delete</button> 
                    
                  </td>
                </center>
              </tr> 
             ))}
          </tbody> 
        </table>
      </div>
    </div>
  )
}

export default ListDepartmentComponent

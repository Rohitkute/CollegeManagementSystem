import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import ProfessorService from '../../services/ProfessorService';

const ListProfessorComponent = () => {

    const [professors, setProfessors] = useState([]);
    
    useEffect(() => {
       
      getAllProfessors();
    }, [])


    const deleteProfessor = (professorId) =>
    {
      ProfessorService.deleteProfessor(professorId).then((response)=>{ 
      getAllProfessors();
      }).catch(error => {
        console.log(error);
    })
    }

    const getAllProfessors = () =>
    {
      ProfessorService.getAllProfessors().then((response)=>{
        setProfessors(response.data)
    }).catch(error => {
        console.log(error);
    })
    }

  return (
    <div>
      {/* JSX Code */}
      <h1 className="text-center">Professor List </h1>
      <Link to="/add-professor">
        <div className="row">
          <button className="btn btn-primary">Add Professor</button>
        </div>{" "}
        <br />
      </Link>

      <div className="row">
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <th>Id</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Gender</th>
              <th>Email</th>
              <th>Password</th>
              <th>Department Name</th>
              <th>Actions</th>
            </tr>
          </thead>

          <tbody>
            {professors.map((professor) => (
                <tr key={professor.professor_id}>
                  <td>{professor.professor_id}</td>
                  <td>{professor.firstName}</td>
                <td>{professor.lastName}</td>
                <td>{professor.gender}</td>
                <td>{professor.email}</td>
                <td>{professor.password}</td>
                <td>{professor.departmentName}</td>
                <center>
                  <td>
                     <Link className="btn btn-info btn-block mb-4" to={`/edit-professor/${professor.professor_id}`}>Edit</Link> 
                    

                     <button className="btn btn-danger btn-block mb-4" onClick={()=> deleteProfessor(professor.professor_id)} style={{marginLeft : "10px"}}>Delete</button> 
                     
                    
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

export default ListProfessorComponent

import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import StudentService from '../../services/StudentService'

const ListStudentComponent = () => {
    const [students, setStudents] = useState([])

    useEffect(() => {
        StudentService.getAllStudents().then((response) => {
            setStudents(response.data);
        }).catch(error => {
            console.log(error);
        })
    }, [])
    
    const deleteStudent = (studentId) => {
        StudentService.deleteStudent(studentId).then((response) => {
            getAllStudents();
        }).catch(error => {
            console.log(error);
        })
    }
    
    const getAllStudents = () => {
        StudentService.getAllStudents().then((response) => {
            setStudents(response.data)
        }).catch(error => {
            console.log(error);
        })
    }
    
        return (
            <div>
                {/* JSX Code */}
                <h1 className="text-center">Student List </h1>
                <Link to="/add-student">
                    <div className="row">
                        <button className="btn btn-primary">Add Student</button>
                    </div>{" "}
                    <br />
                </Link>
    
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Student Id</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>DOB</th>
                                <th>Gender</th>
                                <th>Email</th>
                                <th>Password</th>
                                <th>Address</th>
                                <th>Course Name</th>
                                <th>Professor Name</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
    
                        <tbody>
                            {students.map((student) => (
                                <tr key={student.studentId}>
                                    <td>{student.studentId}</td>
                                    <td>{student.firstName}</td>
                                    <td>{student.lastName}</td>
                                    <td>{student.dob}</td>
                                    <td>{student.gender}</td>
                                    <td>{student.email}</td>
                                    <td>{student.password}</td>
                                    <td>{student.address}</td>
                                    <td>{student.courseName}</td>
                                    <td>{student.professorName}</td>
                                    <center>
                                        <td>
                                            <Link className="btn btn-info btn-block mb-4" to={`/edit-student/${student.studentId}`}>Edit</Link>
    
    
                                            <button className="btn btn-danger btn-block mb-4" onClick={() => deleteStudent(student.studentId)} style={{ marginLeft: "10px" }}>Delete</button>
    
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

export default ListStudentComponent

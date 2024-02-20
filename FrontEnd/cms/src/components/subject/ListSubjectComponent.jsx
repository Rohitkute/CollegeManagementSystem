import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import SubjectService from '../../services/SubjectService'

const ListSubjectComponent = () => {

const [subjects, setSubjects] = useState([])

useEffect(() => {
    SubjectService.getAllSubjects().then((response) => {
        setSubjects(response.data);
    }).catch(error => {
        console.log(error);
    })
}, [])

const deleteSubject = (subjectId) => {
    SubjectService.deleteSubject(subjectId).then((response) => {
        getAllSubjects();
    }).catch(error => {
        console.log(error);
    })
}

const getAllSubjects = () => {
    SubjectService.getAllSubjects().then((response) => {
        setSubjects(response.data)
    }).catch(error => {
        console.log(error);
    })
}

    return (
        <div>
            {/* JSX Code */}
            <h1 className="text-center">Subject List </h1>
            <Link to="/add-subject">
                <div className="row">
                    <button className="btn btn-primary">Add Subject</button>
                </div>{" "}
                <br />
            </Link>

            <div className="row">
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Subject Id</th>
                            <th>Subject Name</th>
                            <th>Subject Description</th>
                            <th>Professor Name</th>
                            <th>Actions</th>
                        </tr>
                    </thead>

                    <tbody>
                        {subjects.map((subject) => (
                            <tr key={subject.subjectId}>
                                <td>{subject.subjectId}</td>
                                <td>{subject.subjectName}</td>
                                <td>{subject.subjectDescription}</td>
                                <td>{subject.professorName}</td>
                                <center>
                                    <td>
                                        <Link className="btn btn-info btn-block mb-4" to={`/edit-subject/${subject.subjectId}`}>Edit</Link>


                                        <button className="btn btn-danger btn-block mb-4" onClick={() => deleteSubject(subject.subjectId)} style={{ marginLeft: "10px" }}>Delete</button>

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

export default ListSubjectComponent


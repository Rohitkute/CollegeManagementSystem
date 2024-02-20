import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import ExamService from '../../services/ExamService'

const ListExamComponent = () => {

const [exams, setExams] = useState([])

useEffect(() => {
    ExamService.getAllExams().then((response) => {
        setExams(response.data);
    }).catch(error => {
        console.log(error);
    })
}, [])

const deleteExam = (examId) => {
    ExamService.deleteExam(examId).then((response) => {
        getAllExams();
    }).catch(error => {
        console.log(error);
    })
}

const getAllExams = () => {
    ExamService.getAllExams().then((response) => {
        setExams(response.data)
    }).catch(error => {
        console.log(error);
    })
}

    return (
        <div>
            {/* JSX Code */}
            <h1 className="text-center">Exam List </h1>
            <Link to="/add-exam">
                <div className="row">
                    <button className="btn btn-primary">Add Exam</button>
                </div>{" "}
                <br />
            </Link>

            <div className="row">
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Exam Id</th>
                            <th>Exam Name</th>
                            <th>Exam Date</th>
                            <th>Exam Venue</th>
                            <th>Department Name</th>
                            <th>Actions</th>
                        </tr>
                    </thead>

                    <tbody>
                        {exams.map((exam) => (
                            <tr key={exam.examId}>
                                <td>{exam.examId}</td>
                                <td>{exam.examName}</td>
                                <td>{exam.examDate}</td>
                                <td>{exam.examVenue}</td>
                                <td>{exam.departmentName}</td>
                                <center>
                                    <td>
                                        <Link className="btn btn-info btn-block mb-4" to={`/edit-exam/${exam.examId}`}>Edit</Link>


                                        <button className="btn btn-danger btn-block mb-4" onClick={() => deleteExam(exam.examId)} style={{ marginLeft: "10px" }}>Delete</button>

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

export default ListExamComponent


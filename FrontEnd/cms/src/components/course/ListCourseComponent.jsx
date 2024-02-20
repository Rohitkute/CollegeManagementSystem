import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import CourseService from '../../services/CourseService'

const ListCourseComponent = () => {

    const [courses, setCourses] = useState([])

    useEffect(() => {
        CourseService.getAllCourses().then((response)=>{
            setCourses(response.data);
        }).catch(error => {
            console.log(error);
        })
    }, [])

    const deleteCourse = (courseId) =>
    {
        CourseService.deleteCourse(courseId).then((response)=>{ 
      getAllCourses();
      }).catch(error => {
        console.log(error);
    })
    }

    const getAllCourses = () =>
    {
        CourseService.getAllCourses().then((response)=>{
        setCourses(response.data)
    }).catch(error => {
        console.log(error);
    })
    }

    return (
        <div>
            {/* JSX Code */}
            <h1 className="text-center">Course List </h1>
            <Link to="/add-course">
                <div className="row">
                    <button className="btn btn-primary">Add Course</button>
                </div>{" "}
                <br />
            </Link>

            <div className="row">
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Course Id</th>
                            <th>Course Name</th>
                            <th>Description</th>
                            <th>Department Name</th>
                            <th>Actions</th>
                        </tr>
                    </thead>

                    <tbody>
                        {courses.map((course) => (
                            <tr key={course.courseId}>
                                <td>{course.courseId}</td>
                                <td>{course.courseName}</td>
                                <td>{course.description}</td>
                                <td>{course.departmentName}</td>
                                <center>
                                    <td>
                                        <Link className="btn btn-info btn-block mb-4" to={`/edit-course/${course.courseId}`}>Edit</Link>


                                        <button className="btn btn-danger btn-block mb-4" onClick={() => deleteCourse(course.courseId)} style={{ marginLeft: "10px" }}>Delete</button>

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

export default ListCourseComponent

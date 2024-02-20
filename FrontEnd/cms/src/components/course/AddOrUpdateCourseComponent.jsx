import React, { useEffect, useState } from 'react'
import CourseService from "../../services/CourseService" 
import { Link, useNavigate, useParams } from 'react-router-dom'

const AddOrUpdateCourseComponent = () => {

    const [courseId, setCourseId] = useState("")
    const [courseName, setCourseName] = useState("")
    const [description, setDescription] = useState("")
    const [departmentName, setDepartmentName] = useState("")
    const navigate = useNavigate();
    const {id} = useParams();

    const saveOrUpdateCourse = (e) =>
    {
      e.preventDefault();
      const course = {courseId,courseName,description,departmentName}
      console.log(course);
  
    if(id)
    {
        
        CourseService.updateCourse(id,course).then((response)=> {
        navigate("/courses")
      }).catch(error => {console.log(error);})
    }
  
    else{
        CourseService.addCourse(course).then((response)=>{console.log(response.data)
            navigate("/courses")}).catch(error => {console.log(error);})
    }
      }



    const title = () =>
    {
      if(id)
      {
        return <h1 className="text-center">Update Course</h1>
      }
      else
      {
        return <h1 className="text-center">Add Course</h1>
      }
    }

    useEffect(() => {
        CourseService.getCourseById(id).then((response)=>{
            setCourseId(response.data.courseId)
            setCourseName(response.data.courseName)
            setDescription(response.data.description)
            setDepartmentName(response.data.departmentName)
        }).catch(error=>{console.log(error);})
    }, [])

  return (
    <div>
    {
      title()
    }
    <form>
      {/* <!-- 2 column grid layout with text inputs for the first and last names --> */}
      <div className="row mb-30">
        <div className="col">
          <div className="form-outline">
            <label className="form-label" for="courseId">
            Course Id
            </label>
            <input type="number" id="courseId" className="form-control" placeholder="Id is Auto Generated " value={courseId} 
            onChange={(e) => setCourseId(e.target.value)} readOnly/>
          </div>

        </div>
        <div className="col">
          <div className="form-outline">
            <label className="form-label" for="courseName">
            Course Name
            </label>
            <input type="text" id="courseName" className="form-control" value={courseName}
            onChange={(e)=> setCourseName(e.target.value)} />
          </div>
        </div>
      </div>

      {/* <!-- Description input --> */}
      <div className="form-outline mb-4">
        <label className="form-label" for="description">
        Description
        </label>
        <input type="text" id="description" className="form-control" value={description} 
         onChange={(e) => setDescription(e.target.value)} />
      </div>

        {/* <!-- DepartmentName input --> */}
      <div className="form-outline mb-4">
        <label className="form-label" for="departmentName">
        Department Name
        </label>
        <input type="text" id="departmentName" className="form-control" value={departmentName} 
         onChange={(e) => setDepartmentName(e.target.value)} />
      </div>



      {/* <!-- Submit button --> */}
      <center>
        <button type="submit" className="btn btn-primary btn-block mb-4" onClick={(e)=>saveOrUpdateCourse(e)}>
          Submit
        </button>

      <Link to ="/departments" className="btn btn-danger btn-block mb-4">Cancel</Link>
      </center>
    </form>
  </div>
  )
}

export default AddOrUpdateCourseComponent

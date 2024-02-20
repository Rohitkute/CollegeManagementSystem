import React, { useEffect, useState } from 'react'
import ExamService from "../../services/ExamService"
import { Link, useNavigate, useParams } from 'react-router-dom'

const AddOrUpdateExamComponent = () => {


    const [examId, setExamId] = useState("")
    const [examName, setExamName] = useState("")
    const [examDate, setExamDate] = useState("")
    const [examVenue, setExamVenue] = useState("")
    const [departmentName, setDepartmentName] = useState("")
    const navigate = useNavigate();
    const {id} = useParams();

    const saveOrUpdateExam = (e) =>
    {
      e.preventDefault();
      const exam = {examId,examName,examDate,examVenue,departmentName}
      //console.log(exam);
  
    if(id)
    {
        
        ExamService.updateExam(id,exam).then((response)=> {
        navigate("/exams")
      }).catch(error => {console.log(error);})
    }
  
    else{
        ExamService.addExam(exam).then((response)=>{console.log(response.data)
            navigate("/exams")}).catch(error => {console.log(error);})
    }
      }



    const title = () =>
    {
      if(id)
      {
        return <h1 className="text-center">Update Exam</h1>
      }
      else
      {
        return <h1 className="text-center">Add Exam</h1>
      }
    }

    useEffect(() => {
        ExamService.getExamById(id).then((response)=>{
            setExamId(response.data.examId)
            setExamName(response.data.examName)
            setExamDate(response.data.examDate)
            setExamVenue(response.data.examVenue)
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
                            <label className="form-label" for="examId">
                                Exam Id
                            </label>
                            <input type="number" id="examId" className="form-control" placeholder="Id is Auto Generated " value={examId}
                                onChange={(e) => setExamId(e.target.value)} readOnly />
                        </div>

                    </div>
                    <div className="col">
                        <div className="form-outline">
                            <label className="form-label" for="examName">
                                Exam Name
                            </label>
                            <input type="text" id="examName" className="form-control" value={examName}
                                onChange={(e) => setExamName(e.target.value)} />
                        </div>
                    </div>
                </div>

                {/* <!-- Exam Date input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="examDate">
                       Exam Date
                    </label>
                    <input type="text" id="examDate" className="form-control" value={examDate}
                        onChange={(e) => setExamDate(e.target.value)} />
                </div>

                {/* <!-- Exam Venue input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="examVenue">
                       Exam Venue
                    </label>
                    <input type="text" id="examVenue" className="form-control" value={examVenue}
                        onChange={(e) => setExamVenue(e.target.value)} />
                </div>


                {/* <!-- Department input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="departmentName">
                    Department Name
                    </label>
                    <input type="text" id="departmentName" className="form-control" value={departmentName}
                        onChange={(e) => setDepartmentName(e.target.value)} />
                </div>



                {/* <!-- Submit button --> */}
                <center>
                    <button type="submit" className="btn btn-primary btn-block mb-4" onClick={(e) => saveOrUpdateExam(e)}>
                        Submit
                    </button>

                    <Link to="/exams" className="btn btn-danger btn-block mb-4">Cancel</Link>
                </center>
            </form>
        </div>
  )
}

export default AddOrUpdateExamComponent

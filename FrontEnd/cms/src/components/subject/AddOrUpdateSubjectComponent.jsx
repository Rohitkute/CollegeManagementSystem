import React, { useEffect, useState } from 'react'
import SubjectService from "../../services/SubjectService"
import { Link, useNavigate, useParams } from 'react-router-dom'

const AddOrUpdateSubjectComponent = () => {

    const [subjectId, setSubjectId] = useState("")
    const [subjectName, setSubjectName] = useState("")
    const [subjectDescription, setSubjectDescription] = useState("")
    const [professorName, setProfessorName] = useState("")
    const navigate = useNavigate();
    const {id} = useParams();

    const saveOrUpdateSubject = (e) =>
    {
      e.preventDefault();
      const subject = {subjectId,subjectName,subjectDescription,professorName}
      console.log(subject);
  
    if(id)
    {
        
        SubjectService.updateSubject(id,subject).then((response)=> {
        navigate("/subjects")
      }).catch(error => {console.log(error);})
    }
  
    else{
        SubjectService.addSubject(subject).then((response)=>{console.log(response.data)
            navigate("/subjects")}).catch(error => {console.log(error);})
    }
      }



    const title = () =>
    {
      if(id)
      {
        return <h1 className="text-center">Update Subject</h1>
      }
      else
      {
        return <h1 className="text-center">Add Subject</h1>
      }
    }

    useEffect(() => {
        SubjectService.getSubjectById(id).then((response)=>{
            setSubjectId(response.data.subjectId)
            setSubjectName(response.data.subjectName)
            setSubjectDescription(response.data.subjectDescription)
            setProfessorName(response.data.professorName)
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
                            <label className="form-label" for="subjectId">
                                Subject Id
                            </label>
                            <input type="number" id="subjectId" className="form-control" placeholder="Id is Auto Generated " value={subjectId}
                                onChange={(e) => setSubjectId(e.target.value)} readOnly />
                        </div>

                    </div>
                    <div className="col">
                        <div className="form-outline">
                            <label className="form-label" for="subjectName">
                                Subject Name
                            </label>
                            <input type="text" id="subjectName" className="form-control" value={subjectName}
                                onChange={(e) => setSubjectName(e.target.value)} />
                        </div>
                    </div>
                </div>

                {/* <!-- Description input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="subjectDescription">
                       Subject Description
                    </label>
                    <input type="text" id="subjectDescription" className="form-control" value={subjectDescription}
                        onChange={(e) => setSubjectDescription(e.target.value)} />
                </div>

                {/* <!-- Professor input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="professorName">
                    Professor Name
                    </label>
                    <input type="text" id="professorName" className="form-control" value={professorName}
                        onChange={(e) => setProfessorName(e.target.value)} />
                </div>

                {/* <!-- Submit button --> */}
                <center>
                    <button type="submit" className="btn btn-primary btn-block mb-4" onClick={(e) => saveOrUpdateSubject(e)}>
                        Submit
                    </button>

                    <Link to="/subjects" className="btn btn-danger btn-block mb-4">Cancel</Link>
                </center>
            </form>
        </div>
    )
}

export default AddOrUpdateSubjectComponent

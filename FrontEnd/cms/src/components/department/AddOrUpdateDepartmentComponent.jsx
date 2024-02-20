import React, { useEffect, useState } from "react";
import { useNavigate,useParams } from "react-router-dom";
import { Link } from 'react-router-dom';
import DepartmentService from "../../services/DepartmentService"



const AddDepartmentComponent = () => {

    const [departmentId, setDepartmentId] = useState("");
    const [departmentName, setDepartmentName] = useState("");
    const [phoneNo, setPhoneNo] = useState("")
    const navigate = useNavigate()
    const {id} = useParams()


    useEffect(() => {
        DepartmentService.getDepartmentById(id).then((response)=>
        {
            setDepartmentId(response.data.departmentId)
            setDepartmentName(response.data.departmentName)
            setPhoneNo(response.data.phoneNo)
        }).catch(error => {console.log(error);})
    }, [])


    const saveOrUpdateDepartment = (e) =>
    {
      e.preventDefault();
      const department = {departmentId,departmentName,phoneNo}
      console.log(department);
  
    if(id)
    {
        DepartmentService.updateDepartment(id,department).then((response)=> {
        navigate("/departments")
      }).catch(error => {console.log(error);})
    }
  
    else{
        DepartmentService.addDepartment(department).then((response)=>{console.log(response.data)
        navigate("/departments")}).catch(error => {console.log(error);})
    }
      }

    const title = () =>
    {
      if(id)
      {
        return <h1 className="text-center">Update Department</h1>
      }
      else
      {
        return <h1 className="text-center">Add Department</h1>
      }
    }

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
            <label className="form-label" for="id">
              Department Id
            </label>
            <input type="text" id="id" className="form-control" placeholder="Id is Auto Generated " value={departmentId} 
            onChange={(e) => setDepartmentId(e.target.value)} readOnly/>
          </div>

        </div>
        <div className="col">
          <div className="form-outline">
            <label className="form-label" for="departmentName">
              Department Name
            </label>
            <input type="text" id="departmentName" className="form-control" value={departmentName}
            onChange={(e)=> setDepartmentName(e.target.value)} />
          </div>
        </div>
      </div>

      {/* <!-- PhoneNo input --> */}
      <div className="form-outline mb-4">
        <label className="form-label" for="phoneNo">
          Phone No
        </label>
        <input type="text" id="phoneNo" className="form-control" value={phoneNo} 
         onChange={(e) => setPhoneNo(e.target.value)} />
      </div>




      {/* <!-- Submit button --> */}
      <center>
        <button type="submit" className="btn btn-primary btn-block mb-4" onClick={(e)=>saveOrUpdateDepartment(e)}>
          Submit
        </button>

      <Link to ="/departments" className="btn btn-danger btn-block mb-4">Cancel</Link>
      </center>
    </form>
  </div>
  )
}

export default AddDepartmentComponent

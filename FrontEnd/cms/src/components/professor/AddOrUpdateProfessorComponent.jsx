import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';
import ProfessorService from "../../services/ProfessorService"

const AddOrUpdateProfessor = () => {

    
    const [professor_id, setProfessor_id] = useState("");
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("")
    const [gender, setGender] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [addressPincode, setAddressPincode] = useState("")
    const [departmentName, setDepartmentName] = useState("")
    const navigate = useNavigate()
    const { id } = useParams()


    useEffect(() => {
       ProfessorService.getProfessorById(id).then((response)=>
       {
        setProfessor_id(response.data.professor_id);
        setFirstName(response.data.firstName);
        setLastName(response.data.lastName);
        setGender(response.data.gender);
        setEmail(response.data.email);
        setPassword(response.data.password);
        setDepartmentName(response.data.departmentName);
       }).catch(error => {console.log(error);})
    }, [])

    

    const saveOrUpdateProfessor = (e) =>
    {
      e.preventDefault();
      const professor = {professor_id,firstName,lastName,gender,email,password,departmentName}
      console.log(professor);
  
    if(id)
    {
        ProfessorService.updateProfessor(id,professor).then((response)=> {
        navigate("/professors")
      }).catch(error => {console.log(error);})
    }
  
    else{
        ProfessorService.addProfessor(professor).then((response)=>{console.log(response.data)
        navigate("/professors")}).catch(error => {console.log(error);})
    }
  
      }


    const title = () => {
        if (id) {
            return <h1 className="text-center">Update Professor</h1>
        }
        else {
            return <h1 className="text-center">Add Professor</h1>
        }
    }

    return (
        <div>
            {
                title()
            }
            <form>
            <div className="col">
                        <div className="form-outline">
                            <label className="form-label" for="id">
                                Professor Id
                            </label>
                            <input type="text" id="id" className="form-control" placeholder="Id is Auto Generated " value={professor_id}
                                onChange={(e) => setProfessor_id(e.target.value)} readOnly />
                        </div>

                    </div>
                {/* <!-- 2 column grid layout with text inputs for the first and last names --> */}
                <div className="row mb-30">
                   
                    <div className="col">
                        <div className="form-outline">
                            <label className="form-label" for="firstName">
                                First Name
                            </label>
                            <input type="text" id="firstName" className="form-control" value={firstName}
                                onChange={(e) => setFirstName(e.target.value)} />
                        </div>
                    </div>
                    <div className="col">
                        <div className="form-outline">
                            <label className="form-label" for="lastName">
                                Last Name
                            </label>
                            <input type="text" id="lastName" className="form-control" value={lastName}
                                onChange={(e) => setLastName(e.target.value)} />
                        </div>
                    </div>
                </div>

                {/* <!-- Gender input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="gender">
                    Gender 
                    </label>
                    <input type="text" id="gender" className="form-control" value={gender}
                        onChange={(e) => setGender(e.target.value)} />
                </div>


                
                {/* <!-- Email input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="email">
                    Email Id
                    </label>
                    <input type="text" id="email" className="form-control" value={email}
                        onChange={(e) => setEmail(e.target.value)} />
                </div>

                {/* <!-- Password input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="password">
                    Password
                    </label>
                    <input type="password" id="password" className="form-control" value={password}
                        onChange={(e) => setPassword(e.target.value)} />
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
                    <button type="submit" className="btn btn-primary btn-block mb-4" onClick={(e) => saveOrUpdateProfessor(e)}>
                        Submit
                    </button>

                    <Link to="/departments" className="btn btn-danger btn-block mb-4">Cancel</Link>
                </center>
            </form>
        </div>
    )
}

export default AddOrUpdateProfessor

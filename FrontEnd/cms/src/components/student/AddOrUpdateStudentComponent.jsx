import React, { useEffect, useState } from 'react'
import StudentService from "../../services/StudentService"
import { Link, useNavigate, useParams } from 'react-router-dom'

const AddOrUpdateStudentComponent = () => {
    const [studentId, setStudentId] = useState("")
    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [dob, setDob] = useState("")
    const [gender, setGender] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [address, setAddress] = useState("")
    const [courseName, setCourseName] = useState("")
    const [professorName, setProfessorName] = useState("")
    const navigate = useNavigate();
    const {id} = useParams();

    const saveOrUpdateStudent = (e) => {
        e.preventDefault();
        const student = { studentId, firstName, lastName, dob, gender, email, password, address, courseName, professorName }
        console.log(student);

        if (id) {

            StudentService.updateStudent(id, student).then((response) => {
                navigate("/students")
            }).catch(error => { console.log(error); })
        }

        else {
            StudentService.addStudent(student).then((response) => {
                console.log(response.data)
                navigate("/students")
            }).catch(error => { console.log(error); })
        }
    }



    const title = () => {
        if (id) {
            return <h1 className="text-center">Update Student</h1>
        }
        else {
            return <h1 className="text-center">Add Student</h1>
        }
    }

    useEffect(() => {
        StudentService.getStudentById(id).then((response) => {
            setStudentId(response.data.studentId)
            setFirstName(response.data.firstName)
            setLastName(response.data.lastName)
            setDob(response.data.dob)
            setGender(response.data.gender)
            setEmail(response.data.email)
            setPassword(response.data.password)
            setAddress(response.data.address)
            setCourseName(response.data.courseName)
            setProfessorName(response.data.professorName)
        }).catch(error => { console.log(error); })
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
                            <label className="form-label" for="studentId">
                                Student Id
                            </label>
                            <input type="number" id="studentId" className="form-control" placeholder="Id is Auto Generated " value={studentId}
                                onChange={(e) => setStudentId(e.target.value)} readOnly />
                        </div>

                    </div>
                    <div className="col">
                        <div className="form-outline">
                            <label className="form-label" for="firstName">
                                FirstName
                            </label>
                            <input type="text" id="firstName" className="form-control" value={firstName}
                                onChange={(e) => setFirstName(e.target.value)} />
                        </div>
                    </div>
                </div>

                {/* <!-- lastName input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="lastName">
                        LastName
                    </label>
                    <input type="text" id="lastName" className="form-control" value={lastName}
                        onChange={(e) => setLastName(e.target.value)} />
                </div>

                {/* <!-- dob input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="dob">
                        Date Of Birth
                    </label>
                    <input type="date" id="dob" className="form-control" value={dob}
                        onChange={(e) => setDob(e.target.value)} />
                </div>

                {/* <!-- gender input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="gender">
                        Gender
                    </label>
                    <input type="text" id="gender" className="form-control" value={gender}
                        onChange={(e) => setGender(e.target.value)} />
                </div>

                {/* <!-- email input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="email">
                        Email
                    </label>
                    <input type="text" id="email" className="form-control" value={email}
                        onChange={(e) => setEmail(e.target.value)} />
                </div>

                {/* <!-- password input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="password">
                        Password
                    </label>
                    <input type="text" id="password" className="form-control" value={password}
                        onChange={(e) => setPassword(e.target.value)} />
                </div>

                {/* <!-- address input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="address">
                        Address
                    </label>
                    <input type="text" id="address" className="form-control" value={address}
                        onChange={(e) => setAddress(e.target.value)} />
                </div>

                {/* <!-- course input --> */}
                <div className="form-outline mb-4">
                    <label className="form-label" for="courseName">
                        Course Name
                    </label>
                    <input type="text" id="courseName" className="form-control" value={courseName}
                        onChange={(e) => setCourseName(e.target.value)} />
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
                    <button type="submit" className="btn btn-primary btn-block mb-4" onClick={(e) => saveOrUpdateStudent(e)}>
                        Submit
                    </button>

                    <Link to="/students" className="btn btn-danger btn-block mb-4">Cancel</Link>
                </center>
            </form>
        </div>
    )
}

export default AddOrUpdateStudentComponent

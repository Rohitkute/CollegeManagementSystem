import React from 'react'
import professorImg from '../img/professor.jpg'
import studentImg from '../img/student.jpg';
import departmentImg from '../img/Department.jpg';
import subjectImg from '../img/subject.jpg';
import examImg from '../img/Exam1.jpg';
import courseImg from '../img/courses.jpg'



const student = { id: 1, name: "Shri" }

const HomePageComponent = () => {

    return (
        <div>
            <div>
                <p>Hello {student.name}</p>
            </div>

            <div className='d-flex'>
                <div className="card">
                    <div className="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                        <img src={departmentImg} className="img-fluid" style={{ "height": 250 + "px", "width": 500 + "px" }} />
                        <a href="#!">
                            <div className="mask" style={{ backgroundColor: "rgba(251, 251, 251, 0.15)" }}></div>
                        </a>
                    </div>
                    <div className="card-body">
                        <center> <h5 className="card-title">Department Info</h5> </center>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <center><a href="/departments" className="btn btn-primary">View</a> </center>
                    </div>
                </div>


                <div className="card">
                    <div className="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                        <img src={courseImg} className="img-fluid" style={{ "height": 250 + "px", "width": 500 + "px" }} />
                        <a href="#!">
                            <div className="mask" style={{ backgroundColor: "rgba(251, 251, 251, 0.15)" }}></div>
                        </a>
                    </div>
                    <div className="card-body">
                        <center> <h5 className="card-title">Courses Info</h5> </center>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <center><a href="/courses" className="btn btn-primary">View</a> </center>
                    </div>
                </div>

                <div className="card">
                    <div className="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                        <img src={professorImg} className="img-fluid" style={{ "height": 250 + "px", "width": 500 + "px" }} />
                        <a href="#!">
                            <div className="mask" style={{ backgroundColor: "rgba(251, 251, 251, 0.15)" }}></div>
                        </a>
                    </div>
                    <div className="card-body">
                        <center> <h5 className="card-title">Professors Info</h5> </center>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <center><a href="/professors" className="btn btn-primary">View</a> </center>
                    </div>
                </div>




            </div>

            <div className='d-flex'>

                <div className="card ">
                    <div className="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                        <img src={studentImg} className="img-fluid" style={{ "height": 250 + "px", "width": 500 + "px" }} />
                        <a href="#!">
                            <div className="mask" style={{ backgroundColor: "rgba(251, 251, 251, 0.15)" }}></div>
                        </a>
                    </div>
                    <div className="card-body">
                        <center><h5 className="card-title">Students Info</h5> </center>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <center><a href="/students" className="btn btn-primary">View</a> </center>
                    </div>
                </div>
                <div className="card">
                    <div className="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                        <img src={subjectImg} className="img-fluid" style={{ "height": 250 + "px", "width": 500 + "px" }} />
                        <a href="#!">
                            <div className="mask" style={{ backgroundColor: "rgba(251, 251, 251, 0.15)" }}></div>
                        </a>
                    </div>
                    <div className="card-body">
                        <center><h5 className="card-title">Subjects Info</h5> </center>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <center><a href="/subjects" className="btn btn-primary">View</a> </center>
                    </div>
                </div>

                <div className="card">
                    <div className="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                        <img src={examImg} className="img-fluid" style={{ "height": 250 + "px", "width": 500 + "px" }} />
                        <a href="#!">
                            <div className="mask" style={{ backgroundColor: "rgba(251, 251, 251, 0.15)" }}></div>
                        </a>
                    </div>
                    <div className="card-body">
                        <center><h5 className="card-title">Exams Info</h5> </center>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <center><a href="/exams" className="btn btn-primary">View</a> </center>
                    </div>
                </div>

            </div>


        </div>


    )
}

export default HomePageComponent

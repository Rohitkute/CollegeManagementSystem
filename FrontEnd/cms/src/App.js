
import "bootstrap/dist/css/bootstrap.min.css"
import "./App.css"
import { BrowserRouter, Routes, Route } from "react-router-dom"
import LoginPage from "./components/LoginPage"
import StudentSign from "./components/StudentSign"
import ProfSign from "./components/ProfSign"
import Home from "./components/Home"
import AdminHome from "./components/AdminHome"
import StudentHome from "./components/StudentHome"
import ProfessorHome from "./components/ProfessorHome"
import ListCourseComponent from "./components/course/ListCourseComponent"
import AddOrUpdateCourseComponent from "./components/course/AddOrUpdateCourseComponent"
import ListDepartmentComponent from "./components/department/ListDepartmentComponent"
import AddOrUpdateDepartmentComponent from "./components/department/AddOrUpdateDepartmentComponent"
import ListProfessorComponent from "./components/professor/ListProfessorComponent"
import AddOrUpdateProfessorComponent from "./components/professor/AddOrUpdateProfessorComponent"
import ListStudentComponent from "./components/student/ListStudentComponent"
import AddOrUpdateStudentComponent from "./components/student/AddOrUpdateStudentComponent"
import ListSubjectComponent from "./components/subject/ListSubjectComponent"
import AddOrUpdateSubjectComponent from "./components/subject/AddOrUpdateSubjectComponent"
///Rohit
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/Login" element={<LoginPage />} />
        <Route path="/StudentSign" element={<StudentSign/>}/>
        <Route path="/ProfSign" element={<ProfSign/>}/>
        <Route path="/Admin_Home" element={<AdminHome/>}/>
        <Route path="/Student_Home" element={<StudentHome/>}/>
        <Route path="/Professor_Home" element={<ProfessorHome/>}/>
        {/* Course Routing */}
        <Route path="/courses" element={<ListCourseComponent/>}/>
        <Route path="/add-course" element={<AddOrUpdateCourseComponent/>} />
        <Route path="edit-course/:id" element={<AddOrUpdateCourseComponent />} />
        {/* Department Routing */}
        <Route path="/departments" element={<ListDepartmentComponent/>}/>
        <Route path="/add-department" element={<AddOrUpdateDepartmentComponent/>}/>
        <Route path="/edit-department/:id" element={<AddOrUpdateDepartmentComponent/>}/>
        {/* Professor Routing */}
        <Route path="/professors" element={<ListProfessorComponent/>}/>
        <Route path="/add-professor" element={<AddOrUpdateProfessorComponent/>}/>
        <Route path="/edit-professor/:id" element={<AddOrUpdateProfessorComponent/>}/>
        {/* Student Routing */}
        <Route path="/students" element={<ListStudentComponent/>}/>
        <Route path="/add-student" element={<AddOrUpdateStudentComponent/>}/>
        <Route path="/edit-student/:id" element={<AddOrUpdateStudentComponent/>}/>
        {/* Subject Routing */}
        <Route path="/subjects" element={<ListSubjectComponent/>}/>
        <Route path="/add-subject" element={<AddOrUpdateSubjectComponent/>}/>
        <Route path="/edit-subject/:id" element={<AddOrUpdateSubjectComponent/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App
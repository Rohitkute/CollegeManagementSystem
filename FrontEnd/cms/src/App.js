
import "bootstrap/dist/css/bootstrap.min.css"
import "./App.css"
import { BrowserRouter, Routes, Route } from "react-router-dom"
import LoginPage from "./components/LoginPage"
import StudentSign from "./components/StudentSign"
import ProfSign from "./components/ProfSign"
import Home from "./components/Home"

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/Login" element={<LoginPage />} />
        <Route path="/StudentSign" element={<StudentSign/>}/>
        <Route path="/ProfSign" element={<ProfSign/>}/>
      </Routes>
    </BrowserRouter>
  )
}

export default App
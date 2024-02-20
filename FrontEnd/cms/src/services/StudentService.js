import axios from 'axios';

const STUDENT_API_BASE_URL="http://localhost:8080/api/v1/students";

class StudentService
{
    getAllStudents()
    {
        return axios.get(STUDENT_API_BASE_URL + "/listOfStudents");
    }

    addStudent(student)
    {
        return axios.post(STUDENT_API_BASE_URL,student);
    }

    getStudentById(studentId)
    {
        return axios.get(STUDENT_API_BASE_URL+ "/singleStudent/"+ studentId);
    }

    updateStudent(studentId,student)
    {
        return axios.put(STUDENT_API_BASE_URL+ "/updateStudent/"+studentId,student);
    }

    deleteStudent(studentId)
    {
        return axios.delete(STUDENT_API_BASE_URL + "/deleteSingleStudent/"+studentId);
    }

}

export default new StudentService();
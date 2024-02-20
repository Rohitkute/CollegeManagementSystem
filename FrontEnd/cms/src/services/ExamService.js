import axios from 'axios';

const EXAM_API_BASE_URL="http://localhost:8080/api/v1/exams";

class ExamService
{
    getAllExams()
    {
        return axios.get(EXAM_API_BASE_URL + "/ListOfExams");
    }

    addExam(exam)
    {
        return axios.post(EXAM_API_BASE_URL,exam);
    }

    getExamById(examId)
    {
        return axios.get(EXAM_API_BASE_URL+ "/exams/"+ examId);
    }

    updateExam(examId,exam)
    {
        return axios.put(EXAM_API_BASE_URL+ "/updateExam/"+examId,exam);
    }

    deleteExam(examId)
    {
        return axios.delete(EXAM_API_BASE_URL + "/deleteSingleExam/"+examId);
    }

}

export default new ExamService();
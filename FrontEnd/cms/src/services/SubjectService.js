import axios from 'axios';

const SUBJECT_API_BASE_URL="http://localhost:8080/api/v1/subjects";

class SubjectService
{
    getAllSubjects()
    {
        return axios.get(SUBJECT_API_BASE_URL + "/ListOfSubjects");
    }

    addSubject(subject)
    {
        return axios.post(SUBJECT_API_BASE_URL,subject);
    }

    getSubjectById(subjectId)
    {
        return axios.get(SUBJECT_API_BASE_URL+ "/subjects/"+ subjectId);
    }

    updateSubject(subjectId,subject)
    {
        return axios.put(SUBJECT_API_BASE_URL+ "/updateSubject/"+subjectId,subject);
    }

    deleteSubject(subjectId)
    {
        return axios.delete(SUBJECT_API_BASE_URL + "/deleteSingleSubject/"+subjectId);
    }

}

export default new SubjectService();
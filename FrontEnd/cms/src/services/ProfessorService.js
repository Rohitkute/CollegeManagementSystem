import axios from 'axios';

const PROFESSOR_API_BASE_URL="http://localhost:8080/api/v1/professors";

class ProfessorService
{
    getAllProfessors()
    {
        return axios.get(PROFESSOR_API_BASE_URL + "/ListOfProfessors");
    }

    addProfessor(professor)
    {
        return axios.post(PROFESSOR_API_BASE_URL,professor);
    }

    getProfessorById(professorId)
    {
        return axios.get(PROFESSOR_API_BASE_URL+ "/singleProfessor/"+ professorId);
    }

    updateProfessor(professorId,professor)
    {
        return axios.put(PROFESSOR_API_BASE_URL+ "/updateProfessor/"+professorId,professor);
    }

    deleteProfessor(professorId)
    {
        return axios.delete(PROFESSOR_API_BASE_URL + "/deleteSingleProfessor/"+professorId);
    }

}

export default new ProfessorService();
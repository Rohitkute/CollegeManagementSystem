import axios from 'axios';

const DEPARTMENT_API_BASE_URL="http://localhost:8080/api/v1/department";

class DepartmentService
{
    getAllDepartments()
    {
        return axios.get(DEPARTMENT_API_BASE_URL + "/ListOfDepartments");
    }

    addDepartment(department)
    {
        return axios.post(DEPARTMENT_API_BASE_URL,department);
    }

    updateDepartment(departmentId,department)
    {
        return axios.put(DEPARTMENT_API_BASE_URL+"/updateDepartment/"+ departmentId, department);
    }

    getDepartmentById(departmentId)
    {
        return axios.get(DEPARTMENT_API_BASE_URL + "/" + departmentId);
    }
    deleteDepartment(departmentId)
    {
        return axios.delete(DEPARTMENT_API_BASE_URL + "/deleteDepartment/" + departmentId);
    }
}

export default new DepartmentService();
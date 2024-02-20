import axios from 'axios';

const COURSE_API_BASE_URL="http://localhost:8080/api/v1/courses";

class CourseService
{
    getAllCourses()
    {
        return axios.get(COURSE_API_BASE_URL + "/ListOfCourses");
    }

    addCourse(course)
    {
        return axios.post(COURSE_API_BASE_URL,course)
    }

    getCourseById(courseId)
    {
        return axios.get(COURSE_API_BASE_URL+ "/singleCourse/"+courseId)
    }

    updateCourse(courseId,course)
    {
        return axios.put(COURSE_API_BASE_URL+ "/updateCourse/"+courseId,course);
    }

    deleteCourse(courseId)
    {
        return axios.delete(COURSE_API_BASE_URL + "/deleteSingleCourse/"+courseId);
    }

}

export default new CourseService();
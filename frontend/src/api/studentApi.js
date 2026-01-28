import axios from "axios"
const API="http://localhost:8080/api/students"

export const getStudents = (page = 0) =>{
    return axios.get(`${API}?page=0&size=5`)
}
export const searchStudents= (query) => {
    return axios.get(`${API}/search?query=${query}`)
}
export const createStudent = (data) => {
    return axios.post(API, data);
}
export const deleteStudent = (id) =>{
    return axios.delete(`${API}/${id}`)
}
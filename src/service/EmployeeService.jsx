import axios from "axios";
import { getToken } from "./AuthService";
const BASE_REST_API_URL="http://localhost:8080/api/employees";
axios.interceptors.request.use
         (function (config) {
    config.headers["Authorization"]=getToken();
    return config;
  }, function (error) {
    
    return Promise.reject(error);
  });
export const getAllEmployees=()=>axios.get(BASE_REST_API_URL);
export const saveEmp=(employee)=>axios.post(BASE_REST_API_URL,employee);
export const getEmployee=(id)=>axios.get(BASE_REST_API_URL+"/"+id);
export const updateEmployee=(id,employee)=>axios.put(BASE_REST_API_URL +"/"+ id,employee);
export const deleteEmployee=(id)=>axios.delete(BASE_REST_API_URL+"/"+id);
export const view=(id)=>axios.get(BASE_REST_API_URL +"/"+ id);

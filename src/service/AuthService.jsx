import axios from "axios";
const Auth_REST_API_URL = "http://localhost:8080/api/auth";

export const registerAPICall = (registerObj) =>
  axios.post(Auth_REST_API_URL + "/register", registerObj);
export const loginAPICall = (username, password) =>
  axios.post(Auth_REST_API_URL + "/login", { username, password });
export const storeToken = (token) => localStorage.setItem("token", token);
export const getToken = () => localStorage.getItem("token");
export const saveLoggedInUser = (username, role) => {
  localStorage.setItem("authendicatedUser", username);
  localStorage.setItem("role", role);
};
export const isUserLoggedIn = () => {
  const username = localStorage.getItem("authendicatedUser");
  if (username == null) {
    return false;
  } else {
    return true;
  }
};
export const getLoggedInUser = () => {
  return localStorage.getItem("authendicatedUser");
};

export const logout = () => {
  localStorage.clear();
  localStorage.clear();
};
export const isAdminUser = () => {
  const role = localStorage.getItem("role");
  if (role != null && role == "ROLE_ADMIN") {
    return true;
  } else {
    return false;
  }
};

import axios from 'axios';

// Create an Axios instance
const ApiClient = axios.create({
  baseURL: 'http://localhost:8080', // Base URL for the API
  timeout: 10000, // Timeout after 10 seconds
  headers: {
    'Content-Type': 'application/json', // Default content type
  },
});

// Optional: Add a request interceptor
ApiClient.interceptors.request.use(
  (config) => {
    // You can modify the request config before sending it, for example, to add auth tokens
    // const token = localStorage.getItem('token');
    // if (token) {
    //   config.headers.Authorization = `Bearer ${token}`;
    // }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// Optional: Add a response interceptor
ApiClient.interceptors.response.use(
  (response) => {
    // Handle the response data
    return response;
  },
  (error) => {
    // Handle errors
    return Promise.reject(error);
  }
);

export default ApiClient;

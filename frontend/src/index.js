import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';  // Corrected import
import App from './App';
//import LoginPage from "../src/Pages/LoginPage";
import { LoginPage } from '../src/Pages/LoginPage';
import RegisterPage from "../src/Pages/RegisterPage";

const router = createBrowserRouter([
  {
    path: '/',
    element: <LoginPage />
  },
  
  {
    path: '/RegisterPage',
    element: <RegisterPage />
  }

]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
    {/* <App /> */}
  </React.StrictMode>
);

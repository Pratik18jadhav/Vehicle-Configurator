import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import { LoginPage } from '../src/Pages/LoginPage';
import RegisterPage from "../src/Pages/RegisterPage";
import LandingPage from "../src/Pages/LandingPage";
import Selection from "../src/Pages/Selection";
import Business from "../src/Pages/Buisnes";
import InvoicePage from "../src/Pages/InvoicePage";
import Abhishek2 from '../src/Components/Abhishek2';
import ProtectedRoute from '../src/Service/ProtectedRoutes'; // Import ProtectedRoute

const router = createBrowserRouter([
  {
    path: '/',
    element: <LandingPage />
  },
  {
    path: '/LoginPage',
    element: <LoginPage />
  },
  {
    path: '/RegisterPage',
    element: <RegisterPage />
  },
  {
    path: '/LandingPage',
    element: <LandingPage />
  },
  {
    path: '/SelectionPage',
    element: <ProtectedRoute element={<Selection />} /> // Protected
  },
  {
    path: '/BusinessPage',
    element: <ProtectedRoute element={<Business />} /> // Protected
  },
  {
    path: '/InvoicePage',
    element: <ProtectedRoute element={<InvoicePage />} /> // Protected
  },
  {
    path: '/Abhishek2',
    element: <ProtectedRoute element={<Abhishek2 />} /> // Protected
  }
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './Components/login';
import StudentDashboard from './Components/Student/StudentDashboard';
import StudentProfile from './Components/Student/StudentProfile';
import FacultyDashboard from './Components/Faculty/FacultyDashboard';
import AdminDashboard from './Components/Admin/AdminDashboard';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/student-dashboard" element={<StudentDashboard />} />
                <Route path="/student-profile" element={<StudentProfile />} />
                <Route path="/faculty-dashboard" element={<FacultyDashboard />} />
                <Route path="/admin-dashboard" element={<AdminDashboard />} />
            </Routes>
        </Router>
    );
}

export default App;

import React from 'react';
import { Link } from 'react-router-dom';

const FacultyDashboard = () => {
    return (
        <div>
            <h2>Faculty Dashboard</h2>
            <Link to="/class-list">Manage Class List</Link>
            <Link to="/update-faculty-profile">Update Profile</Link>
        </div>
    );
};

export default FacultyDashboard;

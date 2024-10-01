import React from 'react';
import { Link } from 'react-router-dom';

const AdminDashboard = () => {
    return (
        <div>
            <h2>Admin Dashboard</h2>
            <Link to="/manage-records">Manage Student and Faculty Records</Link>
            <Link to="/dashboard-graphs">View Dashboard Graphs</Link>
        </div>
    );
};

export default AdminDashboard;
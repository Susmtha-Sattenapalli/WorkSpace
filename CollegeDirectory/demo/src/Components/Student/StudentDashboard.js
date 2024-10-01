import React from 'react';
import { Link } from 'react-router-dom';

const StudentDashboard = () => {
    return (
        <div>
            <h2>Student Dashboard</h2>
            <Link to="/student-profile">View Profile</Link>
            <Link to="/search-students">Search Students</Link>
            <Link to="/contact-faculty">Contact Faculty Advisors</Link>
        </div>
    );
};

export default StudentDashboard;

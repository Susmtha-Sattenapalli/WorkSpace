import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { login } from '../Services/auth';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [role, setRole] = useState('STUDENT');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const userRole = await login({ username, password, role });
            if (userRole === 'STUDENT') navigate('/student-dashboard');
            if (userRole === 'FACULTY_MEMBER') navigate('/faculty-dashboard');
            if (userRole === 'ADMINISTRATOR') navigate('/admin-dashboard');
        } catch (error) {
            alert('Invalid credentials');
        }
    };

    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} placeholder="Username" required />
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Password" required />
                <select value={role} onChange={(e) => setRole(e.target.value)}>
                    <option value="STUDENT">Student</option>
                    <option value="FACULTY_MEMBER">Faculty Member</option>
                    <option value="ADMINISTRATOR">Administrator</option>
                </select>
                <button type="submit">Login</button>
            </form>
        </div>
    );
};

export default Login;

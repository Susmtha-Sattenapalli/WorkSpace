import axios from 'axios';

export const getStudentProfile = async () => {
    const response = await axios.get('/api/student/profile');
    return response.data;
};

export const getFacultyProfile = async () => {
    const response = await axios.get('/api/faculty/profile');
    return response.data;
};

export const getAdminDashboardData = async () => {
    const response = await axios.get('/api/admin/dashboard');
    return response.data;
};

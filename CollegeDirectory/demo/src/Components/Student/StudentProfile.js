import React, { useEffect, useState } from 'react';
import { getStudentProfile } from '../../Services/api';

const StudentProfile = () => {
    const [profile, setProfile] = useState(null);

    useEffect(() => {
        const fetchProfile = async () => {
            const data = await getStudentProfile();
            setProfile(data);
        };
        fetchProfile();
    }, []);

    if (!profile) return <div>Loading...</div>;

    return (
        <div>
            <h2>{profile.name}'s Profile</h2>
            <img src={profile.photo} alt={profile.name} />
            <p>Email: {profile.email}</p>
            <p>Phone: {profile.phone}</p>
            <h3>Academic Information</h3>
            <p>Department: {profile.department.name}</p>
            <p>Year: {profile.year}</p>
        </div>
    );
};

export default StudentProfile;
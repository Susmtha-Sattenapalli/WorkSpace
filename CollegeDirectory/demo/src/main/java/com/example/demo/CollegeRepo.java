package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class CollegeRepo {

    // UserRepository.java
    public interface UserRepository extends JpaRepository<CollegeData.users, Long> {
        Optional<CollegeData.users> findByUsername(String username);
    }

    // StudentProfileRepository.java
    public interface StudentProfileRepository extends JpaRepository<CollegeData.StudentProfile, Long> {}

// Similarly for FacultyProfileRepository, CourseRepository, EnrollmentRepository


}

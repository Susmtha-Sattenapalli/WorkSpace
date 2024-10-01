package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

public class CollegeData {

    // User.java
    @Entity
    @Data
    @Table(name = "users")
    public class users {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true, nullable = false)
        private String username;

        @Column(nullable = false)
        private String password;

        @Enumerated(EnumType.STRING)
        private Role role;

        @Column(nullable = false)
        private String name;

        @Column(unique = true, nullable = false)
        private String email;

        private String phone;


    }

    // Role Enum
    public enum Role {
        STUDENT, FACULTY_MEMBER, ADMINISTRATOR
    }

    // StudentProfile.java
    @Entity
    @Data
    public class StudentProfile {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private users users;

        private String photo;

        @ManyToOne
        @JoinColumn(name = "department_id", referencedColumnName = "id")
        private Department department;

        private String year;


    }

// Similar for FacultyProfile.java, AdministratorProfile.java

    // Course.java
    @Entity
    @Data
    public class Course {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;

        private String description;

        @ManyToOne
        @JoinColumn(name = "department_id")
        private Department department;

        @ManyToOne
        @JoinColumn(name = "faculty_id", referencedColumnName = "user_id")
        private FacultyProfile faculty;


    }

    // Enrollment.java
    @Entity
    @Data
    public class Enrollment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "student_id", referencedColumnName = "user_id")
        private StudentProfile student;

        @ManyToOne
        @JoinColumn(name = "course_id")
        private Course course;


    }

    // Department.java
    @Entity
    @Data
    public class Department {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String description;


    }

    @Entity
    @Data
    @Table(name = "faculty_profile")
    public class FacultyProfile {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private users user;

        private String photo;

        @ManyToOne
        @JoinColumn(name = "department_id", referencedColumnName = "id")
        private Department department;

        private String officeHours;
    }

    @Entity
    @Data
    @Table(name = "administrator_profile")
    public class AdministratorProfile {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private users user;

        private String photo;

        @ManyToOne
        @JoinColumn(name = "department_id", referencedColumnName = "id")
        private Department department;

    }

}

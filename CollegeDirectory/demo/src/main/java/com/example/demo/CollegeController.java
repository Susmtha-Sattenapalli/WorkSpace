package com.example.demo;

import com.example.demo.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CollegeController {


    // UserController.java
    @RestController
    @RequestMapping("/api/users")
    public class UserController {
        @Autowired
        private CollegeService.UserService userService;


        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
            CollegeData.users user = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
            if (user != null) {
                return ResponseEntity.ok(user);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        // Create endpoints for profile, courses, enrollments
    }

    // CourseController.java
    @RestController
    @RequestMapping("/api/courses")
    public class CourseController {
        @Autowired
        private CollegeService.CourseService courseService;

        @GetMapping
        public List<CollegeData.Course> getAllCourses() {
            return courseService.getAllCourses();
        }

        // Add endpoints for CRUD
    }

}

package com.ironhack.ironschool.controller;

import com.ironhack.ironschool.model.Course;
import com.ironhack.ironschool.model.Student;
import com.ironhack.ironschool.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourse(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable String courseId){
        return courseService.getCourseById(courseId);
    }

    @PostMapping
    public void createCourse(@Valid @RequestBody Course course){
        courseService.createCourse(course);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(String courseId){
        courseService.deleteCourse(courseId);
    }

    @PutMapping("/{courseId}/teacher/{teacherId}")
    public  void assignTeacherToCourse(@PathVariable String courseId,@PathVariable String teacherId){
        courseService.assignTeacherToCourse(teacherId,courseId);
    }
    @PutMapping("{courseId}/students/{studentId}")
    public  void enrollStudent(@PathVariable String courseId , @PathVariable String studentId){
        courseService.assignTeacherToCourse(studentId,courseId);
    }

    @GetMapping("/total-money")
    public double getTotalMoneyEarned(){
        return courseService.getTotalMoneyEarned();
    }

    @GetMapping("/profit")
    public double showProfit(){
        return  courseService.showProfit();
    }
}

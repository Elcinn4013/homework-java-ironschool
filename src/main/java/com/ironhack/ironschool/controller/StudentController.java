package com.ironhack.ironschool.controller;

import com.ironhack.ironschool.model.Student;
import com.ironhack.ironschool.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable String studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public void createStudent(@Valid @RequestBody Student student){
        studentService.createStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(String studentId){
        studentService.deleteStudent(studentId);
    }

}

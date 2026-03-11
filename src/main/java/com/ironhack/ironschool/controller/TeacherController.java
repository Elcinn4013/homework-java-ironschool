package com.ironhack.ironschool.controller;

import com.ironhack.ironschool.model.Teacher;
import com.ironhack.ironschool.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getAllTeacher(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{teacherId}")
    public Teacher getTeacherById(@PathVariable String teacherId){
        return teacherService.getTeacherById(teacherId);
    }

    @PostMapping
    public void creatTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.createTeacher(teacher);
    }

    @DeleteMapping("/{teacherId}")
    public void deleteStudent(String teacherId){
        teacherService.deleteTeacher(teacherId);
    }

}

package com.ironhack.ironschool.service;

import com.ironhack.ironschool.exception.TeacherNotFoundException;
import com.ironhack.ironschool.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//testing
@Service
public class TeacherService {

    private List<Teacher> teachers = new ArrayList<>();

    public Teacher createTeacher(Teacher teacher) {
        teachers.add(teacher);
        return teacher;
    }

    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    public Teacher getTeacherById(String teacherId) {

        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId().equalsIgnoreCase(teacherId)) {
                return teacher;
            }
        }

        throw new TeacherNotFoundException(teacherId);
    }

    public void deleteTeacher(String teacherId) {

        Teacher teacher = getTeacherById(teacherId);
        teachers.remove(teacher);
    }

    public double getTotalSalarySpent() {

        double total = 0;

        for (Teacher teacher : teachers) {
            total += teacher.getSalary();
        }

        return total;
    }

    public Teacher updateTeacher(String teacherId , Teacher updatedTeacher){
        Teacher existing = getTeacherById(teacherId);

        existing.setSalary(updatedTeacher.getSalary());
        existing.setName(updatedTeacher.getName());

        return existing;

    }

    public Teacher partialUpdate(String teacherId , Teacher updatedTeacher){
        Teacher existing = getTeacherById(teacherId);

        //We write validation so it cant be null

//        if(updatedTeacher.getSalary() != null){
//            existing.setSalary(updatedTeacher.getSalary());
//        }
//I change type double --> Double
        if(updatedTeacher.getName() != null){
            existing.setName(updatedTeacher.getName());
        }

        if (updatedTeacher.getSalary() != null) {
            existing.setSalary(updatedTeacher.getSalary());
        }

        return existing;
    }
}
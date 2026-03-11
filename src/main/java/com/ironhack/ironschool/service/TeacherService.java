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
}
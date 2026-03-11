package com.ironhack.ironschool.service;

import com.ironhack.ironschool.exception.StudentNotFoundException;
import com.ironhack.ironschool.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public Student createStudent(Student student) {
        students.add(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(String studentId) {

        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }

        throw new StudentNotFoundException(studentId);
    }

    public void deleteStudent(String studentId) {
        Student student = getStudentById(studentId);
        students.remove(student);
    }
}
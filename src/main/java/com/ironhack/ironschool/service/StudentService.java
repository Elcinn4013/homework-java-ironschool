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


    public Student updateStudent(String studentId , Student updatedStudent){
        Student existing = getStudentById(studentId);

        existing.setAddress(updatedStudent.getAddress());
        existing.setCourse(updatedStudent.getCourse());
        existing.setEmail(updatedStudent.getEmail());
        existing.setName(updatedStudent.getName());

        return existing;
    }

    public Student patchStudent(String studentId , Student partialStudent){
        Student existing = getStudentById(studentId);

        if(partialStudent.getAddress() != null){
            existing.setAddress(partialStudent.getAddress());
        }

        if(partialStudent.getCourse() != null ){
            existing.setCourse(partialStudent.getCourse());
        }

        if(partialStudent.getEmail() != null ){
            existing.setEmail(partialStudent.getEmail());
        }

        if(partialStudent.getName() != null ){
            existing.setName(partialStudent.getName());
        }


        return existing;
    }
}
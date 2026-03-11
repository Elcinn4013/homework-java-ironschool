package com.ironhack.ironschool.service;

import com.ironhack.ironschool.exception.CourseNotFoundException;
import com.ironhack.ironschool.model.Course;
import com.ironhack.ironschool.model.Student;
import com.ironhack.ironschool.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>();

    private TeacherService teacherService;
    private StudentService studentService;

    public CourseService(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    public Course createCourse(Course course) {
        courses.add(course);
        return course;
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseById(String courseId) {

        for (Course course : courses) {
            if (course.getCourseId().equalsIgnoreCase(courseId)) {
                return course;
            }
        }

        throw new CourseNotFoundException(courseId);
    }

    public void deleteCourse(String courseId) {

        Course course = getCourseById(courseId);
        courses.remove(course);
    }

    public void assignTeacherToCourse(String teacherId, String courseId) {

        Teacher teacher = teacherService.getTeacherById(teacherId);
        Course course = getCourseById(courseId);

        course.setTeacher(teacher);
    }

    public void enrollStudent(String studentId, String courseId) {

        Student student = studentService.getStudentById(studentId);
        Course course = getCourseById(courseId);

        student.setCourse(course);

        double newMoney = course.getMoneyEarned() + course.getPrice();
        course.setMoneyEarned(newMoney);
    }

    public double getTotalMoneyEarned() {

        double total = 0;

        for (Course course : courses) {
            total += course.getMoneyEarned();
        }

        return total;
    }

    public double showProfit() {

        double earned = getTotalMoneyEarned();
        double spent = teacherService.getTotalSalarySpent();

        return earned - spent;
    }
}
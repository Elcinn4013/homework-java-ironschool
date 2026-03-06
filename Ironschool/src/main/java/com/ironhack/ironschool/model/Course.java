package com.ironhack.ironschool.model;

public class Course {

    private int counter = 1;
    private String courseId;
    private String name;
    private double salary;
    private Teacher teacher;

    public Course(String name , double salary) {
        this.name = name;
        this.salary=salary;
    }


    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

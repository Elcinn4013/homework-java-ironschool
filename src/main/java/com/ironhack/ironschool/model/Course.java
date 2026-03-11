package com.ironhack.ironschool.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
public class Course {

    private static int counter = 1;
    private  String courseId;

    @NotBlank(message = "Course name cannot be empty")
    private String name;

    @Min(value = 0, message = "Price cannot be negative")
    private double price;

    private double moneyEarned;

    private Teacher teacher;

    public Course() {
        this.courseId = "C" + counter++;
        this.moneyEarned = 0;
    }

    public Course(String name, double price) {
        this.courseId = "C" + counter++;
        this.name = name;
        this.price = price;
        this.moneyEarned = 0;
        this.teacher = null;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMoneyEarned(double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
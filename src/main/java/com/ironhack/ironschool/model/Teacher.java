package com.ironhack.ironschool.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Teacher {

    private int counter = 1;
    private String teacherId;

    @NotBlank
    private String name;

    @Min(value = 400 , message = "Minimum salary for Azerbaijan is 400 azn . Salary cant be less than 400 azn")
    private double salary;

    public Teacher(String name , double Salary ) {
        this.name = name;
        this.salary = salary;
        this.teacherId = "T" + counter++;
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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}

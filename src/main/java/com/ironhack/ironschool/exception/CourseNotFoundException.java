package com.ironhack.ironschool.exception;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(String courseId){
        super("Course not found" + courseId);
    }

}

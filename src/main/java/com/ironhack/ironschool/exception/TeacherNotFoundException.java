package com.ironhack.ironschool.exception;

public class TeacherNotFoundException extends RuntimeException{
    public TeacherNotFoundException(String teacherId){
        super("Teacher not found" + teacherId);
    }
}

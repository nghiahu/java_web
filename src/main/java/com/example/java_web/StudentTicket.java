package com.example.java_web;

public class StudentTicket {
    private String studentName;
    private String className;
    private String type;
    private String licensePlate;

    public StudentTicket(String studentName, String className, String type, String licensePlate) {
        this.studentName = studentName;
        this.className = className;
        this.type = type;
        this.licensePlate = licensePlate;
    }

    public String getStudentName() { return studentName; }
    public String getClassName() { return className; }
    public String getType() { return type; }
    public String getLicensePlate() { return licensePlate; }
}
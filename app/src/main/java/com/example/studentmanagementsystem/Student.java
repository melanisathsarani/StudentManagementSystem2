
package com.example.studentmanagementsystem;

public class Student {

    int id;
    String name;
    String student_id;
    String email;
    String course;

    public Student(int id, String name, String student_id,
                   String email, String course) {

        this.id = id;
        this.name = name;
        this.student_id = student_id;
        this.email = email;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }
}
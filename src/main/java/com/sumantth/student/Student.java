package com.sumantth.student;
import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    private int id;
    private String name;
    private int age;
    private float marks;
    private String grade;

    @ManyToOne
    @JoinColumn(name = "department_id",
            nullable = true)  // can be null!
    private Department department;

    // constructor WITHOUT department
    public Student(int id, String name,
                   int age, float marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = setGrade(marks);
        this.department = null;
    }

    public Student(int id, String name,
                   int age, float marks,
                   Department department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = setGrade(marks);
        this.department = department;
    }


    public Student() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public float getMarks() { return marks; }
    public void setMarks(float marks) {
        this.marks = marks;
        this.grade = setGrade(marks);
    }

    public String getGrade() { return grade; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) {
        this.department = department;
    }

    private String setGrade(float marks) {
        if(marks >= 90) return "A";
        else if(marks >= 80) return "B";
        else if(marks >= 70) return "C";
        else if(marks >= 60) return "D";
        else return "F";
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Age: " + age +
                " | Marks: " + marks +
                " | Grade: " + grade +
                " | Department: " +
                (department != null ?
                        department.getName() : "Not Assigned");
    }
}
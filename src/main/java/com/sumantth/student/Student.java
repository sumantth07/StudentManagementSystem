package com.sumantth.student;

public class Student {
    private int id;
    private String name;
    private int age ;
    private float marks;
    private String grade;

    public Student(int id,String name,int age,float marks){
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = setGrade(marks);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
        this.grade = setGrade(marks); // update grade too!

    }

    private String setGrade(float marks) {
        if(marks >= 90) return "A";
        else if(marks >= 80) return "B";
        else if(marks >= 70) return "C";
        else if(marks >= 60) return "D";
        else return "F";
    }
    public String getGrade() {
        return grade;
    }
    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Age: " + age +
                " | Marks: " + marks +
                " | Grade: " + grade;
    }




}

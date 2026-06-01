package com.sumantth.student;

import java.util.List;


public class StudentService {
    StudentRepository repository = new StudentRepository();
   public void  addStudent(int id, String name, int age, float marks){

       // Step 1 — validate
       if(name.isEmpty()) {
           System.out.println("Name cannot be empty!");
           return;
       }
       if(age <= 0) {
           System.out.println("Invalid age!");
           return;
       }
       if(marks < 0 || marks > 100) {
           System.out.println("Marks must be 0-100!");
           return;
       }
       Student s = new Student(id, name, age, marks);
       repository.save(s);

       System.out.println("Student added successfully!");

   }
   public List<Student> getAllStudents(){
       return repository.findAll();
   }
    public Student getStudentById(int id) {
        Student s = repository.findById(id);
        if(s == null) {
            throw new StudentNotFoundException(
                    "Student not found with ID: " + id
            );
        }
        return s;
    }

    public void deleteStudent(int id){
       getStudentById(id);
       repository.deleteById(id);
        System.out.println("Student deleted!");

    }
    public void updateStudent(int id, String name,
                              int age, float marks) {

        getStudentById(id);

        Student updated = new Student(id, name,
                age, marks);
        repository.update(updated);
        System.out.println("Student updated!");
    }
    public void generateReport() {
        List<Student> students = repository.findAll();

        if(students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        int total = students.size();
        float highest = 0, lowest = 100, sum = 0;
        int pass = 0, fail = 0;

        for(Student s : students) {
            float marks = s.getMarks();
            if(marks > highest) highest = marks;
            if(marks < lowest) lowest = marks;
            sum += marks;
            if(marks >= 60) pass++;
            else fail++;
        }

        float average = sum / total;

        System.out.println("─────────────────────");
        System.out.println("Total Students : " + total);
        System.out.println("Highest Marks  : " + highest);
        System.out.println("Lowest Marks   : " + lowest);
        System.out.println("Average Marks  : " + average);
        System.out.println("Pass Count     : " + pass);
        System.out.println("Fail Count     : " + fail);
        System.out.println("─────────────────────");
    }





}

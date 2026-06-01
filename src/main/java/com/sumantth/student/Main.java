package com.sumantth.student;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice;

        do {
            // print menu
            System.out.println("══════════════════════════");
            System.out.println("  STUDENT MANAGEMENT SYSTEM");
            System.out.println("══════════════════════════");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Generate Report");
            System.out.println("0. Exit");
            System.out.println("══════════════════════════");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("enter ID");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer!
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Marks: ");
                    float marks = sc.nextFloat();
                    service.addStudent(id,name,age,marks);
                    break;
                case 2:
                    List<Student> students = service.getAllStudents();
                    if(students.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        for(Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    try {
                        Student found = service.getStudentById(searchId);
                        System.out.println(found);
                    } catch(StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4: System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new Age: ");
                    int newAge = sc.nextInt();
                    System.out.print("Enter new Marks: ");
                    float newMarks = sc.nextFloat();
                    try {
                        service.updateStudent(updateId, newName,
                                newAge, newMarks);
                    } catch(StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    try {
                        service.deleteStudent(deleteId);
                    } catch(StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:  service.generateReport();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while(choice != 0);

    }
}

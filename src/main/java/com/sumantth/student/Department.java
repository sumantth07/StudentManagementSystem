package com.sumantth.student;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "departments")
public class Department {

    @Id
    private int id;
    private String name ;

    @OneToMany(mappedBy = "department",
            cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Student> students;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department() {

    }

    public int getId() {
        return id;
    }


    public Department(int id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Department: " + name;
    }
}

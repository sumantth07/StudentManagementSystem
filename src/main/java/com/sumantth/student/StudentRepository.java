package com.sumantth.student;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public List<Student> findAll() {
        return students;
    }

    public void save(Student s) {
        students.add(s);
    }

    public Student findById(int id){
        for(Student s : students){
            if(s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public   void deleteById(int id){
        for(Student s : students){
            if(s.getId() == id) {
                students.remove(s);
                break;
            }
        }
    }
    public void update(Student updated) {
        for(Student s : students) {
            if(s.getId() == updated.getId()) {
                s.setName(updated.getName());
                s.setAge(updated.getAge());
                s.setMarks(updated.getMarks());
                break;
            }
        }
    }



}

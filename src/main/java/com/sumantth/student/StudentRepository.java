package com.sumantth.student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {


    public List<Student> findAll() {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();
        List<Student> students = session.createQuery("FROM Student", Student.class).list();
        session.close();
        return students;

    }

    public void save(Student s) {

        Session session  = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(s);
        tx.commit();
        session.close();

    }

    public Student findById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Student s = session.get(Student.class,id);
        session.close();
        return s;


    }

    public  void deleteById(int id){
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();
        Transaction tx = session.beginTransaction();
        Student s = session.get(Student.class,id);
        if(s!= null) session.remove(s);
        tx.commit();
        session.close();
    }
    public void update(Student updated) {
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();
        Transaction tx = session.beginTransaction();
        session.merge(updated);
        tx.commit();
        session.close();
    }



}

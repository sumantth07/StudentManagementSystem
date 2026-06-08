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

    public void save(Student student) {

        Session session = null;
        Transaction tx = null;

        try {

            session = HibernateUtil
                    .getSessionFactory()
                    .openSession();

            tx = session.beginTransaction();

            session.persist(student);

            tx.commit();

        }
        catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }

            e.printStackTrace();
        }
        finally {

            if (session != null) {
                session.close();
            }
        }
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
        int rows = session.createMutationQuery("DELETE FROM Student WHERE id = :id")
                .setParameter("id",id).executeUpdate();
        if(rows == 0){
            throw new RuntimeException(
                    "Student not found with id " + id
            );
        }
        tx.commit();
        session.close();
    }
    public void update(int id,
                              String name,
                              int age,
                              float marks) {

        Session session = null;
        Transaction tx = null;

        try {

            session = HibernateUtil
                    .getSessionFactory()
                    .openSession();

            tx = session.beginTransaction();

            int rows = session.createMutationQuery(
                            """
                            UPDATE Student
                            SET name = :name,
                                age = :age,
                                marks = :marks
                            WHERE id = :id
                            """
                    )
                    .setParameter("name", name)
                    .setParameter("age", age)
                    .setParameter("marks", marks)
                    .setParameter("id", id)
                    .executeUpdate();

            if(rows == 0) {
                throw new RuntimeException(
                        "Student not found with id " + id
                );
            }

            tx.commit();

        } catch(Exception e) {

            if(tx != null)
                tx.rollback();

            throw e;

        } finally {

            if(session != null)
                session.close();
        }
    }
    public Student findByName(String s){

        Session session = null;
        try{
             session = HibernateUtil.getSessionFactory().openSession();
            Student student = session.createQuery("FROM Student WHERE name =:name",Student.class)
                    .setParameter("name",s).getSingleResult();
            return student;
        } catch (RuntimeException e) {
            return null;
        }
        finally {

            if(session != null) {
                session.close();
            }
        }

    }
    public List<Student> sortByName() {

        Session session = null;

        try {

            session = HibernateUtil
                    .getSessionFactory()
                    .openSession();

            return session.createQuery(
                    "FROM Student ORDER BY name ASC",
                    Student.class
            ).getResultList();

        } finally {

            if(session != null) {
                session.close();
            }
        }
    }




}

package com.skillnext1;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.skillnext1.Student;
import com.skillnext1.HibernateUtil;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student stu = new Student(

                "Sathvika",
                 7,
                "ECE"
        );

        session.persist(stu);

        tx.commit();
        session.close();

        System.out.println("Student inserted successfully!");
    }
}


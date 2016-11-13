package com.piechos.hibernate.tutorial;

import com.piechos.hibernate.tutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Creating a new student object...");
            Student student = new Student("Mateusz", "Piechowiak", "piechos@gmail.com");

            session.beginTransaction();

            System.out.println("Saving the student");
            session.save(student);

            session.getTransaction().commit();

            System.out.println("Done");
        } finally {
            sessionFactory.close();
        }
    }
}

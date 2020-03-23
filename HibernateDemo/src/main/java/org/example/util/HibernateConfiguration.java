package org.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import java.io.File;

public class HibernateConfiguration {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {
            return new AnnotationConfiguration().configure(
                    new File(SessionFactory.class.getClassLoader().getResource("hibernate.cfg.xml").getFile())).buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println("initial" + ex);
            throw new ExceptionInInitializerError(ex);

        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();

    }
}




package org.example.main;
import org.example.model.Person;
import org.example.util.HibernateConfiguration;
import org.hibernate.Session;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Session session= HibernateConfiguration.getSessionFactory().openSession();
        session.beginTransaction();
        Person person=new Person();
        person.setName("Punith");
        person.setCountry("IN");
        person.setPhone(91);
        session.save(person);
        session.getTransaction().commit();
        HibernateConfiguration.getSessionFactory().close();
    }
}

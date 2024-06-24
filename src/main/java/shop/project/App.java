package shop.project;

import shop.models.User;


import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction;

import shop.db.SessionFactoryProvider;

public class App 
{
    public static void main( String[] args )
    {
        try{
            SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();

            User user1 = new User("John");
            System.out.println(user1.getId());
            session.save(user1);
            t.commit();

            sessionFactory.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

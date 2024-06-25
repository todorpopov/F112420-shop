package shop.project;

import shop.menus.MainMenu;
import shop.models.Item;


import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction;

import shop.db.SessionFactoryProvider;
import shop.utils.Utilities;

public class App 
{
    public static void main( String[] args )
    {
        // try{
        //     SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        //     Session session = sessionFactory.openSession();
        //     Transaction t = session.beginTransaction();

        //     User user1 = new User("John");
        //     System.out.println(user1.getId());
        //     session.save(user1);
        //     t.commit();

        //     sessionFactory.close();
        // }
        // catch(Exception e){
        //     System.out.println(e);
        // }
        new MainMenu();

    }
}

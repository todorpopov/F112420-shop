package shop.project;

import shop.menus.MainMenu;
import shop.models.Cashier;

import java.util.List;

import org.hibernate.Session; 
import org.hibernate.SessionFactory; 

import shop.db.SessionFactoryProvider;
import shop.db.access.AccessCashier;

public class App 
{
    public static void main( String[] args )
    {
        // SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        // Session session = sessionFactory.getCurrentSession();

        // new MainMenu();
        // Cashier cashier = new Cashier("John", 1000.00);
        // AccessCashier.saveOne(cashier);

        // List<Cashier> list = AccessCashier.getAll();
        // list.forEach(item -> {
        //     System.out.println(item.getName());
        // });

        System.out.println(AccessCashier.getOne(1));
    }

    public static Session currentSession(){
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
}

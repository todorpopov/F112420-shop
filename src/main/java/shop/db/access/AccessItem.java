package shop.db.access;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import shop.db.SessionFactoryProvider;
import shop.models.Item;

public class AccessItem {
    public static List<Item> getAll() {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        List<Item> item = session.createQuery("SELECT a FROM Item a").getResultList();
        sessionFactory.close();
        return item;
    }

    public static Item getOne(int id) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Item item = session.get(Item.class, id);
        sessionFactory.close();
        return item;
    }

    public static void saveOne(Item item) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
        sessionFactory.close();
    }

    public static void deleteOne(int id) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Item item = session.get(Item.class, id);
        session.delete(item);
        transaction.commit();
        sessionFactory.close();
    }
}

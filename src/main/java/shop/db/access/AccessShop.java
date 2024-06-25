package shop.db.access;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import shop.db.SessionFactoryProvider;
import shop.models.Shop;

public class AccessShop {
    public static List<Shop> getAll() {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        List<Shop> shops = session.createQuery("SELECT a FROM Shop a").getResultList();
        sessionFactory.close();
        return shops;
    }

    public static Shop getOne(int id) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Shop shop = session.get(Shop.class, id);
        sessionFactory.close();
        return shop;
    }

    public static void saveOne(Shop shop) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(shop);
        transaction.commit();
        sessionFactory.close();
    }

    public static void deleteOne(int id) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Shop shop = session.get(Shop.class, id);
        session.delete(shop);
        session.flush();
        sessionFactory.close();
    }
}

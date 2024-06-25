package shop.db.access;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import shop.db.SessionFactoryProvider;
import shop.models.Checkout;

public class AccessCheckout {
    public static List<Checkout> getAll() {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        List<Checkout> checkout = session.createQuery("SELECT a FROM Checkout a").getResultList();
        sessionFactory.close();
        return checkout;
    }

    public static Checkout getOne(int id) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Checkout checkout = session.get(Checkout.class, id);
        sessionFactory.close();
        return checkout;
    }

    public static void saveOne(Checkout checkout) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(checkout);
        transaction.commit();
        sessionFactory.close();
    }

    public static void deleteOne(int id) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Checkout checkout = session.get(Checkout.class, id);
        session.delete(checkout);
        session.flush();
        sessionFactory.close();
    }
}

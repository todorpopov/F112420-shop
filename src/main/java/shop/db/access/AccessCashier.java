package shop.db.access;

import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import shop.db.SessionFactoryProvider;
import shop.models.Cashier;

public class AccessCashier{
    public static List<Cashier> getAll() {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        List<Cashier> cashiers = session.createQuery("SELECT a FROM Cashier a").getResultList();
        sessionFactory.close();
        return cashiers;
    }

    public static Cashier getOne(int id) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Cashier cashier = session.get(Cashier.class, id);
        sessionFactory.close();
        return cashier;
    }

    public static void saveOne(Cashier cashier) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cashier);
        transaction.commit();
        sessionFactory.close();
    }

    public static void deleteOne(int id) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Cashier cashier = session.get(Cashier.class, id);
        session.delete(cashier);
        session.flush();
        sessionFactory.close();
    }
}

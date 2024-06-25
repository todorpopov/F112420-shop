package shop.db.access;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import shop.db.SessionFactoryProvider;
import shop.models.Receipt;

public class AccessReceipt {
    public static List<Receipt> getAll() {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        List<Receipt> receipt = session.createQuery("SELECT a FROM Receipt a").getResultList();
        sessionFactory.close();
        return receipt;
    }

    public static Receipt getOne(int id) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Receipt receipt = session.get(Receipt.class, id);
        sessionFactory.close();
        return receipt;
    }

    public static void saveOne(Receipt receipt) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(receipt);
        transaction.commit();
        sessionFactory.close();
    }

    public static void deleteOne(int id) {
        SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
        Session session = sessionFactory.openSession();
        Receipt receipt = session.get(Receipt.class, id);
        session.delete(receipt);
        session.flush();
        sessionFactory.close();
    }
}

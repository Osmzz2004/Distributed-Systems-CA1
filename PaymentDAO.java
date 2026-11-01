package CA1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PaymentDAO {

    protected static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("FitnessPU");

    public PaymentDAO() {
        // TODO Auto-generated constructor stub
    }

    public void persist(Payment payment) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(payment);
        em.getTransaction().commit();
        em.close();
    }

    public void removePayment(Payment payment) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(payment));
        em.getTransaction().commit();
        em.close();
    }

    public Payment merge(Payment payment) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Payment updatedPayment = em.merge(payment);
        em.getTransaction().commit();
        em.close();
        return updatedPayment;
    }

    public List<Payment> getAllPayments() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Payment> payments = new ArrayList<Payment>();
        payments = em.createQuery("from Payment").getResultList();
        em.getTransaction().commit();
        em.close();
        return payments;
    }

    public Payment getPaymentById(int paymentId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Payment payment = em.createQuery(
                "SELECT p FROM Payment p WHERE p.paymentId = :paymentId",
                Payment.class)
                .setParameter("paymentId", paymentId)
                .getSingleResult();
        em.getTransaction().commit();
        em.close();
        return payment;
    }
}

package CA1;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MemberDAO {
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("communityFitnessCenter");

			public MemberDAO() {
				// TODO Auto-generated constructor stub
			}
			 	

			public void persist(Member member) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(member);
				em.getTransaction().commit();
				em.close();
			}
			
			public void removeEmployee(Member member) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				em.remove(em.merge(member));
				em.getTransaction().commit();
				em.close();
			}
			
			public Member merge(Member member) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				Member updatedMember = em.merge(member);
				em.getTransaction().commit();
				em.close();
				return updatedMember;
			}
			
			
			public List<Member> getAllMembers() {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				List<Member> members = new ArrayList<Member>();
				members = em.createQuery("Select * from Member").getResultList();
				em.getTransaction().commit();
				em.close();
				return members;
			}

			public Member getMemberByName(String name) {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				Member m = em.createQuery("SELECT p FROM Member p WHERE p.name = :name", Member.class)
		                .setParameter("name", name)
		                .getSingleResult();
				em.getTransaction().commit();
				em.close();
				return m;
			}
}

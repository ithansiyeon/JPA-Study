package hellojpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hellojpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
//          Member findmember = em.find(Member.class, 1L);
            List<Member> result = em.createQuery("select m from Member as m",Member.class)
                            .setFirstResult(1)
                            .setMaxResults(10)
                            .getResultList();
            for(Member member : result) {
                System.out.println("member.name = " + member.getName());
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            //엔티티 매니저 닫아줘
            em.close();
        }
        //엔티티 매니저 팩토리 닫아줘
        emf.close();
    }
}

package jpql;


import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hellojpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Member member1 = new Member();
            member1.setUsername("회원1");

            member1.setTeam(teamA);
            em.persist(member1);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member2 = new Member();
            member2.setUsername("회원2");

            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");

            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();

            //Flush 자동 호출
            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();

            em.clear();
            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("resultCount = " + resultCount);
            System.out.println("findMember = " + findMember.getAge());
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            System.out.println("e = " + e);
        } finally {
            //엔티티 매니저 닫아줘
            em.close();
        }
        //엔티티 매니저 팩토리 닫아줘
        emf.close();
    }
}

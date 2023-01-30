package hellojpa;

import javax.persistence.*;
import java.util.List;
<<<<<<< Updated upstream
import java.util.Set;
=======
>>>>>>> Stashed changes

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hellojpa");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
<<<<<<< Updated upstream

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity","street","10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1","street","10000"));
            member.getAddressHistory().add(new AddressEntity("old2","street","10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("================ START ================");
            Member findMember = em.find(Member.class, member.getId());

            //homeCity => newCity
//            Address a = findMember.getHomeAddress();

            //치킨 => 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");

//            findMember.getAddressHistory().remove(new Address("old1","street","10000"));
//            findMember.getAddressHistory().add(new Address("newCity1","street","10000"));

=======
            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            //flush -> commit, query
            em.flush();
            //결과 0
            //dbconn.executeQuery("select * from member");

            List<Member> resultList = em.createNativeQuery("select member_id, city, street, zipcode, username from member", Member.class)
                    .getResultList();
            for (Member member1 : resultList) {
                System.out.println("member1 = " + member1);
            }
>>>>>>> Stashed changes
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

    private static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2: " + (m1 instanceof Member));
        System.out.println("m1 == m2: " + (m2 instanceof Member));
    }
}

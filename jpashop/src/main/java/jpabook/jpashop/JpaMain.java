package jpabook.jpashop;

import jpabook.jpashop.domain.Book;
<<<<<<< Updated upstream
=======
import jpabook.jpashop.domain.Item;

>>>>>>> Stashed changes
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hellojpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");

            em.persist(book);

<<<<<<< Updated upstream
=======
            em.createQuery("select i from Item i where type(i) = Book ", Item.class)
                    .getResultList();

>>>>>>> Stashed changes
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

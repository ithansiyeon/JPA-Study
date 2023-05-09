package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {
    //select m from Member m where m.name = ? jpql을 만듬
    List<Member> findByName(String name);
    //제너릭 T가 타입, 두번째가 Id
    //구현체를 스프링 데이터가 알아서 만들어줌
}

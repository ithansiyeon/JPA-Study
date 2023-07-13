package study.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import study.querydsl.entity.Member;

import java.util.List;

//interface 여러개 상속 가능
public interface MemberRepository  extends JpaRepository<Member, Long>, MemberRepositoryCustom, QuerydslPredicateExecutor<Member> {
    //select m from Member m where m.username = username
    //메소드 이름으로 자동으로 만들어 줌
    List<Member> findByUsername(String usernmae);
}

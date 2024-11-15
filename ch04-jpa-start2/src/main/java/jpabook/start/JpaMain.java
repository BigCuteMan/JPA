package jpabook.start;

import javax.persistence.*;
import javax.persistence.*;
import java.util.*;

public class JpaMain {

    public static void main(String[] args) {
        // 엔티티 매니저 팩토리 - 생성
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpabook");

        // 엔티티 매니저 - 생성
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin(); // 트랜잭션 시작
            logic(em); // 비즈니스 로직 실행
            tx.commit(); // 트랜잭션 커밋
        }catch (Exception e) {
            tx.rollback(); // 트랜잭션 - 롤백
        }finally {
            em.close(); // 매니저 종료
        }
        emf.close(); // 팩토리 종료
    }
    // 비즈니스 로직 코드
    private static void logic(EntityManager em) {

        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("지한");
        member.setAge(2);

        //등록
        em.persist(member);

        //수정
        member.setAge(20);

        //한 건 조회
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());

        //목록 조회
        List<Member > members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members.size=" + members.size());

        //삭제
        em.remove(member);
    }
}
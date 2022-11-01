package caps.testing.repository;

import caps.testing.domain.Member;
import caps.testing.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository{

    @PersistenceContext
    private EntityManager em;

    public MemberRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }
}

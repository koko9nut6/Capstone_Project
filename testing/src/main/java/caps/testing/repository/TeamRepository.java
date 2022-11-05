package caps.testing.repository;

import caps.testing.domain.Team;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TeamRepository {

    @PersistenceContext
    EntityManager em;

    public TeamRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Team team){
        em.persist(team);
    }

    public Team findOne(Long id){
        return em.find(Team.class, id);
    }

}

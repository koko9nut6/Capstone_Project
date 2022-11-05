package caps.testing.service;

import caps.testing.domain.Member;
import caps.testing.domain.Team;
import caps.testing.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TeamService {

    private final TeamRepository teamRepository;

    public Long register(Team team){

        teamRepository.save(team);
        return team.getId();
    }
}

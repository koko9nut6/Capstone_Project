package caps.testing;

import caps.testing.domain.Address;
import caps.testing.domain.Administration;
import caps.testing.domain.Member;
import caps.testing.domain.Team;
import caps.testing.dto.MemberDTO;
import caps.testing.repository.MemberRepository;
import caps.testing.repository.TeamRepository;
import caps.testing.service.MemberService;
import caps.testing.service.TeamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class TestingApplicationTests {

    @Autowired
    EntityManager em;
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamService teamService;
    @Autowired
    TeamRepository teamRepository;

    @Test
    @Rollback(value = false)
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("테스트7");
        member.setEmail("agreth@anaer.com");
        member.setPwd("dateth");
        member.setAdmin(Administration.MANAGER);
        member.setPhone("01047526482");

//        Team team = new Team();
//        team.setName("팀2");
//        em.persist(team);

//        member.setTeam(team);
        //when
//        Long saveId = memberService.register(member);

        //then
//        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    @Rollback(value = false)
    public void 팀넣기() throws Exception{
        //given
        Team team = new Team();
        team.setName("팀1");

        //when
        Long saveId = teamService.register(team);

        //then
        assertEquals(team, teamRepository.findOne(saveId));
    }

    @Test
    @Rollback(value = false)
    public void 멤버팀조인() throws Exception{
        Member member = new Member();
        member.setName("테스트9");
        member.setEmail("dfaetawt@anaer.com");
        member.setPwd("ahfahwerq");
        member.setAdmin(Administration.MANAGER);
        member.setPhone("01047526482");

        Team team;
        team = teamService.findOne(2L);
        member.setTeam(team);
        //when
//        Long saveId = memberService.register(member);

        //then
//        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void 중복회원() throws Exception{
        //given
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("일");
        member1.setEmail("123@naver.com");
        member1.setPwd("123");
        member2.setName("이");
        member2.setEmail("123@naver.com");
        member2.setPwd("123");
        //when
//        memberService.register(member1);
//        memberService.register(member2);

        //then

    }

}

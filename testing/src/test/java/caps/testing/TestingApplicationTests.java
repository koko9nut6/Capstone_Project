package caps.testing;

import caps.testing.domain.Address;
import caps.testing.domain.Administration;
import caps.testing.domain.Member;
import caps.testing.dto.MemberDTO;
import caps.testing.repository.MemberRepository;
import caps.testing.service.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class TestingApplicationTests {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("강");
        member.setEmail("kang@anaer.com");
        member.setPwd("dagrtah1");
        member.setAdmin(Administration.WORKER);
        member.setPhone("0102841724");

        //when
        Long saveId = memberService.register(member);

        //then
        Assertions.assertEquals(member, memberRepository.findOne(saveId));
    }

}

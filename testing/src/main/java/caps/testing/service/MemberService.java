package caps.testing.service;

import caps.testing.domain.Member;
import caps.testing.dto.MemberDTO;
import caps.testing.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long register(Member member){
        memberRepository.save(member);
        return member.getId();
    }

    public Member findOne(Long id){
        return memberRepository.findOne(id);
    }
}

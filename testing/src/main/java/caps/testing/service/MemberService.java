package caps.testing.service;

import caps.testing.domain.Member;
import caps.testing.form.AccountForm;
import caps.testing.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long register(AccountForm form){
        Member member = form.toEntity();
        validateDuplicateMember(member);
        String rawPassword = member.getPwd();
        String encPassword = passwordEncoder.encode(rawPassword);
        member.setPwd(encPassword);

        memberRepository.save(member);
        return member.getId();
    }

    public Member findOne(Long id){
        return memberRepository.findOne(id);
    }

    public void validateDuplicateMember(Member member){
        List<Member> findMembers = memberRepository.findByEmail(member.getEmail());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 가입한 회원입니다.");
        }
    }

}

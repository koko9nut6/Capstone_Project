package caps.testing.service;

import caps.testing.domain.Member;
import caps.testing.dto.MemberDTO;
import caps.testing.form.AccountForm;
import caps.testing.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long save(MemberDTO memberDTO){
        validateDuplicateMember(memberDTO.toMember());
        memberDTO.setPwd(passwordEncoder.encode(memberDTO.getPwd()));

        return memberRepository.save(Member.builder()
                .email(memberDTO.getEmail())
                .name(memberDTO.getName())
                .pwd(memberDTO.getPwd())
                .phone(memberDTO.getPhone())
                .admin(memberDTO.getAdmin())
                .build()).getId();
    }

    public void validateDuplicateMember(Member member){
        Optional<Member> findMembers = memberRepository.findByEmail(member.getEmail());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 가입한 회원입니다.");
        }
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

}

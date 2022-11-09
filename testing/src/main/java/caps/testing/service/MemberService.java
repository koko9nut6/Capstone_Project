package caps.testing.service;

import caps.testing.domain.Member;
import caps.testing.dto.MemberDTO;
import caps.testing.dto.MemberSignInRequestDto;
import caps.testing.dto.MemberSignUpRequestDto;
import caps.testing.dto.TokenResponseDto;
import caps.testing.form.AccountForm;
import caps.testing.jwt.JwtTokenProvider;
import caps.testing.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public Long join(MemberSignUpRequestDto memberSignUpRequestDto){
        validateDuplicateMember(memberSignUpRequestDto);
        Member member = memberRepository.save(memberSignUpRequestDto.toMember());
        member.encodePassword(passwordEncoder);
        return member.getId();
    }

    @Transactional
    public TokenResponseDto login(MemberSignInRequestDto requestDto) {
        Optional<Member> member = memberRepository.findByEmail(requestDto.getEmail());

        //TODO : Access Token 과 Refresh Token 을 생성합니다.
        String accessToken = jwtTokenProvider.createAccessToken(member.get().getEmail(), member.get().getAdmin().name());
        String refreshToken = jwtTokenProvider.createRefreshToken();

        //TODO : Refresh Token 을 DB에 저장합니다.
//        member.updateRefreshToken(refreshToken);
        memberRepository.save(member.get());

        return TokenResponseDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public void validateDuplicateMember(MemberSignUpRequestDto memberSignUpRequestDto){
        Optional<Member> findMembers = memberRepository.findByEmail(memberSignUpRequestDto.getEmail());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 가입한 회원입니다.");
        }
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

}

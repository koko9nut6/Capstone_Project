package caps.testing.controller;

import caps.testing.domain.Member;
import caps.testing.dto.MemberDTO;
import caps.testing.dto.MemberSignInRequestDto;
import caps.testing.dto.MemberSignUpRequestDto;
import caps.testing.dto.TokenResponseDto;
import caps.testing.form.AccountForm;
import caps.testing.service.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private final MemberService memberService;

    @PostMapping("/new")
    public Long signUp(@RequestBody @Valid MemberSignUpRequestDto memberSignUpRequestDto){
        return memberService.join(memberSignUpRequestDto);
    }

    @PostMapping("/member/login")
    public TokenResponseDto login(@RequestBody @Valid MemberSignInRequestDto requestDto) {
        return memberService.login(requestDto);
    }

    @GetMapping("/members")
    public List<Member> list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return members;
    }
}

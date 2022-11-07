package caps.testing.controller;

import caps.testing.domain.Member;
import caps.testing.dto.MemberDTO;
import caps.testing.form.AccountForm;
import caps.testing.service.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("member/new")
    public String createForm(Model model){
        model.addAttribute("memberForm", new MemberDTO());
        return "member/createMemberForm.html";
    }

    @PostMapping("member/new")
    public String create(@Valid MemberDTO memberDTO, BindingResult result){

        if(result.hasErrors()){
            return "member/createMemberForm";
        }
        Member member = new Member();
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        member.setPwd(memberDTO.getPwd());
        member.setPhone(memberDTO.getPhone());
        member.setAdmin(memberDTO.getAdmin());

        memberService.save(memberDTO);
        return "redirect:/";

    }

    @GetMapping("/members")
    public List<Member> list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return members;
    }
}

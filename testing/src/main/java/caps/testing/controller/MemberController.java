package caps.testing.controller;

import caps.testing.domain.Member;
import caps.testing.dto.MemberDTO;
import caps.testing.form.AccountForm;
import caps.testing.service.MemberService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MemberController {
    MemberService memberService;

    @GetMapping("/register")
    public String createMemberForm(Model model){
        model.addAttribute("memberForm", new AccountForm());
        return "/register";
    }

    @PostMapping("/register")
    public String createMember(@Valid AccountForm form, BindingResult result){
        memberService.register(form);
        return "redirect:/";
    }
}

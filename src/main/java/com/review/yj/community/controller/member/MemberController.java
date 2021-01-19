package com.review.yj.community.controller.member;

import com.review.yj.community.domain.member.Member;
import com.review.yj.community.dto.MemberSignUpRequestDto;
import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class MemberController {
    @GetMapping("/member/signUp")
    public String signUp() {
        return "member/sign_up";
    }

    @GetMapping("/member/signIn")
    public String signIn() {
        return "member/sign_in";
    }

}

package com.review.yj.community.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/member/signOut")
    public String signOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }

}

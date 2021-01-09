package com.review.yj.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @GetMapping("/member/signUp")
    public String signUp() {
        return "member/sign_up";
    }

    @PostMapping("/member/signUp")
    public String signUp(Model model){
        model.addAttribute("");
        return "redirect:/member/signIn";
    }

    @GetMapping("/member/signIn")
    public String signIn() {
        return "member/sign_in";
    }

    @PostMapping("/member/signIn")
    public String signIn(Model model) {
        return "redirect:/";
    }
}

package com.review.yj.community.controller.member;

import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

    /* Todo: sign 할때 script에서 session 있는지 확인하고 redirect 보내기 */

    @RequestMapping("/member/sign_up")
    public String sign_up() {
        return "member/signup";
    }

    @RequestMapping("/member/sign_in")
    public String sign_in() {
        return "member/signin";
    }

    @GetMapping("/member/sign_out")
    public String sign_out(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        return "index";
    }

}

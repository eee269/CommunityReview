package com.review.yj.community.controller.member;


import com.review.yj.community.domain.member.Member;
import com.review.yj.community.dto.MemberSignUpRequestDto;
import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/member/signUp")
    public Long signUp(@RequestBody MemberSignUpRequestDto requestDto){
        return memberService.signUp(requestDto);
    }


    @PostMapping("/api/member/signIn/{userid}")
    public String signIn(@PathVariable String userid, HttpServletRequest request) {
        // 로그인 세션 설정
        HttpSession session = request.getSession();
        session.setAttribute("userid", userid);

        return "redirect:/";
    }

}

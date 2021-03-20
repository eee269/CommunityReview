package com.review.yj.community.controller.member;

import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;
}

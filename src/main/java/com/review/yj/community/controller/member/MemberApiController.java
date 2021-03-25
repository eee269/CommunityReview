package com.review.yj.community.controller.member;

import com.review.yj.community.controller.dto.MemberDto;
import com.review.yj.community.domain.member.Member;
import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping("/api/member/sign_up")
    public Long sign_up(@RequestBody Member member) {
        return memberService.save(member);
    }

    @PostMapping("/api/member/sign_in")
    public Member sign_in(HttpServletRequest request, @RequestBody Member member) {
        Member result = memberService.findForLogin(member);
        // session 설정
        HttpSession session = request.getSession();
        session.setAttribute("ses_id", result.getMem_id());

        return result;
    }

    @PutMapping("/api/member/update/{mem_id}")
    public Long update(@PathVariable Long mem_id, @RequestBody MemberDto dto) {
        return memberService.update(mem_id, dto);
    }

    @DeleteMapping("/api/member/delete/{mem_id}")
    public void delete(@PathVariable Long mem_id) {
        memberService.delete(mem_id);
    }
}

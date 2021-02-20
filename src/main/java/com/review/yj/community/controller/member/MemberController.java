package com.review.yj.community.controller.member;

import com.review.yj.community.domain.member.Member;
import com.review.yj.community.dto.member.MemberResponseDto;
import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/signUp")
    public String signUp(@SessionAttribute(value = "ses_id", required = false) Long ses_id, HttpServletResponse response) throws Exception {
        String url = "/";
        // 세션 있을 경우, 없을 경우 (접근 제한)
        // PrintWriter 말고 더 간결한 방법이 있을 것 같은데 모르겠음..
        if(ses_id != null){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('잘못된 접근입니다.'); location.href='/';</script>");
            out.flush();
        } else url = "member/sign_up";

        return url;
    }

    @GetMapping("signIn")
    public String signIn(@SessionAttribute(value = "ses_id", required = false) Long ses_id, HttpServletResponse response) throws Exception {
        String url = "/";

        // 세션 있을 경우, 없을 경우 (접근 제한)
        // PrintWriter 말고 더 간결한 방법이 있을 것 같은데 모르겠음..
        if(ses_id != null){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('잘못된 접근입니다.'); location.href='/';</script>");
            out.flush();
        } else url = "member/sign_in";

        return url;
    }

    @GetMapping("/signOut")
    public String signOut(HttpServletRequest request, SessionStatus sessionStatus) {
        HttpSession session = request.getSession();
        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping("/mypage/{ses_id}")
    public ModelAndView myPage(@PathVariable Long ses_id) {
        ModelAndView mav = new ModelAndView();

        if(ses_id == null || ses_id == 0L) {
            mav.setViewName("redirect:/");
        } else {
            MemberResponseDto dto = memberService.findById(ses_id);
            mav.addObject("member", dto);
            mav.setViewName("member/my_page");
        }

        return mav;
    }
}

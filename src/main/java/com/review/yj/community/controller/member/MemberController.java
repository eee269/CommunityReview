package com.review.yj.community.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/signUp")
    public String signUp(@SessionAttribute(value = "id", required = false) Long id, HttpServletResponse response) throws Exception {
        String url = "/";
        // 세션 있을 경우, 없을 경우 (접근 제한)
        // PrintWriter 말고 더 간결한 방법이 있을 것 같은데 모르겠음..
        if(id != null){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('잘못된 접근입니다.'); location.href='/';</script>");
            out.flush();
        } else url = "member/sign_up";

        return url;
    }

    @GetMapping("/signIn")
    public String signIn(@SessionAttribute(value = "id", required = false) Long id, HttpServletResponse response) throws Exception {
        String url = "/";

        // 세션 있을 경우, 없을 경우 (접근 제한)
        // PrintWriter 말고 더 간결한 방법이 있을 것 같은데 모르겠음..
        if(id != null){
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

    @GetMapping("/mypage/{id}")
    public String myPage(@PathVariable Long id) {
        String path = "";
        if (id == null) path="/";
        else path = "redirect:/api/member/mypage/{id}";

        return path;
    }
}

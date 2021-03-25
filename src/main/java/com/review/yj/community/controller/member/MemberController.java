package com.review.yj.community.controller.member;

import com.review.yj.community.service.board.BoardService;
import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;
    private final BoardService boardService;

    @RequestMapping("/member/sign_up")
    public String sign_up(HttpServletRequest request) {
        String url = "member/signup";
        HttpSession session = request.getSession();
        Long ses_id = (Long) session.getAttribute("ses_id");
        if(ses_id != null) {
            url = "redirect:/";
        }
        return url;
    }

    @RequestMapping("/member/sign_in")
    public String sign_in(HttpServletRequest request) {
        String url = "member/signin";
        HttpSession session = request.getSession();
        Long ses_id = (Long) session.getAttribute("ses_id");
        if(ses_id != null) {
            url = "redirect:/";
        }
        return url;
    }

    @GetMapping("/member/sign_out")
    public String sign_out(@Param("ses_id") Long ses_id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(ses_id == (Long) session.getAttribute("ses_id"))     session.invalidate();
        return "index";
    }

    @RequestMapping("/member/mypage")
    public String mypage(@Param("ses_id")Long ses_id, Model model) {
        model.addAttribute("member", memberService.findById(ses_id));
        model.addAttribute("boardList", boardService.findAllByMem_id(ses_id));
        return "member/mypage";
    }

    @RequestMapping("/member/update")
    public String update(@Param("mem_id") Long mem_id, Model model) {
        model.addAttribute("member", memberService.findById(mem_id));
        return "member/update";
    }

}

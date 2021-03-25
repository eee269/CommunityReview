package com.review.yj.community.controller.board;

import com.review.yj.community.domain.board.Board;
import com.review.yj.community.service.board.BoardService;
import com.review.yj.community.service.board.ReplyService;
import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;
    private final MemberService memberService;
    private final ReplyService replyService;

    @RequestMapping("board")
    public String board(Model model) {
        model.addAttribute("boardList", boardService.findAllDesc());

        return "board/list";
    }

    @RequestMapping("board/{brd_category}")
    public String board(@PathVariable int brd_category, Model model) {
        model.addAttribute("boardList", boardService.findByCtg(brd_category));

        return "board/list";
    }

    @RequestMapping("board/member")
    public String board(@Param("mem_id") Long mem_id, Model model) {
        model.addAttribute("boardList", boardService.findAllByMem_id(mem_id));

        return "board/list";
    }

    @RequestMapping("board/save")
    public String save_form(Model model, HttpServletRequest request) {
        String url = "board/save";

        HttpSession session = request.getSession();
        Long ses_id = (Long) session.getAttribute("ses_id");
        if(ses_id == null) {
            url = "redirect:/member/sign_in";
        } else {
            model.addAttribute("member", memberService.findById(ses_id));
        }

        return url;
    }

    @RequestMapping("board/update")
    public String update_form(@Param("brd_id") Long brd_id, Model model, HttpServletRequest request) {
        String url = "board/update";

        HttpSession session = request.getSession();
        Long ses_id = (Long) session.getAttribute("ses_id");
        if(ses_id == null) {
            url = "redirect:/member/sign_in";
        } else {
            model.addAttribute("board", boardService.findById(brd_id));
            model.addAttribute("member", memberService.findById(ses_id));
        }

        return url;
    }

}

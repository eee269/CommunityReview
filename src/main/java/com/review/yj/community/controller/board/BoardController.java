package com.review.yj.community.controller.board;

import com.review.yj.community.domain.board.Board;
import com.review.yj.community.service.board.BoardService;
import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;
    private final MemberService memberService;
//    private final ReplyService replyService;

    @RequestMapping("board")
    public String board(Model model) {
        model.addAttribute("boardList", boardService.findAll());

        return "board/list";
    }

    @RequestMapping("board/save")
    public String save_form() {
        return "board/save";
    }

    @RequestMapping("board/update")
    public String update_form(@Param("brd_id") Long brd_id, Model model, HttpServletRequest request) {
        model.addAttribute("board", boardService.findById(brd_id));
//        model.addAttribute("reply", replyService.findByBrd_id(brd_id));
        HttpSession session = request.getSession();
        Long ses_id = (Long) session.getAttribute("ses_id");
//        model.addAttribute("member", memberService.findById(ses_id));

        return "board/update";
    }

}

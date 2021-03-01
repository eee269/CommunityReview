package com.review.yj.community.controller.board;

import com.review.yj.community.domain.board.Board;
import com.review.yj.community.dto.board.BoardListResponseDto;
import com.review.yj.community.service.board.BoardService;
import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    private final MemberService memberService;

    @GetMapping("/save")
    public String save(@SessionAttribute("ses_id") Long ses_id, Model model) {
        String mem_nickname = memberService.findByIdForNickname(ses_id);

        model.addAttribute("mem_nickname", mem_nickname);
        return "board/save";
    }

    @GetMapping("/")
    public String board_list(Model model) {
        model.addAttribute("board", boardService.findAllDesc());

        return "board/list";
    }

    @GetMapping("/update/{brd_id}")
    public ModelAndView update(@PathVariable Long brd_id) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("board", boardService.findById(brd_id));
        mav.setViewName("board/update");
        return mav;
    }


}

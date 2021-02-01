package com.review.yj.community.controller.board;

import com.review.yj.community.dto.member.MemberResponseDto;
import com.review.yj.community.service.board.BoardService;
import com.review.yj.community.service.member.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    private final MemberService memberService;

    @GetMapping("/save")
    public String save(@SessionAttribute("id") Long id, Model model) {
        String mem_nickname = memberService.findByIdForNickname(id);

        model.addAttribute("mem_nickname", mem_nickname);
        return "board/save";
    }

    @GetMapping("/")
    public String board_list(Model model) {
        model.addAttribute("board", boardService.findAllDesc());
        return "board/list";
    }

}

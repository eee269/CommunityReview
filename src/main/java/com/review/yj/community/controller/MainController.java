package com.review.yj.community.controller;

import com.review.yj.community.domain.board.Board;
import com.review.yj.community.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final BoardService boardService;

    @RequestMapping("/")
    public String main(Model model) {
//        Page<Board> boardList = boardService.findRecent();
        List<Board> boardList = boardService.findAllDesc();
        model.addAttribute("boardList", boardList);

        return "index";
    }
}

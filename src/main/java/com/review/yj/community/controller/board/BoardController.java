package com.review.yj.community.controller.board;

import com.review.yj.community.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;
}

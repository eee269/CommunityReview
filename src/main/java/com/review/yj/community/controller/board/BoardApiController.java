package com.review.yj.community.controller.board;

import com.review.yj.community.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;
}

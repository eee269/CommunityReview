package com.review.yj.community.controller.board;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@NoArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/save")
    public String save() {
        return "board/save";
    }

    @GetMapping("/")
    public String board_list() {
        return "board/list";
    }
}

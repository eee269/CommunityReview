package com.review.yj.community.controller.board;

import com.review.yj.community.dto.board.BoardSaveRequestDto;
import com.review.yj.community.service.board.BoardService;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@NoArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardApiController {

    private BoardService boardService;

    @PostMapping("/save/{mem_id}")
    public Long save(@PathVariable Long mem_id, @RequestBody BoardSaveRequestDto requestDto) {
        return boardService.save(mem_id, requestDto);
    }

//    @PostMapping("/list")
//    public Long list(@RequestBody BoardListRequestDto requestDto) {
//        return boardService.list(requestDto);
//    }

//    @PostMapping("/detail/{brd_id}")
//    public Long detail() {
//        return boardService.detail();
//    }
}

package com.review.yj.community.controller.board;

import com.review.yj.community.domain.board.Board;
import com.review.yj.community.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    // bean 주입 안됨..
//    private final BoardService boardService;
//    @Autowired
//    public BoardApiController(BoardService boardService) {
//        this.boardService = boardService;
//    }
//    @Autowired
    private final BoardService boardService;

    @PostMapping("api/board/save")
    public Long save(@RequestBody Board board) {
        return boardService.save(board);
    }

    @GetMapping("api/board/detail")
    public ModelAndView detail(@Param("brd_id") long brd_id) {
        ModelAndView mav = new ModelAndView();

        Board board = boardService.findById(brd_id);

        mav.addObject("board", board);
        mav.setViewName("board/detail");

        return mav;
    }

    @PutMapping("api/board/update")
    public Long update(@RequestBody Board board) {
        return boardService.update(board)<=0? 0L : board.getBrd_id();
    }

    @DeleteMapping("api/board/delete/{brd_id}")
    public void delete(@PathVariable Long brd_id) {
        boardService.delete(brd_id);
    }
}

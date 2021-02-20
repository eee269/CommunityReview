package com.review.yj.community.controller.board;

import com.review.yj.community.dto.board.BoardListResponseDto;
import com.review.yj.community.dto.board.BoardSaveRequestDto;
import com.review.yj.community.dto.board.BoardUpdateRequestDto;
import com.review.yj.community.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("save/{ses_id}")
    public Long save(@PathVariable Long ses_id, @RequestBody BoardSaveRequestDto requestDto) {
        return boardService.save(ses_id, requestDto);   // session id 없어도 될 것 같은데
    }

    @GetMapping("detail/{brd_id}")
    public ModelAndView detail(@PathVariable Long brd_id) {
        ModelAndView mav = new ModelAndView();
        BoardListResponseDto dto = boardService.findById(brd_id);

        mav.setViewName("board/detail");
        mav.addObject("board", dto);

        return mav;
    }

    @PutMapping("update/{brd_id}")
    public Long update(@PathVariable Long brd_id, @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.update(brd_id, requestDto);
    }

    @DeleteMapping("delete/{brd_id}")
    public Long delete(@PathVariable Long brd_id) {
        boardService.delete(brd_id);
        return brd_id;
    }
}

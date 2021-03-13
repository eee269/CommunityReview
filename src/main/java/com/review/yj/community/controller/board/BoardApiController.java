package com.review.yj.community.controller.board;

import com.review.yj.community.domain.board.Reply;
import com.review.yj.community.dto.board.*;
import com.review.yj.community.service.board.BoardService;
import com.review.yj.community.service.board.ReplyService;
import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardApiController {

    private final BoardService boardService;
    private final ReplyService replyService;

    private final MemberService memberService;

    @PostMapping("save/{ses_id}")
    public Long save(@PathVariable Long ses_id, @RequestBody BoardSaveRequestDto requestDto) {
        return boardService.save(ses_id, requestDto);   // session id 없어도 될 것 같은데
    }

//    @GetMapping("detail/{brd_id}")
//    public ModelAndView detail(@PathVariable Long brd_id, HttpSession session) {
//        ModelAndView mav = new ModelAndView();
//        BoardListResponseDto dto = boardService.findById(brd_id);
//
//        mav.setViewName("board/detail");
//        mav.addObject("board", dto);
//
//        if (session != null) {
//            Long ses_id = (Long) session.getAttribute("ses_id");
//            mav.addObject("mem_nickname", memberService.findByIdForNickname(ses_id));
//        }
//
//        List<ReplyListResponseDto> replyList = replyService.findAllByBrd_id(brd_id);
//        if (replyList != null) {
//            mav.addObject("replyList", replyList);
//        }
//
//        return mav;
//    }

    @GetMapping("detail")
    public ModelAndView detail(@RequestParam("brd_id") Long brd_id, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        BoardListResponseDto dto = boardService.findById(brd_id);

        mav.setViewName("board/detail");
        mav.addObject("board", dto);

        if (session != null) {
            Long ses_id = (Long) session.getAttribute("ses_id");
            mav.addObject("mem_nickname", memberService.findByIdForNickname(ses_id));
        }

        List<ReplyListResponseDto> replyList = replyService.findAllByBrd_id(brd_id);
        if (replyList != null) {
            mav.addObject("replyList", replyList);
        }

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

    // 댓글
    @PostMapping("reply/save/{ses_id}")
    public Long reply_save(@PathVariable Long ses_id, @RequestBody ReplySaveRequestDto requestDto) {

        return replyService.save(requestDto);
    }
}

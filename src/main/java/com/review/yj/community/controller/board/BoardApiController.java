package com.review.yj.community.controller.board;

import com.review.yj.community.domain.board.Board;
import com.review.yj.community.domain.board.Reply;
import com.review.yj.community.service.board.BoardService;
import com.review.yj.community.service.board.ReplyService;
import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
    private final MemberService memberService;
    private final ReplyService replyService;

    @PostMapping("api/board/save")
    public Long save(@RequestBody Board board) {
        return boardService.save(board);
    }

    @GetMapping("api/board/detail")
    public ModelAndView detail(@Param("brd_id") long brd_id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        boardService.addViewCnt(brd_id);
        Board board = boardService.findById(brd_id);
        List<Reply> replyList = replyService.findByBrd_id(brd_id);

        mav.addObject("board", board);

        // reply 작성하기 위해 session에 해당하는 회원 정보 넘겨주기
        HttpSession session = request.getSession();
        Long ses_id = (Long) session.getAttribute("ses_id");
        if(ses_id != null) {
            mav.addObject("member", memberService.findById(ses_id));
        } else {
            mav.addObject("member", null);
        }

        mav.addObject("replyList", replyList);


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

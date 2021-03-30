package com.review.yj.community.controller.board;

import com.review.yj.community.controller.dto.BoardDto;
import com.review.yj.community.controller.dto.ReplyDto;
import com.review.yj.community.domain.board.Board;
import com.review.yj.community.domain.board.Reply;
import com.review.yj.community.service.board.BoardService;
import com.review.yj.community.service.board.ReplyService;
import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONArray;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

        if(board.getBrd_category() == 3) {
            BoardDto dto = BoardDto.builder()
                    .brd_id(board.getBrd_id())
                    .mem_nickname("익명")
                    .mem_id(board.getMem_id())
                    .brd_category(3)
                    .brd_content(board.getBrd_content())
                    .brd_title(board.getBrd_title())
                    .brd_cnt(board.getBrd_cnt())
                    .createdDate(board.getCreatedDate())
                    .modifiedDate(board.getModifiedDate())
                    .build();
            mav.addObject("board", dto);

            List<ReplyDto> dtoList = new ArrayList<>();
            for (Reply r :
                    replyList) {
                ReplyDto replyDto = ReplyDto.builder()
                        .rep_id(r.getRep_id())
                        .rep_content(r.getRep_content())
                        .brd_id(r.getBrd_id())
                        .createdDate(r.getCreatedDate())
                        .mem_id(r.getMem_id())
                        .mem_nickname("익명")
                        .rep_depth(r.getRep_depth())
                        .rep_parent(r.getRep_parent())
                        .rep_seq(r.getRep_seq())
                        .build();
                dtoList.add(replyDto);
            }
            mav.addObject("replyList", dtoList);
        } else {
            mav.addObject("board", board);
            mav.addObject("replyList", replyList);
        }

        // reply 작성하기 위해 session에 해당하는 회원 정보 넘겨주기
        HttpSession session = request.getSession();
        Long ses_id = (Long) session.getAttribute("ses_id");
        if(ses_id != null) {
            mav.addObject("member", memberService.findById(ses_id));
        } else {
            mav.addObject("member", null);
        }

        mav.setViewName("board/detail");

        return mav;
    }

    @PutMapping("api/board/update/{brd_id}")
    public Long update(@PathVariable Long brd_id, @RequestBody BoardDto dto) {
        return boardService.update(brd_id, dto);
    }

    @DeleteMapping("api/board/delete/{brd_id}")
    public void delete(@PathVariable Long brd_id) {
        boardService.delete(brd_id);
    }
}

package com.review.yj.community.controller.board;

import com.review.yj.community.controller.dto.ReplyDto;
import com.review.yj.community.domain.board.Reply;
import com.review.yj.community.service.board.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReplyApiController {
    private final ReplyService replyService;

    @PostMapping("api/reply/save")
    public Long save(@RequestBody ReplyDto dto) {
        return replyService.save(dto);
    }

    @PutMapping("api/reply/update/{rep_id}")
    public Long update(@PathVariable Long rep_id, @RequestBody ReplyDto dto) {
        return replyService.update(rep_id, dto);
    }

    @DeleteMapping("api/reply/delete/{rep_id}")
    public void delete(@PathVariable Long rep_id) {
        replyService.delete(rep_id);
    }
}

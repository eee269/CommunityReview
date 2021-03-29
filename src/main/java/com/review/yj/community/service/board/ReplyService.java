package com.review.yj.community.service.board;

import com.review.yj.community.controller.dto.ReplyDto;
import com.review.yj.community.domain.board.Reply;
import com.review.yj.community.domain.board.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    public List<Reply> findByBrd_id(long brd_id) {
        return replyRepository.findByBrd_id(brd_id);
    }

    public Long save(Reply reply) {
        int seq = 0;
        if(reply.getRep_seq() == 0) {
            seq = replyRepository.findMaxSeq() + 1;
            reply = Reply.builder()
                    .rep_seq(seq)
                    .mem_nickname(reply.getMem_nickname())
                    .mem_id(reply.getMem_id())
                    .brd_id(reply.getBrd_id())
                    .rep_content(reply.getRep_content())
                    .rep_depth(reply.getRep_depth())
                    .rep_parent(reply.getRep_parent())
                    .build();
        } else {
            replyRepository.addSeq(reply.getRep_seq());
        }
        Long rep_id = replyRepository.save(reply).getRep_id();

        return rep_id;
    }

    public Long update(ReplyDto dto) {
        Reply reply = replyRepository.findById(dto.getRep_id())
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));
        reply.update(dto.getRep_content());
        return reply.getRep_id();
    }

    public void delete(Long rep_id) {
        replyRepository.subSeq(rep_id);
        replyRepository.deleteById(rep_id);
    }
}

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
        }
        Long rep_id = replyRepository.save(reply).getRep_id();
        replyRepository.updateSeq(rep_id, reply.getRep_seq());

        return rep_id;
    }

    public int update(Reply reply) {
        return replyRepository.update(reply.getRep_id(), reply.getRep_content());
    }

    public void delete(Long rep_id) {
        replyRepository.deleteById(rep_id);
    }
}

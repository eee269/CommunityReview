package com.review.yj.community.service.board;

import com.review.yj.community.controller.dto.ReplyDto;
import com.review.yj.community.domain.board.Reply;
import com.review.yj.community.domain.board.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    public List<Reply> findByBrd_id(long brd_id) {
        return replyRepository.findByBrd_id(brd_id);
    }

    @Transactional
    public Long save(ReplyDto dto) {
        int seq = 0;
        Reply reply;
        if(dto.getRep_seq() == 0) {
            seq = replyRepository.findMaxSeq() + 1;

            reply = Reply.builder()
                    .rep_seq(seq)
                    .mem_nickname(dto.getMem_nickname())
                    .mem_id(dto.getMem_id())
                    .brd_id(dto.getBrd_id())
                    .rep_content(dto.getRep_content())
                    .rep_depth(dto.getRep_depth()+1)
                    .rep_parent(dto.getRep_parent())
                    .build();
        } else {
            replyRepository.addSeq(dto.getRep_seq()+1);

            reply = Reply.builder()
                    .rep_seq(dto.getRep_seq())
                    .mem_nickname(dto.getMem_nickname())
                    .mem_id(dto.getMem_id())
                    .brd_id(dto.getBrd_id())
                    .rep_content(dto.getRep_content())
                    .rep_depth(dto.getRep_depth()+1)
                    .rep_parent(dto.getRep_parent())
                    .build();
        }


        Long rep_id = replyRepository.save(reply).getRep_id();

        return rep_id;
    }

    @Transactional
    public Long update(Long rep_id, ReplyDto dto) {
        Reply reply = replyRepository.findById(rep_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));
        reply.update(dto.getRep_content());
        return rep_id;
    }

    @Transactional
    public void delete(Long rep_id) {
        replyRepository.subSeq(rep_id);
        replyRepository.deleteById(rep_id);
    }
}

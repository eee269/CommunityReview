package com.review.yj.community.service.board;

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
        return replyRepository.save(reply).getRep_id();
    }

    public int update(Reply reply) {
        return replyRepository.update(reply.getRep_id(), reply.getRep_content());
    }

    public void delete(Long rep_id) {
        replyRepository.deleteById(rep_id);
    }
}

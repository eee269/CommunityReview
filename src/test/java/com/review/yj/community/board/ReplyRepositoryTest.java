package com.review.yj.community.board;

import com.review.yj.community.domain.board.Reply;
import com.review.yj.community.domain.board.ReplyRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyRepositoryTest {
    @Autowired
    ReplyRepository replyRepository;

    @After
    public void cleanup() { replyRepository.deleteAll(); }

    @Test
    public void 댓글저장() {
        String rep_content = "내용";
        Long parent = null;

        replyRepository.save(Reply.builder()
                .rep_content(rep_content)
                .rep_seq(1)
                .mem_id(27L)
                .brd_id(8L)
                .rep_parent(parent == null ? 0L : parent)
                .build()
        );

        List<Reply> list = replyRepository.findAll();

        Reply reply = list.get(0);
        assertThat(reply.getRep_content()).isEqualTo(rep_content);
    }
}

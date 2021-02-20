package com.review.yj.community.board;

import com.review.yj.community.domain.board.Board;
import com.review.yj.community.domain.board.BoardRepository;
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
public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @After
    public void cleanup() {
        boardRepository.deleteAll();
    }

    @Test
    public void 게시글_저장_불러오기() {
        String title = "테스트 제목";
        String content = "본문";

        boardRepository.save(Board.builder()
                .brd_title(title)
                .brd_content(content)
                .mem_id(27L)
                .mem_nickname("test")
                .build());

        List<Board> boardList = boardRepository.findAll();

        Board board = boardList.get(0);
        assertThat(board.getBrd_title()).isEqualTo(title);
        assertThat(board.getBrd_content()).isEqualTo(content);
    }
}

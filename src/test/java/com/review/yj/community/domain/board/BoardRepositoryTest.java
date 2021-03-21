package com.review.yj.community.domain.board;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @After
    public void after() {
        boardRepository.deleteAll();
    }

    @Test
    public void test() {
        // given
        String title = "제목";
        String content = "내용";


        // when
        boardRepository.save(
                Board.builder()
                        .brd_title(title)
                        .brd_content(content)
                        .mem_id(27L)
                        .mem_nickname("test")
                        .build());

        // then
        List<Board> boardList = boardRepository.findAll();
        Board board = boardList.get(boardList.size() -1);

        assertThat(board.getBrd_title()).isEqualTo(title);
        assertThat(board.getBrd_content()).isEqualTo(content);

    }
}

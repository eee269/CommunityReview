package com.review.yj.community.controller.board;

import com.review.yj.community.domain.board.BoardRepository;
import com.review.yj.community.service.board.BoardService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardApiControllerTest {
    @Autowired
    private BoardService boardService;

    @After
    public void after() {
//        boardService.deleteAll();
    }

    @Test
    public void test() {
        // given


        // when


        // then



    }
}

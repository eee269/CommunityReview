//package com.review.yj.community.controller.board;
//
//import com.review.yj.community.domain.board.Board;
//import com.review.yj.community.domain.board.BoardRepository;
//import com.review.yj.community.service.board.BoardService;
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
////@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class BoardApiControllerTest {
//    @LocalServerPort
//    private int port;
//    @Autowired
//    private TestRestTemplate restTemplate;
//    @Autowired
////    private BoardService boardService;
//    private BoardRepository boardRepository;
//
//
//    @After
//    public void after() {
////        boardService.deleteAll();
//        boardRepository.deleteAll();
//    }
//
//    @Test
//    public void save() {
//        // given
//        String title = "제목";
//        String content = "내용";
//
//        String url = "http://localhost:" + port + "/api/board/save";
//
//        // when
//        ResponseEntity<Long> entity = restTemplate.postForEntity(url,
//                Board.builder()
//                        .brd_title(title)
//                        .brd_content(content)
//                        .mem_id(27L)
//                        .mem_nickname("test")
//                        .build(), Long.class);
//
//        // then
//
//        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(entity.getBody()).isGreaterThan(0L);
//
//        List<Board> boardList = boardRepository.findAll();
//        Board board = boardList.get(boardList.size() -1);
//
//        assertThat(board.getBrd_title()).isEqualTo(title);
//        assertThat(board.getBrd_content()).isEqualTo(content);
//
//
//    }
//}

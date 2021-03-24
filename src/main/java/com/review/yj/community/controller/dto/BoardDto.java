package com.review.yj.community.controller.dto;

import com.review.yj.community.domain.board.Board;
import lombok.*;

import java.time.LocalDateTime;

//@Setter
@Getter
@NoArgsConstructor
@ToString
public class BoardDto {
    private Long brd_id;
    private String brd_title;
    private String brd_content;
    private Long mem_id;
    private String mem_nickname;
    private int brd_cnt;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private int brd_category;

//    public Board toEntity() {
//        return Board.builder()
//                .brd_title(brd_title)
//                .brd_content(brd_content)
//                .brd_cnt(brd_cnt)
//                .mem_id(mem_id)
//                .mem_nickname(mem_nickname)
//                .build();
//    }

    @Builder
    public BoardDto(Long brd_id, String brd_title, String brd_content, Long mem_id, String mem_nickname, int brd_cnt, LocalDateTime createdDate, LocalDateTime modifiedDate, int brd_category) {
        this.brd_id = brd_id;
        this.brd_title = brd_title;
        this.brd_content = brd_content;
        this.mem_id = mem_id;
        this.mem_nickname = mem_nickname;
        this.brd_cnt = brd_cnt;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.brd_category = brd_category;
    }
}

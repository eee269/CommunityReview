package com.review.yj.community.dto.board;

import com.review.yj.community.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
//@NoArgsConstructor
public class BoardSaveRequestDto {

    private int brd_category;
    private String brd_title;
    private String brd_content;
    private Long mem_id;
    private String mem_nickname;

    @Builder
    public BoardSaveRequestDto(int brd_category, String brd_title,
                               String brd_content, Long mem_id, String mem_nickname) {
        this.brd_category = brd_category;
        this.brd_title = brd_title;
        this.brd_content = brd_content;
        this.mem_id = mem_id;
        this.mem_nickname = mem_nickname;
    }

    public Board toEntity(String nickname) {
        return Board.builder()
                .mem_id(mem_id)
                .brd_category(brd_category)
                .brd_title(brd_title)
                .brd_content(brd_content)
                .mem_nickname(nickname)
                .build();
    }
}

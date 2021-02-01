package com.review.yj.community.dto.board;

import com.review.yj.community.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {

    private int brd_category;
    private String brd_title;
    private String brd_content;
    private Long mem_id;
    private String mem_nickname;
    private String brd_file;
    private String brd_image;

    @Builder
    public BoardSaveRequestDto(int brd_category, String brd_title, String brd_content, Long mem_id, String mem_nickname, String brd_file, String brd_image) {
        this.brd_category = brd_category;
        this.brd_title = brd_title;
        this.brd_content = brd_content;
        this.mem_id = mem_id;
        this.mem_nickname = mem_nickname;
        this.brd_file = brd_file;
        this.brd_image = brd_image;
    }

    public Board toEntity(String nickname) {
        return Board.builder()
                .mem_id(mem_id)
                .brd_category(brd_category)
                .brd_title(brd_title)
                .brd_content(brd_content)
                .mem_nickname(nickname)
                .brd_file(brd_file)
                .brd_image(brd_image)
                .build();
    }
}

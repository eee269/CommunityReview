package com.review.yj.community.dto.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
//    private int brd_category;
    private String brd_title;
    private String brd_content;

    @Builder
    public BoardUpdateRequestDto(String brd_title, String brd_content) {
        this.brd_title = brd_title;
        this.brd_content = brd_content;
    }
}

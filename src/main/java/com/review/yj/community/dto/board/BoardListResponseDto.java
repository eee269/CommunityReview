package com.review.yj.community.dto.board;

import com.review.yj.community.domain.board.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardListResponseDto {
    private Long brd_id;
    private String brd_title;
    private String brd_content;
    private String mem_nickname;
    private Long mem_id;
    private int brd_category;
    private LocalDateTime modifiedDate;
    private String brd_image;
    private int brd_viewCnt;

    public BoardListResponseDto(Board entity) {
        this.brd_id = entity.getBrd_id();
        this.brd_title = entity.getBrd_title();
        this.brd_content = entity.getBrd_content();
        this.mem_nickname = entity.getMem_nickname();
        this.mem_id = entity.getMem_id();
        this.brd_category = entity.getBrd_category();
        this.modifiedDate = entity.getModifiedDate();
        this.brd_image = entity.getBrd_image();
        this.brd_viewCnt = entity.getBrd_viewCnt();
    }
}

package com.review.yj.community.dto.board;

import com.review.yj.community.domain.board.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardListResponseDto {
    private long brd_id;
    private String brd_title;
    private String brd_content;
    private String mem_nickname;
    private Long mem_id;
    private int brd_category;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private int brd_view_cnt;
//    private String brd_image;

    public BoardListResponseDto(Board entity) {
        this.brd_id = entity.getBrd_id();
        this.brd_title = entity.getBrd_title();
        this.brd_content = entity.getBrd_content();
        this.mem_nickname = entity.getMem_nickname();
        this.mem_id = entity.getMem_id();
        this.brd_category = entity.getBrd_category();
        this.createdDate = entity.getCreateDate();
        this.modifiedDate = entity.getModifiedDate();
//        this.brd_view_cnt = entity.getBrd_view_cnt();
//        this.brd_image = entity.getBrd_image();
    }
}

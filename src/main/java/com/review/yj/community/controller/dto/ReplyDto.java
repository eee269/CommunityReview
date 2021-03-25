package com.review.yj.community.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ReplyDto {
    private Long rep_id;
    private String rep_content;
    private Long rep_parent;
    private Long brd_id;
    private Long mem_id;
    private int rep_depth;
    private int rep_seq;
    private String mem_nickname;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public ReplyDto(Long rep_id, String rep_content, Long rep_parent, Long brd_id, Long mem_id, int rep_depth, int rep_seq, String mem_nickname, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.rep_id = rep_id;
        this.rep_content = rep_content;
        this.rep_parent = rep_parent;
        this.brd_id = brd_id;
        this.mem_id = mem_id;
        this.rep_depth = rep_depth;
        this.rep_seq = rep_seq;
        this.mem_nickname = mem_nickname;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}

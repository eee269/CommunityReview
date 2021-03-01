package com.review.yj.community.dto.board;

import com.review.yj.community.domain.board.Reply;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReplyListResponseDto {
    private long rep_id;
    private String rep_content;
    private String mem_nickname;
    private long mem_id;
    private long brd_id;
    private LocalDateTime create_date;
    private LocalDateTime modified_date;

    public ReplyListResponseDto(Reply reply) {
        this.rep_id = reply.getRep_id();
        this.rep_content = reply.getRep_content();
        this.mem_nickname = reply.getMem_nickname();
        this.mem_id = reply.getMem_id();
        this.brd_id = reply.getBrd_id();
        this.create_date = reply.getCreateDate();
        this.modified_date = reply.getModifiedDate();
    }
}

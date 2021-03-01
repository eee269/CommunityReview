package com.review.yj.community.dto.board;

import com.review.yj.community.domain.board.Reply;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReplySaveRequestDto {
    private String rep_content;
    private Long rep_parent;
    private int rep_depth;
    private int rep_seq;
    private Long brd_id;
    private Long mem_id;
    private String mem_nickname;

    @Builder
    public ReplySaveRequestDto(String rep_content, Long rep_parent, int rep_depth, int rep_seq, Long brd_id, Long mem_id, String mem_nickname) {
        this.rep_content = rep_content;
        this.rep_parent = rep_parent;
        this.rep_depth = rep_depth;
        this.rep_seq = rep_seq;
        this.brd_id = brd_id;
        this.mem_id = mem_id;
        this.mem_nickname = mem_nickname;
    }

    public Reply toEntity() {
        return Reply.builder()
                .brd_id(brd_id)
                .mem_id(mem_id)
                .rep_content(rep_content)
                .rep_depth(rep_depth)
                .rep_parent(rep_parent)
                .rep_seq(rep_seq)
                .mem_nickname(mem_nickname)
                .build();
    }
}

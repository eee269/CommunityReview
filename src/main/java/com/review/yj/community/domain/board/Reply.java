package com.review.yj.community.domain.board;

import com.review.yj.community.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Reply extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rep_id;

    private String rep_content;
    private Long rep_parent;
    private int rep_depth;
    private int rep_seq;

    private String mem_nickname;
    private Long mem_id;
    private Long brd_id;

    @Builder
    public Reply(Long rep_id, String rep_content, Long rep_parent, int rep_depth, int rep_seq, Long mem_id, Long brd_id, String mem_nickname) {
        this.rep_id = rep_id;
        this.rep_content = rep_content;
        this.rep_parent = rep_parent;
        this.rep_depth = rep_depth;
        this.rep_seq = rep_seq;
        this.mem_id = mem_id;
        this.brd_id = brd_id;
        this.mem_nickname = mem_nickname;
    }
}

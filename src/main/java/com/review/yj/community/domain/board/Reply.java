package com.review.yj.community.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Reply extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rep_id;

    private String rep_content;
    private Long brd_id;
    private Long mem_id;
    private String mem_nickname;
    private Long rep_parent;    // 대댓글을 작성할 때 달릴 댓글의 id
    private int rep_depth;      // 댓글? 대댓글? 대대댓글? 대대대댓글?
    private int rep_seq;        // 댓글이 정렬될 순서

    @Builder
    public Reply(String rep_content, Long brd_id, Long mem_id, String mem_nickname, Long rep_parent, int rep_depth, int rep_seq) {
        this.rep_content = rep_content;
        this.brd_id = brd_id;
        this.mem_id = mem_id;
        this.mem_nickname = mem_nickname;
        this.rep_parent = rep_parent;
        this.rep_depth = rep_depth;
        this.rep_seq = rep_seq;
    }

    public void update(String rep_content) {
        this.rep_content = rep_content;
    }
}

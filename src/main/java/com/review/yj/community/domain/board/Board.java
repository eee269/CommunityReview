package com.review.yj.community.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long brd_id;

    private String brd_title;
    private String brd_content;
    private long mem_id;
    private String mem_nickname;

    @Builder
    public Board(String brd_title, String brd_content, long mem_id, String mem_nickname) {
        this.brd_title = brd_title;
        this.brd_content = brd_content;
        this.mem_id = mem_id;
        this.mem_nickname = mem_nickname;
    }
}

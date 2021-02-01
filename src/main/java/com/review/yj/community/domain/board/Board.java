package com.review.yj.community.domain.board;

import com.review.yj.community.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brd_id;

    private String brd_title;
    private String brd_content;
    private Long mem_id;
    private int brd_category;
    private String mem_nickname;
    private String brd_file;
    private String brd_image;
    private int brd_viewCnt;


    @Builder
    public Board(Long brd_id, String brd_title, String brd_content, Long mem_id, int brd_category, String mem_nickname, String brd_file, String brd_image, int brd_viewCnt) {
        this.brd_id = brd_id;
        this.brd_title = brd_title;
        this.brd_content = brd_content;
        this.mem_id = mem_id;
        this.brd_category = brd_category;
        this.mem_nickname = mem_nickname;
        this.brd_file = brd_file;
        this.brd_image = brd_image;
        this.brd_viewCnt = brd_viewCnt;
    }

}

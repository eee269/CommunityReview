package com.review.yj.community.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {
    private Long mem_id;
    private String mem_userid;
    private String mem_nickname;
    private String mem_password;

    @Builder
    public MemberDto(Long mem_id, String mem_userid, String mem_nickname, String mem_password) {
        this.mem_id = mem_id;
        this.mem_userid = mem_userid;
        this.mem_nickname = mem_nickname;
        this.mem_password = mem_password;
    }
}

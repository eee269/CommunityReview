package com.review.yj.community.dto.member;

import com.review.yj.community.domain.member.Member;
import lombok.Builder;

public class MemberResponseDto {
    private Long mem_id;
    private String mem_userid;
    private String mem_password;
    private String mem_username;
    private String mem_nickname;
    private String mem_phone;

    public MemberResponseDto(Member entity) {
        this.mem_id = entity.getMem_id();
        this.mem_userid = entity.getMem_userid();
        this.mem_password = entity.getMem_password();
        this.mem_username = entity.getMem_username();
        this.mem_nickname = entity.getMem_nickname();
        this.mem_phone = entity.getMem_phone();
    }
}

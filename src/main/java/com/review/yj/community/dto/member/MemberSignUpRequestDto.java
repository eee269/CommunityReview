package com.review.yj.community.dto.member;

import com.review.yj.community.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSignUpRequestDto {
    private String mem_userid;
    private String mem_password;
    private String mem_username;
    private String mem_nickname;
    private String mem_phone;

    public MemberSignUpRequestDto(String mem_userid, String mem_password, String mem_username, String mem_nickname, String mem_phone) {
        this.mem_userid = mem_userid;
        this.mem_password = mem_password;
        this.mem_username = mem_username;
        this.mem_nickname = mem_nickname;
        this.mem_phone = mem_phone;
    }

    @Builder
    // Member Data 전송하기
    public Member toEntity() {
        return Member.builder()
                .mem_userid(mem_userid)
                .mem_password(mem_password)
                .mem_nickname(mem_nickname)
                .mem_username(mem_username)
                .mem_phone(mem_phone)
                .build();
    }
}

package com.review.yj.community.dto.member;

import com.review.yj.community.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSignUpRequestDto {
    private String userid;
    private String password;
    private String username;
    private String nickname;
    private String phone;

    @Builder
    public MemberSignUpRequestDto(String userid, String password, String username, String nickname, String phone) {
        this.userid = userid;
        this.password = password;
        this.username = username;
        this.nickname = nickname;
        this.phone = phone;
    }

    // Member Data 전송하기
    public Member toEntity() {
        return Member.builder()
                .userid(userid)
                .password(password)
                .username(username)
                .nickname(nickname)
                .phone(phone)
                .build();
    }
}

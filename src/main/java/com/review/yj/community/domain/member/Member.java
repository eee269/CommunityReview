package com.review.yj.community.domain.member;

import com.review.yj.community.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    // member 테이블에 id 자동 입력
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String userid;

    @Column(length = 45, nullable = false)
    private String password;

    private String username;
    private String nickname;
    private String phone;

    @Builder
    public Member(String userid, String password, String username, String nickname, String phone) {
        this.userid = userid;
        this.password = password;
        this.username = username;
        this.nickname = nickname;
        this.phone = phone;
    }

}

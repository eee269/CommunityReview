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
    private Long mem_id;

    @Column(length = 45, nullable = false)
    private String mem_userid;

    @Column(length = 45, nullable = false)
    private String mem_password;

    private String mem_username;
    private String mem_nickname;
    private String mem_phone;

    @Builder
    public Member(Long mem_id, String mem_userid, String mem_password, String mem_username, String mem_nickname, String mem_phone) {
        this.mem_id = mem_id;
        this.mem_userid = mem_userid;
        this.mem_password = mem_password;
        this.mem_username = mem_username;
        this.mem_nickname = mem_nickname;
        this.mem_phone = mem_phone;
    }
}

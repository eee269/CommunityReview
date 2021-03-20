package com.review.yj.community.domain.member;

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
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mem_id;

    private String mem_userid;
    private String mem_nickname;

    @Builder
    public Member(String mem_userid, String mem_nickname) {
        this.mem_userid = mem_userid;
        this.mem_nickname = mem_nickname;
    }
}

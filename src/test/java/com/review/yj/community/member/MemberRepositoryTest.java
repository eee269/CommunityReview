package com.review.yj.community.member;


import com.review.yj.community.domain.member.Member;
import com.review.yj.community.domain.member.MemberRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @After
    public void cleanup() {
        memberRepository.deleteAll();
    }

    @Test
    public void member_저장() {
        // given
        memberRepository.save(Member.builder()
            .mem_userid("userid")
            .mem_password("password")
            .mem_username("username")
            .mem_nickname("nickname")
            .mem_phone("phone")
            .build());

        // when
        List<Member> memberList = memberRepository.findAll();

        Member member = memberList.get(0);

        // then
        assertThat(member.getMem_userid()).isEqualTo("userid");
        assertThat(member.getMem_password()).isEqualTo("password");
    }
}

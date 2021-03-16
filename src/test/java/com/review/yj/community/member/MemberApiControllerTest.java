package com.review.yj.community.member;

import com.review.yj.community.domain.member.Member;
import com.review.yj.community.domain.member.MemberRepository;
import com.review.yj.community.dto.member.MemberSignUpRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberApiControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private MemberRepository memberRepository;

    @After
    public void tearDown() {
        memberRepository.deleteAll();
    }

    @Test
    public void 회원가입() {
        String userid = "mem_userid";
        String password = "mem_password";
        // given
        memberRepository.save(Member.builder()
                .mem_userid(userid)
                .mem_password(password)
                .mem_username("mem_username")
                .mem_nickname("mem_nickname")
                .mem_phone("mem_phone")
                .build());
//        MemberSignUpRequestDto requestDto = MemberSignUpRequestDto.builder()
//                .mem_userid(userid)
//                .mem_password(password)
//                .mem_username("mem_username")
//                .mem_nickname("mem_nickname")
//                .mem_phone("mem_phone")
//                .build();
        String url = "http://localhost:" + port + "/api/member/signUp";

        // when
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
        List<Member> memberList = memberRepository.findAll();

        // then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        Member member = memberRepository.findAll().get(0);

        assertThat(member.getMem_userid()).isEqualTo("userid");
        assertThat(member.getMem_password()).isEqualTo("password");
    }

    @Test
    public void 로그인() {
        // given


        // when


        // then



    }
}

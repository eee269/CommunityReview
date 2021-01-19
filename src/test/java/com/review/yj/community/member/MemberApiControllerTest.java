package com.review.yj.community.member;

import com.review.yj.community.domain.member.Member;
import com.review.yj.community.domain.member.MemberRepository;
import com.review.yj.community.dto.MemberSignUpRequestDto;
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
        String userid = "userid";
        String password = "password";
        // given
        MemberSignUpRequestDto requestDto = MemberSignUpRequestDto.builder()
                .userid(userid)
                .password(password)
                .username("username")
                .nickname("nickname")
                .phone("phone")
                .build();
        String url = "http://localhost:" + port + "/api/member/signUp";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        Member member = memberRepository.findAll().get(0);

        assertThat(member.getUserid()).isEqualTo("userid");
        assertThat(member.getPassword()).isEqualTo("password");
    }

    @Test
    public void 로그인() {
        // given


        // when


        // then



    }
}

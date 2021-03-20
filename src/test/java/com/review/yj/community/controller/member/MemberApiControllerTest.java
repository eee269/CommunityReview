package com.review.yj.community.controller.member;

import com.review.yj.community.domain.member.Member;
import com.review.yj.community.domain.member.MemberRepository;
import com.review.yj.community.service.member.MemberService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberApiControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
//    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;


    @After
    public void after() {
        memberRepository.deleteAll();
    }

    @Test
    public void sign_up() {
        // given
        String userid = "아이디";
        String pass = "비밀번호";

        String url = "http://localhost:" + port + "/api/member/sign_up";

        // when
        ResponseEntity<Long> entity = restTemplate.postForEntity(url, Member.builder()
                .mem_userid(userid)
                .mem_password(pass)
                .build(), Long.class);

//        memberRepository.save(Member.builder()
//                .mem_userid(userid)
//                .mem_password(pass)
//                .build());

        // then

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isGreaterThan(0L);

        List<Member> memberList = memberRepository.findAll();
        Member member = memberList.get(memberList.size() -1);

        assertThat(member.getMem_userid()).isEqualTo(userid);
        assertThat(member.getMem_password()).isEqualTo(pass);

    }
}

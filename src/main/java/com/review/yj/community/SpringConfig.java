package com.review.yj.community;

import com.review.yj.community.domain.member.MemberRepository;
import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}

package com.review.yj.community.service.member;

import com.review.yj.community.domain.member.MemberRepository;
import com.review.yj.community.dto.member.MemberSignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor        // 생성자 자동생성
@Service
public class MemberService {
    // MemberRepository 연결
    private final MemberRepository memberRepository;

    @Transactional
    public Long signUp(MemberSignUpRequestDto requestDto) {
        return memberRepository.save(requestDto.toEntity()).getId();
    }


}

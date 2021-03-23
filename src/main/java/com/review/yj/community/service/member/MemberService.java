package com.review.yj.community.service.member;

import com.review.yj.community.domain.member.Member;
import com.review.yj.community.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Long save(Member member) {
        memberRepository.findByUserid(member.getMem_userid())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
        return memberRepository.save(member).getMem_id();
    }

    public Member findForLogin(Member requestDto) {
        Member result = memberRepository.findByUserInfo(requestDto.getMem_userid(), requestDto.getMem_password())
                .orElseThrow(() -> new IllegalArgumentException(requestDto.getMem_userid() + "의 아이디를 가지는 회원이 없습니다."));
        return result;
    }

    public Member findById(Long ses_id) {
        return memberRepository.findById(ses_id)
                .orElseThrow(() -> new IllegalArgumentException("회원정보를 찾을 수 없습니다."));
    }
}

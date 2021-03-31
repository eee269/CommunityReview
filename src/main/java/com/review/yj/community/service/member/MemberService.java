package com.review.yj.community.service.member;

import com.review.yj.community.controller.dto.MemberDto;
import com.review.yj.community.domain.member.Member;
import com.review.yj.community.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Long save(Member member) {
        return memberRepository.save(member).getMem_id();
    }

    public Member findForLogin(Member requestDto) {
        Member result = memberRepository.findByUserInfo(requestDto.getMem_userid(), requestDto.getMem_password())
                .orElseThrow(() -> new IllegalArgumentException("아이디와 비밀번호를 확인해주세요."));
        return result;
    }

    public MemberDto findById(Long ses_id) {
        Member member = memberRepository.findById(ses_id)
                .orElseThrow(() -> new IllegalArgumentException("회원정보를 찾을 수 없습니다."));
        return MemberDto.builder()
                .mem_id(member.getMem_id())
                .mem_userid(member.getMem_userid())
                .mem_nickname(member.getMem_nickname())
                .mem_password(member.getMem_password())
                .build();
    }

    @Transactional
    public Long update(Long mem_id, MemberDto dto) {
        Member member = memberRepository.findById(mem_id)
                .orElseThrow(() -> new IllegalArgumentException("회원정보를 찾을 수 없습니다."));
        member.update(dto.getMem_nickname(), dto.getMem_password());
        return member.getMem_id();
    }

    public void delete(Long mem_id) {
        memberRepository.deleteById(mem_id);
    }

    public int email_check(String userid) {
        return memberRepository.countById(userid);
    }
}

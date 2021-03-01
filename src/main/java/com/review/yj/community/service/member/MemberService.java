package com.review.yj.community.service.member;

import com.review.yj.community.domain.member.Member;
import com.review.yj.community.domain.member.MemberRepository;
import com.review.yj.community.dto.member.MemberResponseDto;
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
        return memberRepository.save(requestDto.toEntity()).getMem_id();
    }

    public Long findByUserid(String mem_userid) {
        Long mem_id = memberRepository.findByUserid(mem_userid);

        return mem_id;
    }

    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long ses_id) {
        Member entity = memberRepository.findById(ses_id)
                .orElseThrow(() -> new IllegalArgumentException(ses_id + "에 해당하는 회원이 없습니다."))
                ;

        return new MemberResponseDto(entity);

    }

    @Transactional(readOnly = true)
    public String findByIdForNickname(Long ses_id) {
        String nickname = memberRepository.findByIdForNickname(ses_id);
        return nickname;
    }

}

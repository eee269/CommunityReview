package com.review.yj.community.service.board;

import com.review.yj.community.domain.board.BoardRepository;
import com.review.yj.community.domain.member.Member;
import com.review.yj.community.domain.member.MemberRepository;
import com.review.yj.community.dto.board.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    // member id를 통해 member가 있는지 확인
    private final MemberRepository memberRepository;

    @Transactional
    public Long save(Long mem_id, BoardSaveRequestDto requestDto) {
        Member member = memberRepository.findById(mem_id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        return boardRepository.save(requestDto.toEntity(member.getNickname())).getBrd_id();
    }


}

package com.review.yj.community.service.board;

import com.review.yj.community.domain.board.ReplyRepository;
import com.review.yj.community.domain.member.Member;
import com.review.yj.community.domain.member.MemberRepository;
import com.review.yj.community.dto.board.ReplyListResponseDto;
import com.review.yj.community.dto.board.ReplySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long save(ReplySaveRequestDto requestDto) {
        Member member = memberRepository.findById(requestDto.getMem_id())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));


        int seq = 0;
        if(requestDto.getRep_parent() == null || requestDto.getRep_parent() == 0) {
            seq = replyRepository.findMaxSeq();
        } else {
            seq = replyRepository.findMaxSeqByRep_parent(requestDto.getRep_parent());
        }
        requestDto.setRep_seq(seq + 1);

//        requestDto.setRep_parent(
//                requestDto.getRep_parent() == null ? 0L : requestDto.getRep_parent()
//        );


        return replyRepository.save(requestDto.toEntity()).getRep_id();
    }

    @Transactional
    public List<ReplyListResponseDto> findAllByBrd_id(Long brd_id) {
        return replyRepository.findAllByBrd_id(brd_id);
    }
}

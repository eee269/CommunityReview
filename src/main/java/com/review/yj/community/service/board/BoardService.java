package com.review.yj.community.service.board;

import com.review.yj.community.domain.board.Board;
import com.review.yj.community.domain.board.BoardRepository;
import com.review.yj.community.domain.member.Member;
import com.review.yj.community.domain.member.MemberRepository;
import com.review.yj.community.dto.board.BoardListResponseDto;
import com.review.yj.community.dto.board.BoardSaveRequestDto;
import com.review.yj.community.dto.board.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    // member id를 통해 member가 있는지 확인
    private final MemberRepository memberRepository;

    @Transactional
    public Long save(Long ses_id, BoardSaveRequestDto requestDto) {
        Member member = memberRepository.findById(ses_id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        return boardRepository.save(requestDto.toEntity()).getBrd_id();
    }


    @Transactional(readOnly = true)
    public List<BoardListResponseDto> findAllDesc() {
        return boardRepository.findAllDesc().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BoardListResponseDto findById(Long brd_id) {
        Board entity = boardRepository.findById(brd_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        return new BoardListResponseDto(entity);
    }

    @Transactional
    public Long update(Long brd_id, BoardUpdateRequestDto requestDto) {
        Board board = boardRepository.findById(brd_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        board.update(requestDto.getBrd_title(), requestDto.getBrd_content());

        return brd_id;
    }

    @Transactional
    public void delete(Long brd_id) {
        Board board = boardRepository.findById(brd_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습ㄴ디ㅏ."));
        boardRepository.delete(board);
    }
}

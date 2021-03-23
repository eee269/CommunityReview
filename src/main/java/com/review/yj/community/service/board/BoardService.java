package com.review.yj.community.service.board;

import com.review.yj.community.domain.board.Board;
import com.review.yj.community.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public long save(Board board) {
        return boardRepository.save(board).getBrd_id();
    }

    @Transactional
    public Board findById(long brd_id) {
        return boardRepository.findById(brd_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
    }

    @Transactional
    public int update(Board board) {
        return boardRepository.update(board.getBrd_id(), board.getBrd_title(), board.getBrd_content());
    }

    @Transactional
    public void delete(Long brd_id) {
        boardRepository.deleteById(brd_id);
    }

    @Transactional
    public void addViewCnt(long brd_id) {
        boardRepository.addViewCnt(brd_id);
    }

    @Transactional(readOnly = true)
    public List<Board> findAllDesc() {
        return boardRepository.findAllDesc();
    }
}

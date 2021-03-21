package com.review.yj.community.service.board;

import com.review.yj.community.domain.board.Board;
import com.review.yj.community.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
//    @Autowired
    private final BoardRepository boardRepository;


    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public long save(Board board) {
        return boardRepository.save(board).getBrd_id();
    }

    public Board findById(long brd_id) {
        return boardRepository.findById(brd_id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
    }

    public int update(Board board) {
        return boardRepository.update(board.getBrd_id(), board.getBrd_title(), board.getBrd_content());
    }

    public void delete(Long brd_id) {
        boardRepository.deleteById(brd_id);
    }
}

package com.review.yj.community.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Modifying
    @Query("UPDATE Board b SET b.brd_cnt = b.brd_cnt+1 WHERE b.brd_id=?1")
    void addViewCnt(long brd_id);

    @Query("SELECT b FROM Board b ORDER BY b.brd_id desc")
    List<Board> findAllDesc();

    @Query("SELECT b FROM Board b WHERE b.brd_category=?1 ORDER BY b.brd_id desc")
    List<Board> findByCtg(int brd_category);

    @Query("SELECT b FROM Board b WHERE b.mem_id=?1 ORDER BY b.brd_id desc ")
    List<Board> findAllByMem_id(Long ses_id);
}

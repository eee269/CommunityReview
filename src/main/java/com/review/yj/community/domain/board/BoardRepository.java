package com.review.yj.community.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
//    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Board b SET b.brd_title=?2, b.brd_content=?3 WHERE b.brd_id=?1")
    int update(long brd_id, String brd_title, String brd_content);

//    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Modifying
    @Query("UPDATE Board b SET b.brd_cnt = b.brd_cnt+1 WHERE b.brd_id=?1")
    void addViewCnt(long brd_id);

    @Query("SELECT b FROM Board b ORDER BY b.brd_id desc")
    List<Board> findAllDesc();
}

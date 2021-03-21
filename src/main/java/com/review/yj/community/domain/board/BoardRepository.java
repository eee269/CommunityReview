package com.review.yj.community.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Board b SET b.brd_title=?2, b.brd_content=?3 WHERE b.brd_id=?1")
    int update(long brd_id, String brd_title, String brd_content);
}

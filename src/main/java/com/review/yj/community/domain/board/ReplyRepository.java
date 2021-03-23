package com.review.yj.community.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Query("SELECT r FROM Reply r WHERE r.brd_id=?1")
    List<Reply> findByBrd_id(long brd_id);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Reply r SET r.rep_content=?2 WHERE r.rep_id=?1")
    int update(Long rep_id, String rep_content);
}

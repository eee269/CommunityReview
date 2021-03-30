package com.review.yj.community.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Query("SELECT r FROM Reply r WHERE r.brd_id=?1 ORDER BY r.rep_seq")
    List<Reply> findByBrd_id(long brd_id);

    @Query("SELECT coalesce(max(r.rep_seq), 0) FROM Reply r")
    int findMaxSeq();

    @Modifying
    @Query("UPDATE Reply r SET r.rep_seq = r.rep_seq + 1 WHERE r.rep_seq >= ?1")
    void addSeq(int rep_seq);

    @Modifying
    @Query("UPDATE Reply r SET r.rep_seq = r.rep_seq - 1 WHERE r.rep_seq > (SELECT r.rep_seq FROM Reply r WHERE r.rep_id=:rep_id)")
    void subSeq(@Param("rep_id") Long rep_id);
}

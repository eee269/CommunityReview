package com.review.yj.community.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Query("SELECT r FROM Reply r WHERE r.brd_id=?1 ORDER BY r.rep_seq")
    List<Reply> findByBrd_id(long brd_id);

    @Modifying
    @Query("UPDATE Reply r SET r.rep_content=?2 WHERE r.rep_id=?1")
    int update(Long rep_id, String rep_content);

    @Query("SELECT coalesce(max(r.rep_seq), 0) FROM Reply r")
    int findMaxSeq();

    @Modifying
    @Query("UPDATE Reply r SET r.rep_seq =?2 + 1 WHERE r.rep_id = ?1 AND r.rep_seq > ?2")
    void updateSeq(Long rep_id, int rep_seq);
}

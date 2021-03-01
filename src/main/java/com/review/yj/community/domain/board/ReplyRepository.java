package com.review.yj.community.domain.board;

import com.review.yj.community.dto.board.ReplyListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query("SELECT MAX(r.rep_seq) FROM Reply r")
    int findMaxSeq();

    @Query("SELECT MAX(r.rep_seq) " +
            "FROM Reply r " +
            "where r.rep_parent = ?1" +
            "group by r.rep_parent")
    int findMaxSeqByRep_parent(Long rep_parent);

    @Query("SELECT r FROM Reply r WHERE r.brd_id = ?1")
    List<ReplyListResponseDto> findAllByBrd_id(Long brd_id);
}

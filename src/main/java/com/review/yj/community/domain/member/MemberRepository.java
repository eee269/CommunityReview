package com.review.yj.community.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m ORDER BY m.mem_id DESC")
    List<Member> findAllDesc();

    @Query("SELECT m.mem_id FROM Member m WHERE m.mem_userid = ?1")
    Long findByUserid(String userid);

    @Query("SELECT m.mem_nickname FROM Member m WHERE m.mem_id = ?1")
    String findByIdForNickname(Long id);
}

package com.review.yj.community.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 로그인 시 아이디, 비밀번호에 해당하는 정보 찾기
    @Query("SELECT m FROM Member m WHERE m.mem_userid=?1 and m.mem_password=?2")
    Optional<Member> findByUserInfo(String mem_userid, String mem_password);

    // 회원가입 시 중복되는 아이디 있는가 확인
    @Query("SELECT count(m.mem_userid) FROM Member m WHERE m.mem_userid=?1")
    int countById(String userid);
}

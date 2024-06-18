package org.example.gateway.repository;

import org.example.gateway.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName : org.example.gateway.repository
 * fileName : MemberRepository
 * author : kimtaewan
 * date : 2024-06-12
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-12         kimtaewan          최초 생성
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
}

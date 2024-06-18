package org.example.gateway.security.jwt;

import lombok.RequiredArgsConstructor;
import org.example.gateway.model.entity.Member;
import org.example.gateway.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * packageName : org.example.gateway.security.filter
 * fileName : TokenParse
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
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new UsernameNotFoundException("ID 없음:" + memberId));
        return (UserDetails) member;
    }
}

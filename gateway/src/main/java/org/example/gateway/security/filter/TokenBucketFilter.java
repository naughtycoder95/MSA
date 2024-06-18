package org.example.gateway.security.filter;

import io.github.bucket4j.Bucket;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * packageName : org.example.gateway.security.filter
 * fileName : TokenBucketFilter
 * author : kimtaewan
 * date : 2024-06-13
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-13         kimtaewan          최초 생성
 */
@Component
public class TokenBucketFilter extends OncePerRequestFilter {

    private final Map<String, Bucket> urlToBucketMap = new ConcurrentHashMap<>();

    // 토큰 버킷 기본설정
    private final Bucket defaultBucket = Bucket.builder()
            .addLimit(limit -> limit.capacity(600).refillGreedy(60, Duration.ofMinutes(1)))
            .build();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestPath = request.getRequestURI();
        Bucket bucket = urlToBucketMap.getOrDefault(requestPath, defaultBucket);

        // 토큰이 있는지 확인하고 없으면 429 에러 반환
        if (bucket.tryConsume(1)) {
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
        }
    }

    public void addBucketForUrl(String url, Bucket bucket) {
        urlToBucketMap.put(url, bucket);
    }
}
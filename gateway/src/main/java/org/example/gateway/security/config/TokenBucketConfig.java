package org.example.gateway.security.config;

import io.github.bucket4j.Bucket;
import org.example.gateway.security.filter.TokenBucketFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * packageName : org.example.gateway.security.config
 * fileName : TokenBucketConfig
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
@Configuration
public class TokenBucketConfig {

    @Autowired
    private TokenBucketFilter tokenBucketFilter;

    @Bean
    public TokenBucketFilter configureTokenBuckets() {
        tokenBucketFilter.addBucketForUrl("/mypage/**",
                Bucket.builder()
                        .addLimit(limit -> limit.capacity(20).refillGreedy(10, Duration.ofMinutes(1)))
                        .build());

        tokenBucketFilter.addBucketForUrl("/admin/**",
                Bucket.builder()
                        .addLimit(limit -> limit.capacity(10).refillGreedy(10, Duration.ofMinutes(1)))
                        .build());

        return tokenBucketFilter;
    }
}
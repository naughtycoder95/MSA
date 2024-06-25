package org.example.gateway.security.config;

import jakarta.servlet.DispatcherType;
import org.example.gateway.security.filter.AuthFilter;
import org.example.gateway.security.filter.TokenBucketFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static javax.management.Query.and;

/**
 * packageName : org.example.gateway.security.config
 * fileName : SecurityConfig
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
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthFilter authenticationJwtTokenFilter() {
        return new AuthFilter();
    }

    @Bean
    public TokenBucketFilter tokenBucketFilter() {
        return new TokenBucketFilter();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/css/**", "/dist/**", "/js/**", "/plugins/**",
                "/favicon.ico", "/resources/**", "/error"
        );
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.cors(Customizer.withDefaults());
        http.csrf((csrf) -> csrf.disable());
        http.sessionManagement(sessionManagement -> sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.formLogin(req -> req.disable());

        http.authorizeHttpRequests(req -> req
                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
//                .requestMatchers("/api/admin/**").hasAuthority("AT01")
//                .requestMatchers("/api/member/**").hasAnyAuthority("AT01", "AT02")
//                .requestMatchers("/api/auth/**").permitAll()
//                .requestMatchers("/api/product/**").permitAll()
//                .requestMatchers("/api/connect/**").permitAll()
//                .requestMatchers("/chat/**").permitAll()
//                .requestMatchers("/").permitAll()
//                .requestMatchers("/eureka/**").permitAll()
//                .anyRequest().authenticated());
                .anyRequest().permitAll()); // 임시로 권한 풀기 함수
        http.addFilterBefore(tokenBucketFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}

package com.kh.banana.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                //사용자가 직접 정의한 CorsConfigurationSource를 적용
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // 커스텀 CORS 설정 적용
                //.cors(Customizer.withDefaults())//Spring Boot의 WebMvcConfigurer에서 설정한 CORS 구성을 따름
                //.formLogin(Customizer.withDefaults())
                .csrf((csrf)->csrf.disable())//csrf보안이 기본으로 적용되어있음.
                //인증 JWT토큰 인증에서는 불필요
                //.userDetailsService(userDetailsService())
                .authorizeHttpRequests((authorize) -> authorize
                        //이부분에 보안처리할 uri를 설정하는 구간입니다.
                        .requestMatchers("/api/**").permitAll()
                        .anyRequest().authenticated()//나머지는 인증을 해야함.
                );

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:5173","http://localhost:5174"));  // 허용할 Origin 설정
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE")); // 허용할 HTTP 메서드
        configuration.setAllowedHeaders(List.of("*")); // 모든 헤더 허용
        configuration.setAllowCredentials(true); // 쿠키 포함 요청 허용
        configuration.setMaxAge(3600L); // Preflight 결과를 1시간(3600초) 캐싱

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // 모든 경로에 대해 CORS 설정 적용
        return source;
    }
}
package com.kh.banana.config;

import java.util.Random;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j  // Lombok의 로깅 어노테이션, log 객체를 자동으로 생성
//@Profile("dev")
@Configuration  // Spring 설정 클래스임을 명시
public class SSHTunnellingConfig {

    // SSH 세션을 생성하는 빈 메서드
    @Bean
    Session sshSession(SSHTunnellingProperties sshProperties) throws JSchException {
        // JSch 객체 생성 (SSH 연결을 위한 Java 라이브러리)
        JSch jsch = new JSch();
        // 개인키를 사용하여 인증 설정
        jsch.addIdentity(sshProperties.getPrivateKey());
        // SSH 세션 생성 (사용자명, 호스트, 포트)
        Session session = jsch.getSession(
                sshProperties.getUsername(),
                sshProperties.getSshHost(),
                sshProperties.getSshPort());

        // 호스트 키 검증 설정 (보안 설정)
        session.setConfig("StrictHostKeyChecking", "accept-new");
        // SSH 연결 시도
        session.connect();
        // 연결 성공 로깅
        log.info("---------------------------------------------");
        log.info("SSH 연결 성공: {}@{}", sshProperties.getUsername(), sshProperties.getSshHost());
        log.info("---------------------------------------------");
        return session;
    }

    // 포트 포워딩을 설정하는 빈 메서드
    @Bean
    Integer forwardedPort(Session session, SSHTunnellingProperties sshProperties) throws JSchException {
        // 3307-3316 사이의 랜덤 포트 생성
        int randomPort = new Random().nextInt(100) + 3307;
        // 로컬 포트와 RDS 포트를 연결하는 포트 포워딩 설정
        int localPort = session.setPortForwardingL(randomPort,
                sshProperties.getRdsHost(), sshProperties.getRdsPort());
        // 포트 포워딩 설정 로깅
        log.info("---------------------------------------------");
        log.info("포트 포워딩 설정: 로컬포트 {} -> RDS {}:{}",
                localPort, sshProperties.getRdsHost(), sshProperties.getRdsPort());
        log.info("---------------------------------------------");
        return localPort;
    }

    // HikariCP 설정을 위한 빈 메서드
    @Bean
    @ConfigurationProperties("spring.datasource.hikari")  // application.properties의 hikari 설정을 자동으로 바인딩
    HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    // 기본 데이터소스 빈 설정
    @Primary  // 여러 DataSource가 있을 때 우선적으로 사용
    @Bean
    DataSource dataSource(
            DataSourceProperties dataSourceProperties,  // Spring Boot의 데이터소스 설정
            HikariConfig hikariConfig,  // HikariCP 설정
            Integer forwardedPort){  // 포트 포워딩된 로컬 포트

        // JDBC URL에서 [LOCAL_PORT]를 실제 포트로 치환
        String jdbcUrl = dataSourceProperties.getUrl().replace("[LOCAL_PORT]", String.valueOf(forwardedPort));

        // HikariCP 설정 적용
        hikariConfig.setJdbcUrl(jdbcUrl);
        hikariConfig.setDriverClassName(dataSourceProperties.getDriverClassName());
        hikariConfig.setUsername(dataSourceProperties.getUsername());
        hikariConfig.setPassword(dataSourceProperties.getPassword());

        // 추가적인 데이터베이스 연결 설정
        hikariConfig.addDataSourceProperty("useSSL", "false");  // SSL 비활성화
        hikariConfig.addDataSourceProperty("serverTimezone", "Asia/Seoul");  // 서버 시간대 설정
        hikariConfig.addDataSourceProperty("characterEncoding", "utf8mb4");  // 문자 인코딩 설정

        // HikariDataSource 생성 및 반환
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        // 상세 설정 로깅
        logHikariConfig(hikariConfig);
        return dataSource;
    }

    // HikariCP 설정을 상세하게 로깅하는 private 메서드
    private void logHikariConfig(HikariConfig config) {
        log.info("---------------------------------------------");
        log.info("HikariCP Configuration:");
        log.info("JDBC URL: {}", config.getJdbcUrl());
        log.info("Maximum Pool Size: {}", config.getMaximumPoolSize());
        log.info("Minimum Idle: {}", config.getMinimumIdle());
        log.info("Idle Timeout: {} ms", config.getIdleTimeout());
        log.info("Max Lifetime: {} ms", config.getMaxLifetime());
        log.info("Connection Timeout: {} ms", config.getConnectionTimeout());
        log.info("---------------------------------------------");
    }
}

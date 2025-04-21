package com.kh.banana.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
//@Profile("dev")//이 클래스와 그 안의 모든 @Bean 메서드들은 'dev' 프로필이 활성화되었을 때만 생성됨
@Component
@ConfigurationProperties("spring.ssh.tunnel")
public class SSHTunnellingProperties {
	private String username;
	private String sshHost;//케밥(ssh-host)
	private int sshPort;
	private String privateKey;
	private String rdsHost;
	private int rdsPort;
}
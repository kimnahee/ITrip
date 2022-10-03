package co.itrip.prj;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 이메일 인증을 위한 메일 환경설정
 * @author 김하은
 * @Date 2022.09.28
 * @version 1.0
 *
 */
@Configuration
public class MailConfig {
	
	@Bean
	public JavaMailSender javaMailService() {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		sender.setHost("smtp.naver.com"); // 네이버 SMTP 서버 주소
		sender.setUsername(""); // 인증메일을 보낼 네이버 메일 아이디
		sender.setPassword("");  // 네이버 메일 비밀번호
		sender.setPort(465); // SMTP 포트 
		
		sender.setJavaMailProperties(getMailProperties()); // 메일 인증서버 정보 가져오기
		
		return sender;
	}

	public Properties getMailProperties() {
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp"); // 프로토콜 설정
        properties.setProperty("mail.smtp.auth", "true"); // smtp 인증
        properties.setProperty("mail.smtp.starttls.enable", "true"); // smtp strattles 사용
        properties.setProperty("mail.debug", "true"); // 디버그 사용
        properties.setProperty("mail.smtp.ssl.trust","smtp.naver.com"); // ssl 인증 서버는 smtp.naver.com
        properties.setProperty("mail.smtp.ssl.enable","true"); // ssl 사용
		return properties;
		
	}
}

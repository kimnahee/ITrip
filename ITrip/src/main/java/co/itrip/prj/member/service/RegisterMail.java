package co.itrip.prj.member.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
/**
 * 메일 내용 작성 및 보내기 클래스 작성 
 * @author 김하은
 * @Date 2022.09.28
 * @version 1.0
 */
@Service
public class RegisterMail implements MailServiceInter{
	
	@Autowired
	JavaMailSender sender; // MailConfig Bean
	
	private String ePw; //인증번호

	@Override
	public MimeMessage createMessage(String to) throws MessagingException, UnsupportedEncodingException  { //파라미터 : 수신자
		
		MimeMessage msg = sender.createMimeMessage();
		
		msg.addRecipients(RecipientType.TO, to); // 발송인
		msg.setSubject("ITrip 회원가입 이메일 인증"); // 제목
		
		String msgText = "";
		msgText += "<div style='margin:100px;'>";
		msgText += "<h1> 안녕하세요</h1>";
		msgText += "<h1> ITrip에서 회원가입 인증을 위해 메일 발송드립니다.</h1>";
		msgText += "<br>";
		msgText += "<p>아래 코드를 회원가입 창으로 돌아가 입력해주세요<p>";
		msgText += "<br>";
		msgText += "<br>";
		msgText += "<div align='center' style='border:1px solid black; font-family:verdana';>";
		msgText += "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
		msgText += "<div style='font-size:130%'>";
		msgText += "CODE : <strong>";
		msgText += ePw + "</strong><div><br/> "; // 메일에 인증번호 넣기
		msgText += "</div>";
		msg.setText(msgText,"utf-8","html");
		
		msg.setFrom(new InternetAddress("devel2022p@naver.com","ITrip_ADMIN")); //발송인
		
		return msg;
	}

	// 랜덤 인증 코드 전송
	@Override
	public String createKey() {
		StringBuffer key = new StringBuffer();
		Random rnd = new Random();
		
		for (int i = 0; i < 8; i++) { // 인증코드 8자리
			int index = rnd.nextInt(3); // 0~2까지 랜덤, rnd 값에 따라 switch문 실행
			
			switch(index) {
			case 0:
				key.append((char)((int)(rnd.nextInt(26))+97)); // 영어 소문자 a~z(ex. 1+97=98 -> (chr)98 = 'b'
				break;
			case 1:
				key.append((char)((int)(rnd.nextInt(26))+65)); // 영어 대문자 A~Z
				break;
			case 2:
				key.append((rnd.nextInt(10))); // 숫자 0~9
				break;
			}
			
		}
		return key.toString();
	}
	
	// 메일 발송
	@Override
	public String sendSimpleMessage(String to) throws Exception { // 파라미터 : 수신자의 메일주소
		ePw = createKey(); // 랜덤 인증번호 생성
		MimeMessage msg = createMessage(to); //메일 발송
		
		try {
			sender.send(msg);
		} catch (MailException es) {
			es.printStackTrace();
			throw new IllegalArgumentException();
		}
		
		return ePw; //메일로 보낸 인증코드를 서버에 저장하고 있다가 사용자가 인증번호를 입력했을 때 인증 처리하기 위해 리턴 
	}

	
}

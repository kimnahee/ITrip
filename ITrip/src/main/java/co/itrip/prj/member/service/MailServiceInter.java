package co.itrip.prj.member.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 메일 내용 작성 및 보내기 인터페이스
 * @author USER
 * @Date 2022.09.28
 * @Version 1.0
 */
public interface MailServiceInter {
	public MimeMessage createMessage(String to) throws MessagingException, UnsupportedEncodingException; // 메일 내용 작성
	public String createKey(); // 랜덤 인증코드
	public String sendSimpleMessage(String to) throws Exception; //실제로 메일을 발송
}

package co.itrip.prj.cbtGuide.service;

import java.util.Date;

import lombok.Data;

@Data
public class MyCbtHderVO {
	private int mcNo; // 응시번호
	private String memberId; // 회원아이디
	private Date dt; // 응시일자
	private String gtpCd;// cbt유형코드
	private String langCd;// cbt언어코드
	private int cbtNo1; //문제1번
	private int cbtNo2; //문제2번
	private int cbtNo3; //문제3번
	private int cbtNo4; //문제4번
	private int cbtNo5; //문제5번
	private String cnsr1; //문제1번 정답입력값
	private String cnsr2; //문제1번 정답입력값
	private String cnsr3; //문제1번 정답입력값
	private String cnsr4; //문제1번 정답입력값
	private String cnsr5; //문제1번 정답입력값
	private int chk1; //정답체크1번
	private int chk2; //정답체크2번
	private int chk3; //정답체크3번
	private int chk4; //정답체크4번
	private int chk5; //정답체크5번
	
	private int chk0Cunt; // 정답카운트
	private int chk1Cunt; // 오답카운트
}

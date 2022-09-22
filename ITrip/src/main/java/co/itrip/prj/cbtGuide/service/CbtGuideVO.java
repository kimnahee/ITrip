package co.itrip.prj.cbtGuide.service;

import java.util.List;

import lombok.Data;

@Data
public class CbtGuideVO {
	private int cbtNo; //cbt번호
	private String ques; //cbt문제
	private String cnsr; // cbt정답
	private String ex1; //보기1
	private String ex2; //보기2
	private String ex3; //보기3
	private String ex4; //보기4
	private String attach; // 첨부파일
	private String attachDir; // 첨부파일 경로
	private int cnsrCnt; // 맞힌 카운트
	private int call; // 문제호출횟수
	private String explna; // 풀이
	private String gtpCd; // cbt유형코드
	private String langCd; // cbt언어코드
	private String memberId; // 출제자
	List<String> keyword; // 여러건 받을 키워드
	private int rownum; //가상의 순번 
	
	

}

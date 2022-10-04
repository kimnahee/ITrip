package co.itrip.prj.cbtCustom.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CbtCustomVO {
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
	private int rownum; //가상의 순번 
	private int time; //문제풀시간 
	private int pcs; //문제갯수 
	
	private String gtpCdName; //gtpCd의 한글명
	private String langCdName; //langCd의 한글명
}

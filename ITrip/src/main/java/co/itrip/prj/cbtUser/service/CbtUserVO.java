package co.itrip.prj.cbtUser.service;

import lombok.Data;

@Data
public class CbtUserVO {
	int cbtNo; //문제번호
	String ques; //문제
	String cnsr; //정답
	String ex1; //보기1
	String ex2; //보기2
	String ex3; //보기3
	String ex4; //보기4
	String attach; //문제사진
	String attachDir; //문제사진경로
	int cnsrCnt; //해당문제 푼 회원이 맞힌카운트
	int call; //문제호출횟수
	String explna; //풀이
	String utpCd; // cbt유형코드 - 객관식 or OX
	String langCd; //언어카테고리코드 - 자바,자바스크립트..
	String memberId; //제출자아이디
	String cdName; //공통코드 
	int rownum;
}

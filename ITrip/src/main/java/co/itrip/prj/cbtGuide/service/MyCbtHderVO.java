package co.itrip.prj.cbtGuide.service;

import java.util.Date;

import lombok.Data;

@Data
public class MyCbtHderVO {
	private int mcNo; // 응시번호
	private String memberId; // 회원아이디
	private Date dt; // 응시일자
	private int mcCnt; // 응시횟수
	private int score; // 점수
	private String ctpCd;// cbt유형코드
	private String langCd;// cbt언어코드
	

}

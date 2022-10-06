package co.itrip.prj.consult.service;


import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class ConsultVO {

	// I-CONSULT (1:1상담)
	private int  consultNo; // 상담 번호
	private String title; // 제목
	private String content; // 내용
	private Date dt; // 작성일자
	// private String memberId; // 상담 신청한 유저
	private String stateCd; // 상담승인 여부코드
	private String guideId; // 가이드 아이디
	private String jobCd; // 업무카테고리코드
	private String jobName; 

	//private int price; // 결제금액

	private String ennc; // 상태변화 (상담 활성화/비활성화) 
	private Date beginDate; // 시작일자
	private Date endDate; // 종료일자
	private String career; // 가이드 경력
	private String dutyName; // 가이드 직무 //consultMapper에서 조인구문으로 가져와서 목록에 뿌려주기 cdName
	
	private List<ConsultDtVO> consultDt; // ConsultDtVO
	private String week; // 요일
	private String beginTime; // 시작시간
	private String endTime; // 종료시간
	private int price; //상담결제금액
	
	private String memberId;  
	
	private String key; // 검색할 키워드
	private String val; // 검색할 값
	
	private Date conday; // 마이페이지 상담일
	private String stime; // 마이페이지 상담 시작시간

	
	
	
	
}

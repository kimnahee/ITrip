package co.itrip.prj.consult.service;

import java.util.Date;

import lombok.Data;

@Data
public class ConsultVO {

	// I-CONSULT (1:1상담)
	private Integer consultNo; // 상담 번호
	private String title; // 제목
	private String content; // 내용
	private Date dt; // 작성일자
	private String memberId; // 상담 신청한 유저
	private String stateCd; // 상담승인 여부코드
	private String guideId; // 가이드 아이디
	private String jobCd; // 업무카테고리코드
	private Integer price; // 결제금액
	private String ennc; // 상태변화 (상담 활성화/비활성화) 
	private Date begin_date; // 시작일자
	private Date end_date; // 종료일자
	
	
	
	
	
	
}

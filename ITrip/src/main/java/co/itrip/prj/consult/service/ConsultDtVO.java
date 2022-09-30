package co.itrip.prj.consult.service;

import lombok.Data;

@Data
public class ConsultDtVO {
	
	// 상담 시간 테이블
	private int cdtNo; // 상담시간 순번
	private int consultNo; // 상담 글번호
	private String week; // 요일
	private String beginTime; // 시작시간
	private String endTime; // 종료시간
	private Integer price; //상담결제금액
	private String day;

	

}

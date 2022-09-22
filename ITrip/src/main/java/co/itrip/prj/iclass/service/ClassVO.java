package co.itrip.prj.iclass.service;

import java.util.Date;

import lombok.Data;

@Data
public class ClassVO {
	
	// 클래스 
	private Integer classNo; // 클래스 번호
	private String title; // 제목
	private String content; // 설명
	private String crclm; // 상세커리큘럼
	private Date dt; // 등록일자 sysdate
	private Integer price; // 금액
	private String attach; // 파일
	private String attachDir; // 파일경로
	private String confmCd; // 클래스 승인코드
	private String guideId; // 가이드 아이디
	private String jobCd; // 업무카테고리 코드
	private Integer psncpa; // 정원
	private Integer classCnt; // 수업횟수(주 단위)
	
}

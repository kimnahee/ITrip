package co.itrip.prj.iclass.service;


import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class ClassVO {
	
	// 클래스 
	private int classNo; // 클래스 번호
	private String title; // 제목
	private String content; // 설명
	private String crclm; // 상세커리큘럼
	private Date dt; // 등록일자
	private int price; // 금액
	

	private String attach; // 파일
	private String attachDir; // 파일경로
	private String confmCd; // 클래스 승인코드
	private String guideId; // 가이드 아이디
	private String jobCd; // 업무카테고리 코드
	private int psncpa; // 정원
	private int classCnt; // 수업횟수(주 단위)
	private String ennc; // 상태변화 (상담 활성화/비활성화) 
	
	private List<ClassDtVO> classDt; // ClassDtVO 
	
//	private String term;
//	private String beginTime;
//	private String endTime;
	
	
}

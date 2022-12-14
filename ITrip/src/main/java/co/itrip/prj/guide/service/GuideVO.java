package co.itrip.prj.guide.service;

import java.sql.Date;
import lombok.Data;

@Data
public class GuideVO {
	
	// 가이드 테이블
	private String guideId; // 유저 아이디
	private String career; // 경력
	private String dc; // 설명
	private String duty; // 직무
	private String attach; // 파일
	private String AttachDir; // 파일경로
	private String stateCd; // 승인코드
	private Date dt; // 신청일자
	private int star; // 별점
	

	//admin에서 추가로 필요한정보 ->경아
	private String nick;
	private String name;
	private String auth;
	private String dutyCdName; 
	private String careerCdName;
	
	private String cdName; // 직무 설명
	private String care; // 경력 설명 

	


}

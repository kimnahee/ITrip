package co.itrip.prj.alarm.service;

import lombok.Data;

@Data
public class AlarmVO {
	
	// 알람테이블
	private int alarmNo; // 알람 순번 
	private String guideId; // 가이드 아이디 (강사)
	private String memberId; // 유저 아이디 (학생)
	private int classNo; // 클래스 번호
	private String alarmChk; // 알람 확인여부
	private String alarmMsg; // 알람내용
	

}

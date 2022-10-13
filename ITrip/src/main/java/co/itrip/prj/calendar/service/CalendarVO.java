package co.itrip.prj.calendar.service;



import java.sql.Date;

//import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CalendarVO {
	
	private int calendarNo; // 인공키
	private String merchantUid; // 외래키, 상담 결제 취소시 캘린더 리스트 삭제용도
	
	private String guideId; // 가이드 아이디
	private String member_id; // 유저 아이디
	private String memberId; // 유저 아이디 캘린더용
	private String name; // 제목
	
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private String conday; // 상담일
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private String beginTime; // 시작시간
	private int no; // 캘린더 번호
	
	

}

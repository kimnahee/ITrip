package co.itrip.prj.calendar.service;

import java.util.List;

public interface CalendarService {
	
	int calendarInsert(CalendarVO vo); // 상담 결제 후 가이드 캘린더 등록
	int classCalendarInsert(CalendarVO vo); // 클래스 결제 후 가이드 캘린더 등록
	
	List<CalendarVO> myCalendarList(CalendarVO vo); // 가이드 나의 상담 리스트
}

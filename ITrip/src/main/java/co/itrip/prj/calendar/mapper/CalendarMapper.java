package co.itrip.prj.calendar.mapper;

import java.util.List;

import co.itrip.prj.calendar.service.CalendarVO;

public interface CalendarMapper {
	
	int calendarInsert(CalendarVO vo); // 상담 결제 후 가이드 캘린더 등록
	int classCalendarInsert(CalendarVO vo); // 클래스 결제 후 가이드 캘린더 등록
	
	List<CalendarVO> myCalendarList(CalendarVO vo); // 가이드 나의 상담 리스트
	List<CalendarVO> myClassCalendarList(CalendarVO vo); // 가이드 나의 클래스 리스트

}

package co.itrip.prj.calendar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.calendar.mapper.CalendarMapper;

@Service
public class CalendarServiceImple implements CalendarService {

	@Autowired
	CalendarMapper map;
	
	@Override
	public int calendarInsert(CalendarVO vo) {
		// 상담 캘린더 등록
		return map.calendarInsert(vo);
	}

	@Override
	public List<CalendarVO> myCalendarList(CalendarVO vo) {
		// 캘린더리스트
		return map.myCalendarList(vo);
	}

	@Override
	public int classCalendarInsert(CalendarVO vo) {
		// 수강생 캘린더 등록
		return map.classCalendarInsert(vo);
	}

}

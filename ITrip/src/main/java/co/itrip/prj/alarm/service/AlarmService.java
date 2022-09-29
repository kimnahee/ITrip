package co.itrip.prj.alarm.service;

import java.util.List;

public interface AlarmService {
	List<AlarmVO> alarmList(AlarmVO vo); //나한테 온 알람 리스트
	int alarmCount(AlarmVO vo); //알람 개수(count(*))
	int alarmInsert(AlarmVO vo);//클래스 등록 시 알람 전송
	int alarmUpdate(AlarmVO vo);//알람 상태 변경(읽지않음(0) => 읽음(1))
}

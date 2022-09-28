package co.itrip.prj.alarm.service;

import java.util.List;

public interface AlarmService {
	List<AlarmVO> alarmList(AlarmVO vo); //나한테 온 알람 리스트
	int alarmCount(AlarmVO vo); //알람 개수(count(*))
}

package co.itrip.prj.alarm.mapper;

import java.util.List;

import co.itrip.prj.alarm.service.AlarmVO;

public interface AlarmMapper {
	List<AlarmVO> alarmList(AlarmVO vo); //나한테 온 알람 리스트
	int alarmCount(AlarmVO vo); //알람 개수(count(*))
}

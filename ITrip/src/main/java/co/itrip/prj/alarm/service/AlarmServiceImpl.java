package co.itrip.prj.alarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.alarm.mapper.AlarmMapper;

@Service
public class AlarmServiceImpl implements AlarmService {

	@Autowired
	private AlarmMapper map;
	
	@Override
	public List<AlarmVO> alarmList(AlarmVO vo) {
		return map.alarmList(vo);
	}

	@Override
	public int alarmCount(AlarmVO vo) {
		return map.alarmCount(vo);
	}

}

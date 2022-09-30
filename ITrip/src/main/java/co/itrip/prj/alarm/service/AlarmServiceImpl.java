package co.itrip.prj.alarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.alarm.mapper.AlarmMapper;
import co.itrip.prj.follow.service.FollowVO;

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

	@Override
	public int alarmInsert(AlarmVO vo) {
		return map.alarmInsert(vo);
	}

	@Override
	public int alarmUpdate(AlarmVO vo) {
		return map.alarmUpdate(vo);
	}


}

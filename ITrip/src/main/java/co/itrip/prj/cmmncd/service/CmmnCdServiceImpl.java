package co.itrip.prj.cmmncd.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.cmmncd.mapper.CmmnCdMapper;

@Service
public class CmmnCdServiceImpl implements CmmnCdService {

	@Autowired
	private CmmnCdMapper map; // 공통코드 맵퍼
	
	@Override
	public List<CmmnCdVO> careerCdList() {
		// 경력 공통코드 리스트
		return map.careerCdList();
	}

	@Override
	public List<CmmnCdVO> dutyCdList() {
		// 직무 공통코드 리스트
		return map.dutyCdList();
	}

}

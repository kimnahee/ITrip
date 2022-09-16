package co.itrip.prj.langcd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.itrip.prj.langcd.mapper.LangCdMapper;

public class LangCdServiceImpl implements LangCdService {
	@Autowired
	private LangCdMapper map;
	
	@Override
	public List<LangCdVO> langCdList() {
		return map.langCdList();
	}

}

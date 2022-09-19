package co.itrip.prj.utpcd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.utpcd.mapper.UtpCdMapper;
@Service
public class UtpCdServiceImpl implements UtpCdService {
	@Autowired
	private UtpCdMapper map;

	@Override
	public List<UtpCdVO> utpCdList() {
		return map.utpCdList();
	}


}

package co.itrip.prj.gtpcd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.gtpcd.mapper.GtpCdMapper;
@Service
public class GtpCdServiceImpl implements GtpCdService {
	@Autowired
	private GtpCdMapper map;

	@Override
	public List<GtpCdVO> gtpCdList() {
		return map.gtpCdList();
	}

}

package co.itrip.prj.member.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.member.community.mapper.CommunityMapper;

@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	private CommunityMapper map;
	
	@Override
	public List<CommunityVO> communityList() {
		return map.communityList();
	}

}

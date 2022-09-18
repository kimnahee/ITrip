package co.itrip.prj.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.community.mapper.CommunityMapper;

@Service
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	private CommunityMapper map;
	
	@Override
	public List<CommunityVO> communityList() {
		return map.communityList();
	}

	@Override
	public CommunityVO selectCommunity(CommunityVO vo) {
		return map.selectCommunity(vo);
	}

	@Override
	public List<CommunityVO> studyList() {
		return map.studyList();
	}

	@Override
	public int studyInsert(CommunityVO vo) {
		return map.studyInsert(vo);
	}

	@Override
	public int studyUpdate(CommunityVO vo) {
		return map.studyUpdate(vo);
	}

	@Override
	public int studyDelete(CommunityVO vo) {
		return map.studyDelete(vo);
	}

}

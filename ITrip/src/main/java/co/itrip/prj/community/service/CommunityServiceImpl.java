package co.itrip.prj.community.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import co.itrip.prj.community.mapper.CommunityMapper;
import co.itrip.prj.community.service.ReplyVO;

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

	@Override
	public List<CommunityVO> findAll() {
		return map.findAll();
	}

	@Override
	public List<CommunityVO> findStudy() {
		return map.findStudy();
	}

	@Override
	public List<ReplyVO> replyList(ReplyVO vo) {
		return map.replyList(vo);
	}

	@Override
	public int replyInsert(ReplyVO vo) {
		return map.replyInsert(vo);
	}

	@Override
	public int replyDelete(ReplyVO vo) {
		return map.replyDelete(vo);
	}

	@Override
	public int replyUpdate(ReplyVO vo) {
		return map.replyUpdate(vo);
	}

}

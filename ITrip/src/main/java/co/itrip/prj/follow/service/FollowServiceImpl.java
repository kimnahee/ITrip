package co.itrip.prj.follow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.follow.mapper.FollowMapper;

@Service
public class FollowServiceImpl implements FollowService {
	
	@Autowired
	private FollowMapper map;

	@Override
	public List<FollowVO> followSelectList() {
		// TODO Auto-generated method stub
		return map.followSelectList();
	}

	@Override
	public int followInsert(FollowVO vo) {
		// TODO Auto-generated method stub
		return map.followInsert(vo);
	}

	@Override
	public int followDelete(FollowVO vo) {
		// TODO Auto-generated method stub
		return map.followDelete(vo);
	}

	@Override
	public int followCount() {
		// TODO Auto-generated method stub
		return map.followCount();
	}

}

package co.itrip.prj.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.admin.mapper.AdminMapper;
import co.itrip.prj.guide.service.GuideVO;
import co.itrip.prj.member.service.MemberVO;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper map;
	
	@Override
	public List<MemberVO> memberList(MemberVO vo) {
		return map.memberList(vo);
	}

	@Override
	public List<GuideVO> memberAuthList(GuideVO vo) {
		return map.memberAuthList(vo);
	}

	@Override
	public int memberAuthUpdate(GuideVO vo) {
		return map.memberAuthUpdate(vo);
	}

	@Override
	public List<MemberVO> memberListOf(MemberVO vo) {
		return map.memberListOf(vo);
	}

	

}

package co.itrip.prj.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.admin.mapper.AdminMapper;
import co.itrip.prj.consult.service.ConsultVO;
import co.itrip.prj.guide.service.GuideVO;
import co.itrip.prj.iclass.service.ClassVO;
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

	
	
	public List<ClassVO> classList(ClassVO vo) {
		// Class 전체조회
		return map.classList(vo);
	}

	@Override
	public List<ConsultVO> ConsultList(ConsultVO vo) {
		// 상담 전체조회
		return map.ConsultList(vo);
	}

	@Override
	public int classUpdate(ClassVO vo) {
		// 클래스 업데이트
		return map.classUpdate(vo);
	}

	@Override
	public int consultUpdate(ConsultVO vo) {
		// 상담 업데이트
		return map.consultUpdate(vo);

	}

	@Override
	public int memberAuthUpdateTo(MemberVO vo) {
		return map.memberAuthUpdateTo(vo);
	}

	@Override
	public List<ConsultVO> consultSearch(ConsultVO vo) {
		// 상담 검색
		return map.consultSearch(vo);
	}

	@Override
	public List<ClassVO> classSearch(ClassVO vo) {
		// TODO Auto-generated method stub
		return map.classSearch(vo);
	}

	

}

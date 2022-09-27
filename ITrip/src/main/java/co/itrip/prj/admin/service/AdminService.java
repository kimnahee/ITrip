package co.itrip.prj.admin.service;

import java.util.List;

import co.itrip.prj.guide.service.GuideVO;
import co.itrip.prj.member.service.MemberVO;


public interface AdminService {
	List<MemberVO> memberList(MemberVO vo);
	List<MemberVO> memberListOf(MemberVO vo);
	List<GuideVO> memberAuthList(GuideVO vo);
	int memberAuthUpdate(GuideVO vo);
}

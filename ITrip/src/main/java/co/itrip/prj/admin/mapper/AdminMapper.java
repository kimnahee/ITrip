package co.itrip.prj.admin.mapper;

import java.util.List;

import co.itrip.prj.guide.service.GuideVO;
import co.itrip.prj.member.service.MemberVO;

public interface AdminMapper {
	List<MemberVO> memberList(MemberVO vo);
	List<GuideVO> memberAuthList(GuideVO vo);
	int memberAuthUpdate(GuideVO vo);
}

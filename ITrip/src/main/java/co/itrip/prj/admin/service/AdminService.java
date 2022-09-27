package co.itrip.prj.admin.service;

import java.util.List;

import co.itrip.prj.consult.service.ConsultVO;
import co.itrip.prj.guide.service.GuideVO;
import co.itrip.prj.iclass.service.ClassVO;
import co.itrip.prj.member.service.MemberVO;


public interface AdminService {
	List<MemberVO> memberList(MemberVO vo);
	List<GuideVO> memberAuthList(GuideVO vo);
	int memberAuthUpdate(GuideVO vo);
	
	List<ClassVO> classList(ClassVO vo); // 클래스 전체조회 페이징 처리 
	List<ConsultVO> ConsultList(ConsultVO vo); // 상담 전체조회 페이징처리 
	int classUpdate(ClassVO vo); // 클래스 승인변경
	int consultUpdate(ConsultVO vo); // 상담 승인변경
}

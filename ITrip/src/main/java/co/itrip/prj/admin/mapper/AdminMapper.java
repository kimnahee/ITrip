package co.itrip.prj.admin.mapper;

import java.util.List;

import co.itrip.prj.consult.service.ConsultVO;
import co.itrip.prj.guide.service.GuideVO;
import co.itrip.prj.iclass.service.ClassVO;
import co.itrip.prj.member.service.MemberVO;

public interface AdminMapper {
	//경아 
	List<MemberVO> memberList(MemberVO vo); //전체회원조회
	List<MemberVO> memberListOf(MemberVO vo);//권한변회원조회
	List<GuideVO> memberAuthList(GuideVO vo);//guide신청한 회원조회
	int memberAuthUpdate(GuideVO vo); //guide신청한 회원등급수정
	int memberAuthUpdateTo(MemberVO vo); //guide신청한 회원의 멤버테이블 권한수정 
	
	//소정
	List<ClassVO> classList(ClassVO vo); // 클래스 전체조회 페이징 처리 
	List<ConsultVO> ConsultList(ConsultVO vo); // 상담 전체조회 페이징처리 
	int classUpdate(ClassVO vo); // 클래스 승인변경
	int consultUpdate(ConsultVO vo); // 상담 승인변경
}

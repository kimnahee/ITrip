package co.itrip.prj.member.service;

import java.util.List;

public interface MemberService {
	
	List<MemberVO> memberSelectList(MemberVO vo);
	MemberVO memberSelect(MemberVO vo); // 유저 단건조회
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo); // 유저 정보수정
	int memberDelete(MemberVO vo);
	

}

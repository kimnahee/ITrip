package co.itrip.prj.member.mapper;

import java.util.List;

import co.itrip.prj.member.service.MemberVO;

public interface MemberMapper {

	List<MemberVO> memberSelectList(MemberVO vo);
	MemberVO memberSelect(MemberVO vo); // 유저 단건조회
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo); // 유저 정보수정
	int memberDelete(MemberVO vo);
	
}

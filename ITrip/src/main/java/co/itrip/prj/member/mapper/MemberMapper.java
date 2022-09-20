package co.itrip.prj.member.mapper;

import java.util.List;

import co.itrip.prj.member.service.MemberVO;

public interface MemberMapper {

	List<MemberVO> memberSelectList(MemberVO vo);
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	
}

package co.itrip.prj.member.mapper;

import java.util.List;

import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.MyCbtHderVO;
import co.itrip.prj.member.service.MemberVO;

public interface MemberMapper {

	List<MemberVO> memberSelectList(MemberVO vo);
	MemberVO memberSelect(MemberVO vo); // 유저 단건조회
	int memberInsert(MemberVO vo); // 회원등록
	int memberUpdate(MemberVO vo); // 유저 정보수정
	int memberDelete(MemberVO vo);
	
	MemberVO memberSearch(MemberVO vo); //아이디/ 비밀번호 찾기
	public int ajaxIdChk(String mId);    // id 중복 검사
	public int ajaxNickChk(String mNick); // 닉네임 중복검사
	public int memberPwUpdate(MemberVO vo); // pw변경
}

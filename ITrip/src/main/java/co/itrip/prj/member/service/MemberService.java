package co.itrip.prj.member.service;

import java.util.List;

public interface MemberService {
	
	List<MemberVO> memberSelectList(MemberVO vo);
	MemberVO memberSelect(MemberVO vo); // 유저 단건조회
	int memberUpdate(MemberVO vo); // 유저 정보수정
	
	/**
	 * 로그인/회원가입 및 회원관련된 데이터 처리
	 * 
	 * @author 김하은
	 * @date 2022.10.07
	 * @version 1.0
	 */
	MemberVO memberSearch(MemberVO vo); //아이디/ 비밀번호 찾기
	int memberInsert(MemberVO vo); // 회원가입
	int memberDelete(MemberVO vo); // 회원 삭제(null처리)
	public int ajaxIdChk(String mId);    // id 중복 검사
	public int ajaxNickChk(String mNik); // 닉네임 중복검사


}

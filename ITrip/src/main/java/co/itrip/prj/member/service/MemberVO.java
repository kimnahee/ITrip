package co.itrip.prj.member.service;

import lombok.Data;

@Data
public class MemberVO {
	/**
	 * 테이블 정보 수정 private, 주석처리
	 * 2022.09.22 박은지
	 */
	// 멤버 테이블 (유저)
	private String memberId; // 아이디
	private String nick; // 닉네임
	private String pw; // 비밀번호
	private String name; // 이름
	private String email; // 이메일
	private String attach; // 파일
	private String attach_Dir; // 파일경로
	private String auth; // 권한

	private String guideId; // 아이디
	
}

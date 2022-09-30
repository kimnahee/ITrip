package co.itrip.prj.follow.service;

import lombok.Data;

@Data
public class FollowVO {

	//팔로우테이블
	private String guideId; // 가이드 아이디 (강사)
	private String memberId; // 유저 아이디 (학생)
	
	// 쿼리 조인 (4 테이블)
	private String nick; // 유저 닉네임
	private String cdName; // 가이드 직무 이름
	private int consultNo;
}

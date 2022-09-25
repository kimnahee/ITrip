package co.itrip.prj.follow.service;

import lombok.Data;

@Data
public class FollowVO {

	//팔로우테이블
	private String guideId; // 가이드 아이디 (강사)
	private String memberId; // 유저 아이디 (학생)
	private String nick; // 유저 닉네임
}

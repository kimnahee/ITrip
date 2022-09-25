package co.itrip.prj.follow.service;

import java.util.List;

public interface FollowService {
	
	List<FollowVO> followSelectList(FollowVO vo); // 팔로우 전체조회
	int followInsert(FollowVO vo); // 팔로우
	int followDelete(FollowVO vo); // 언팔로우
	int followCount(); // 팔로우한 유저 수
	
	
	//가이드마이페이지
	List<FollowVO> followerSelectList(FollowVO vo); // 팔로워 전체조회
	int followerInsert(FollowVO vo); // 팔로워
	int followerDelete(FollowVO vo); // 언팔로우
	int followerCount(); // 팔로워 수
	
	

}

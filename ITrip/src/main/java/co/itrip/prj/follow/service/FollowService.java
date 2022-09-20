package co.itrip.prj.follow.service;

import java.util.List;

public interface FollowService {
	
	List<FollowVO> followSelectList(); // 팔로우 전체조회
	int followInsert(FollowVO vo); // 팔로우
	int followDelete(FollowVO vo); // 언팔로우
	FollowVO followCount(); // 팔로우한 유저 수

}

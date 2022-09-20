package co.itrip.prj.follow.mapper;

import java.util.List;

import co.itrip.prj.follow.service.FollowVO;

public interface FollowMapper {
	
	List<FollowVO> followSelectList(); // 팔로우 전체조회
	int followInsert(FollowVO vo); // 팔로우
	int followDelete(FollowVO vo); // 언팔로우
	FollowVO followCount();  // 팔로우한 유저 수
}

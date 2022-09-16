package co.itrip.prj.member.community.mapper;

import java.util.List;

import co.itrip.prj.member.community.service.CommunityVO;

public interface CommunityMapper {
	List<CommunityVO> communityList(); //게시글 리스트 출력
}

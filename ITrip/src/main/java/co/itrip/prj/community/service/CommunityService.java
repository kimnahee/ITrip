package co.itrip.prj.community.service;

import java.util.List;

import com.github.pagehelper.Page;

public interface CommunityService {
	List<CommunityVO> communityList(); //게시글 리스트 출력
	CommunityVO selectCommunity(CommunityVO vo); //게시글 조회
	
	//스터디게시판
	List<CommunityVO> studyList(); //스터디게시판 전체조회
	int studyInsert(CommunityVO vo);//스터디게시판 게시글 작성
	int studyUpdate(CommunityVO vo);//스터디게시판 게시글 수정
	int studyDelete(CommunityVO vo);//스터디게시판 게시글 삭제
	
	//페이징 처리
	List<CommunityVO> findAll();
	List<CommunityVO> findStudy();
}

package co.itrip.prj.community.mapper;

import java.util.List;

import co.itrip.prj.community.service.CommunityVO;
import co.itrip.prj.community.service.ReplyVO;
 
public interface CommunityMapper {
	List<CommunityVO> communityList(); //게시글 리스트 출력
	CommunityVO selectCommunity(CommunityVO vo); //게시글 조회
	
	//스터디게시판
	List<CommunityVO> studyList(); //스터디게시판 전체조회
	int studyInsert(CommunityVO vo);//스터디게시판 게시글 작성
	int studyUpdate(CommunityVO vo);//스터디게시판 게시글 수정
	
	//자유게시판
	List<CommunityVO> freeList();//자유게시판 전체조회
	int freeInsert(CommunityVO vo);//자유게시판 게시글 작성
	int freeUpdate(CommunityVO vo);//자유게시판 게시글 수정
	
	int studyDelete(CommunityVO vo);//게시글 삭제
	int commHitUpdate(CommunityVO vo);//조회수 처리

	//페이징 처리
	List<CommunityVO> findAll(CommunityVO vo);
	
	//댓글
	List<ReplyVO> replyList(ReplyVO vo);//댓글 목록
	int replyInsert(ReplyVO vo);//댓글 등록
	int replyUpdate(ReplyVO vo);//댓글 수정
	int replyDelete(ReplyVO vo);//댓글 삭제
}

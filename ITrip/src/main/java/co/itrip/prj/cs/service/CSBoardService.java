package co.itrip.prj.cs.service;

import java.util.List;

import co.itrip.prj.community.service.CommunityVO;

public interface CSBoardService {
	//페이징 처리(전체 리스트 출력)
	List<CSBoardVO> findAll(CSBoardVO vo); //전체 게시판 페이징(카테고리 구분)
	
	CSBoardVO selectCs(CSBoardVO vo);//단건조회
	int csInsert(CSBoardVO vo);//게시글 작성
	int csUpdate(CSBoardVO vo);//게시글 수정
	int csDelete(CSBoardVO vo);//게시글 삭제
}

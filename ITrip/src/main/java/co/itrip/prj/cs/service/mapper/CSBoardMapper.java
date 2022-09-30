package co.itrip.prj.cs.service.mapper;

import java.util.List;

import co.itrip.prj.cs.service.CSBoardVO;

public interface CSBoardMapper {
	//페이징 처리(전체 리스트 출력)
	List<CSBoardVO> findAll(CSBoardVO vo); //전체 게시판 페이징
	
	CSBoardVO selectCs(CSBoardVO vo);//단건조회
	int csInsert(CSBoardVO vo);//게시글 작성
	int csUpdate(CSBoardVO vo);//게시글 수정
	int csDelete(CSBoardVO vo);//게시글 삭제
	int csHitUpdate(CSBoardVO vo);//조회수 처리
	
	int repInsert(CSBoardVO vo); //답글 작성
	int repUpdate(CSBoardVO vo); //답글 상태 수정
}

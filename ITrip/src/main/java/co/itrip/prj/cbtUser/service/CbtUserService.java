package co.itrip.prj.cbtUser.service;

import java.util.List;

public interface CbtUserService {
	//List<CbtUserVO> cbtUserList(CbtUserVO vo);//모든 cbt문제리스트 
	CbtUserVO cbtUserSelectOne(CbtUserVO vo);//문제1건 선택해서 풀기 
	int cbtUserInsert(CbtUserVO vo); //문제등록 
	CbtUserVO ajaxQuestion(CbtUserVO vo);//채점 
	List<CbtUserVO> cbtUserMyList(CbtUserVO vo);//내가낸문제리스트 
	CbtUserVO cbtUserMyOne(CbtUserVO vo); //내가낸문제1건상세보기
	int cbtUserMyUpdate(CbtUserVO vo); //내가낸문제1건수정하기 
	int cbtUserMyDelete(CbtUserVO vo); //내가낸문제1건삭제하기 
}

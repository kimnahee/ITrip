package co.itrip.prj.cbtUser.mapper;

import java.util.List;

import co.itrip.prj.cbtUser.service.CbtUserVO;

public interface CbtUserMapper {
//	List<CbtUserVO> cbtUserList(CbtUserVO vo);
	CbtUserVO cbtUserSelectOne(CbtUserVO vo);
	int cbtUserInsert(CbtUserVO vo);
	CbtUserVO ajaxQuestion(CbtUserVO vo);
	
	List<CbtUserVO> cbtUserMyList(CbtUserVO vo); //로그인한사람이 출제한 문제조회 
	CbtUserVO cbtUserMyOne(CbtUserVO vo); //문제1건상세보기 
	int cbtUserMyUpdate(CbtUserVO vo); //내가낸문제1건수정하기 
	int cbtUserMyDelete(CbtUserVO vo); //내가낸문제1건삭제하기 
}

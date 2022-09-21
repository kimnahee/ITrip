package co.itrip.prj.cbtUser.service;

import java.util.List;

public interface CbtUserService {
	List<CbtUserVO> cbtUserList(CbtUserVO vo);
	CbtUserVO cbtUserSelectOne(CbtUserVO vo);
	int cbtUserInsert(CbtUserVO vo);
	CbtUserVO ajaxQuestion(CbtUserVO vo);
}

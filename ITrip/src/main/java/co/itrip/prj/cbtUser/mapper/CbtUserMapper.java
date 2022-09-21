package co.itrip.prj.cbtUser.mapper;

import java.util.List;

import co.itrip.prj.cbtUser.service.CbtUserVO;

public interface CbtUserMapper {
	List<CbtUserVO> cbtUserList(CbtUserVO vo);
	CbtUserVO cbtUserSelectOne(CbtUserVO vo);
	int cbtUserInsert(CbtUserVO vo);
	CbtUserVO ajaxQuestion(CbtUserVO vo);
}

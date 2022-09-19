package co.itrip.prj.cbtUser.service;

import java.util.List;

public interface CbtUserService {
	List<CbtUserVO> cbtUserList(CbtUserVO vo);
	int cbtUserInsert(CbtUserVO vo);
}

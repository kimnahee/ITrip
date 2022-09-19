package co.itrip.prj.cbtUser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.cbtUser.mapper.CbtUserMapper;

@Service
public class CbtUserServiceImpl implements CbtUserService {
	@Autowired
	private CbtUserMapper map;

	@Override
	public List<CbtUserVO> cbtUserList(CbtUserVO vo) {
		return map.cbtUserList(vo);
	}

	@Override
	public int cbtUserInsert(CbtUserVO vo) {
		return map.cbtUserInsert(vo);
	}
	
	

}

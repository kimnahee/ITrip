package co.itrip.prj.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.cs.service.mapper.CSBoardMapper;

@Service
public class CSBoardServiceImpl implements CSBoardService {
	
	@Autowired
	private CSBoardMapper map;

	@Override
	public List<CSBoardVO> findAll(CSBoardVO vo) {
		return map.findAll(vo);
	}

	@Override
	public CSBoardVO selectCs(CSBoardVO vo) {
		return map.selectCs(vo);
	}

	@Override
	public int csInsert(CSBoardVO vo) {
		return map.csInsert(vo);
	}

	@Override
	public int csUpdate(CSBoardVO vo) {
		return map.csUpdate(vo);
	}

	@Override
	public int csDelete(CSBoardVO vo) {
		return map.csDelete(vo);
	}

	@Override
	public int repInsert(CSBoardVO vo) {
		return map.repInsert(vo);
	}

	@Override
	public int repUpdate(CSBoardVO vo) {
		return map.repUpdate(vo);
	}

}

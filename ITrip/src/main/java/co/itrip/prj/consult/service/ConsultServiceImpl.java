package co.itrip.prj.consult.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.consult.mapper.ConsultMapper;

@Service
public class ConsultServiceImpl implements ConsultService{

	@Autowired
	private ConsultMapper map;
	
	@Override
	public List<ConsultVO> consultList() {
		// 상담 전체조회
		return map.consultList();
	}

	@Override
	public List<ConsultVO> findAll(ConsultVO vo) {
		// TODO Auto-generated method stub
		return map.findAll(vo);
	}

	@Override
	public int consultInsert(ConsultVO vo) {
		// 상담신청
		return map.consultInsert(vo);
	}


}

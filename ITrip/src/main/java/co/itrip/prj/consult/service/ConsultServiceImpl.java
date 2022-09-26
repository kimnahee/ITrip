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
		// 전체조회 후 페이징처리
		return map.findAll(vo);
	}

	@Override
	public int consultInsert(ConsultVO vo) {
		// 가이드 상담 등록
		
		// consultInsert 처리가 먼저
		int n = map.consultInsert(vo);
		
		ConsultDtVO dtvo = new ConsultDtVO(); // ConsultDtVO 호출
		dtvo.setCdtNo(vo.getConsultNo()); // key 값 1번 상담의 내용
		
		// 상담 요일, 시간 등록
		for(int i=0; i < vo.getConsultDt().size(); i++) {
			if(vo.getConsultDt().get(i) != null) {
				dtvo.setWeek(vo.getConsultDt().get(i).getWeek());
				dtvo.setBeginTime(vo.getConsultDt().get(i).getBeginTime());
				dtvo.setEndTime(vo.getConsultDt().get(i).getEndTime());
				map.consultDtInsert(dtvo);
			}
		}
		
		
		return n;
	}

	@Override
	public int consultDtInsert(ConsultVO vo) {
		// 상담등록 시간 테이블
		return 0;
	}


}

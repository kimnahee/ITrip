package co.itrip.prj.consult.service;

import java.util.List;
import java.util.Map;

public interface ConsultService {

	List<ConsultVO> consultList();
	List<ConsultVO> findAll(ConsultVO vo); // 전체조회 페이징처리 
	ConsultVO consultSelectOne(ConsultVO vo); // 상담 단건조회
	
	int consultInsert(ConsultVO vo); // 가이드 상담 등록
	List<ConsultDtVO> consultDtList(ConsultDtVO vo);
	//int consultDtInsert(ConsultVO vo); // 가이드 상담 등록 시 DT테이블에 시간 추가
	

}

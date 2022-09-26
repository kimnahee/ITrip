package co.itrip.prj.consult.service;

import java.util.List;
import java.util.Map;

public interface ConsultService {

	List<ConsultVO> consultList();
	List<ConsultVO> findAll(ConsultVO vo); // 전체조회 페이징처리 
	
	int consultInsert(ConsultVO vo); // 가이드 상담 등록
	int consultDtInsert(ConsultVO vo); // 가이드 상담 등록 시 DT테이블에 시간 추가
	

}

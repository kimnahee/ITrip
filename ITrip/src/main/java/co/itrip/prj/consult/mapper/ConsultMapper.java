package co.itrip.prj.consult.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import co.itrip.prj.consult.service.ConsultDtVO;
import co.itrip.prj.consult.service.ConsultVO;

public interface ConsultMapper {

	List<ConsultVO> consultList(ConsultVO vo); // 가이드 마이페이지- 내가 등록한 상담 리스트 조회
	int consultInsert(ConsultVO vo); // 가이드 상담 등록
	int consultDtInsert(ConsultDtVO vo); // // 가이드 상담 등록 시 DT테이블(자식테이블)에 시간 추가
	int consultState(ConsultVO vo); // 가이드 마이페이지 - 상담 상태 수정 (활성화/비활성화) 
	
	List<ConsultVO> findAll(ConsultVO vo); // 상담 메인페이지 , 페이징처리, 카테고리별 검색기능
	ConsultVO consultSelectOne(ConsultVO vo); // 상담 단건조회
	List<ConsultDtVO> consultDtList(ConsultDtVO vo); // 상담 단건조회 (서비스에는 없음)
	
	List<ConsultVO> myConsultList(ConsultVO vo); // 마이페이지 상담 전체조회 - 소정

}

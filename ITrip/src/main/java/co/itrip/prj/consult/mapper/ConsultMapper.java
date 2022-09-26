package co.itrip.prj.consult.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import co.itrip.prj.consult.service.ConsultDtVO;
import co.itrip.prj.consult.service.ConsultVO;

public interface ConsultMapper {
	//@Select("select * from consult")
	List<ConsultVO> consultList(); // 상담 전체조회
	
	List<ConsultVO> findAll(ConsultVO vo); // 페이징처리
	
	int consultInsert(ConsultVO vo); // 가이드 상담 등록
	int consultDtInsert(ConsultDtVO vo); // 가이드 상담 시간 등록
	
	ConsultVO consultSelectOne(ConsultVO vo); // 상담 단건조회
	List<ConsultDtVO> consultDtList(ConsultDtVO vo);
}

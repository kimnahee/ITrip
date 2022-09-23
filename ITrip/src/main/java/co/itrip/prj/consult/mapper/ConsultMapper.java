package co.itrip.prj.consult.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import co.itrip.prj.consult.service.ConsultVO;

public interface ConsultMapper {
	//@Select("select * from consult")
	List<ConsultVO> consultList(); // 상담 전체조회
	
	List<ConsultVO> findAll(ConsultVO vo); // 페이징처리
	
	int consultInsert(ConsultVO vo); // 유저 상담 신청
	

}

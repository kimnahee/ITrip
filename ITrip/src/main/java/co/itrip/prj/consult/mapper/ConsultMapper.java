package co.itrip.prj.consult.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import co.itrip.prj.consult.service.ConsultChatVO;
import co.itrip.prj.consult.service.ConsultDtVO;
import co.itrip.prj.consult.service.ConsultVO;

public interface ConsultMapper {
	//@Select("select * from consult")
	List<ConsultVO> consultList(); // 상담 전체조회
	
	List<ConsultVO> findAll(ConsultVO vo); // 상담 메인페이지 , 페이징처리, 카테고리별 검색기능
	
	int consultInsert(ConsultVO vo); // 가이드 상담 등록
	int consultDtInsert(ConsultDtVO vo); // 가이드 상담 시간 등록
	
	ConsultVO consultSelectOne(ConsultVO vo); // 상담 단건조회
	List<ConsultDtVO> consultDtList(ConsultDtVO vo);
	
	List<ConsultVO> myConsultList(ConsultVO vo); // 마이페이지 상담 전체조회
	
	ConsultChatVO consultChat(ConsultChatVO vo); //채팅방 연결
}

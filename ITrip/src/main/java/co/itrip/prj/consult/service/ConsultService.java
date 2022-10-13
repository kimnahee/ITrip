package co.itrip.prj.consult.service;

import java.util.List;
import java.util.Map;

public interface ConsultService {

	List<ConsultVO> consultList(ConsultVO vo); // 가이드 마이페이지- 내가 등록한 상담 리스트 조회
	int consultInsert(ConsultVO vo); // 가이드 상담 등록
	List<ConsultDtVO> consultDtList(ConsultDtVO vo);  // 가이드 상담 등록 시 DT테이블(자식테이블)에 시간 추가
	int consultState(ConsultVO vo); // 가이드 마이페이지 - 상담 상태 수정 (활성화/비활성화) 
	
	
	List<ConsultVO> findAll(ConsultVO vo); // 상담 메인페이지 , 페이징처리, 카테고리별 검색기능
	ConsultVO consultSelectOne(ConsultVO vo); // 상담 단건조회
	
	
	
	List<ConsultVO> myConsultList(ConsultVO vo); // 마이페이지 상담 전체조회 - 소정
	
	
	
	
	
	
	ConsultDtVO ajaxConsultPrice(ConsultDtVO vo); //상담 신청시 가격 가져오기 -은지
	int consultTime(ConsultDtVO vo); // 상담 신청 시 시간 가져오기 - 은지
	
	ConsultChatVO consultChat(ConsultChatVO vo); //채팅방 연결
}

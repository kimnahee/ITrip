package co.itrip.prj.consult.mapper;

import java.util.List;
import co.itrip.prj.consult.service.ConsultChatVO;
import co.itrip.prj.consult.service.ConsultDtVO;
import co.itrip.prj.consult.service.ConsultVO;

/**
 * 
 * @author 박은지, 권소정, 김나희
 *
 */

public interface ConsultMapper {

	List<ConsultVO> consultList(ConsultVO vo); // 가이드 마이페이지- 내가 등록한 상담 리스트 조회 - 은지
	int consultInsert(ConsultVO vo); // 가이드 상담 등록 - 은지
	int consultDtInsert(ConsultDtVO vo); // // 가이드 상담 등록 시 DT테이블(자식테이블)에 시간 추가 - 은지
	int consultState(ConsultVO vo); // 가이드 마이페이지 - 상담 상태 수정 (활성화/비활성화) - 은지
	List<ConsultVO> alreadyConsult(ConsultVO vo); // 가이드가 신청한 상담 조회 - 은지
	List<ConsultVO> findAll(ConsultVO vo); // 상담 메인페이지 , 페이징처리, 카테고리별 검색기능 - 은지
	ConsultVO consultSelectOne(ConsultVO vo); // 상담 단건조회 - 은지
	List<ConsultDtVO> consultDtList(ConsultDtVO vo); // 상담 단건조회 (서비스에는 없음) - 은지
	

	List<ConsultVO> myConsultList(ConsultVO vo); // 마이페이지 상담 전체조회 - 소정

	ConsultDtVO ajaxConsultPrice(ConsultDtVO vo); //상담 신청시 가격 가져오기 (서비스에는 없음) -은지
	int consultTime(ConsultDtVO vo); // 상담 신청 시 시간 가져오기 - 은지
	ConsultChatVO consultChat(ConsultChatVO vo); //채팅방 연결 - 나희
	
}

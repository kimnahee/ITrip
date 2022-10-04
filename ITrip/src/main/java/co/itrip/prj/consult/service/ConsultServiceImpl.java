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
	public List<ConsultVO> consultList(ConsultVO vo) {
		// 상담 전체조회
		return map.consultList(vo);
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
		System.out.println(n);
		// 상담 요일, 시간 등록
		System.out.println(vo.getConsultDt());

		for (ConsultDtVO dtVO : vo.getConsultDt()) {
			System.out.println(dtVO);
			if (!dtVO.getBeginTime().isEmpty()) {
				dtVO.setConsultNo(vo.getConsultNo());
				map.consultDtInsert(dtVO);
			}
		}
		return n;
	}

	@Override
	public ConsultVO consultSelectOne(ConsultVO vo) {
		// 상담 단건조회
		/*
		 * ConsultDtVO dtvo = new ConsultDtVO(); // ConsultDtVO 호출을 위한 인스턴스 생성
		 * dtvo.setCdtNo(vo.getConsultNo()); // 부모테이블 글번호 담기 map.consultDtList(dtvo); //
		 * 글번호를 토대로 자식
		 */		return map.consultSelectOne(vo);
	}

	@Override
	public List<ConsultDtVO> consultDtList(ConsultDtVO vo) {
		// 시간 출력
		return map.consultDtList(vo);
	}

	@Override
	public List<ConsultVO> myConsultList(ConsultVO vo) {
		// 마이페이지 상담 전체조회
		return map.myConsultList(vo);
	}


	@Override
	public int consultState(ConsultVO vo) {
		// 상담 상태 수정 (활성화, 비활성화)
		return map.consultState(vo);
	}

	@Override
	public ConsultChatVO consultChat(ConsultChatVO vo) {
		//채팅방 연결
		return map.consultChat(vo);
	}

}

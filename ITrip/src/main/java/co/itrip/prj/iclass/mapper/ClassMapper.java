package co.itrip.prj.iclass.mapper;

import java.util.List;

import co.itrip.prj.iclass.service.ClassAttendVO;

import co.itrip.prj.iclass.service.ClassChatVO;

import co.itrip.prj.iclass.service.ClassDtVO;
import co.itrip.prj.iclass.service.ClassVO;

public interface ClassMapper {
	
	List<ClassVO> classList(ClassVO vo); // 클래스 전체조회 소정,경아
	ClassVO classSelectOne(ClassVO vo); // 클래스 단건조회 경아
	int classInsert(ClassVO vo); // 클래스 추가 소정 
	int classDelete(ClassVO vo); // 클래스 삭제 -> 비활성화?
	
	List<ClassDtVO> classDtList(ClassDtVO vo); // 클래스시간 전체조회 경아
	ClassDtVO classDtSelectOne(ClassDtVO vo); // 클래스시간 단건조회 경아
	int classDtInsert(ClassDtVO vo); // 클래스시간 추가 소정
	int classDtDelete(ClassDtVO vo); // 클래스 시간 삭제
	

	List<ClassVO> ajaxJobSearch(ClassVO vo);
	
	List<ClassVO> myClassList(ClassVO vo); // 마이페이지 클래스 전체조회
	List<ClassVO> alreadyClass(ClassVO vo); // 가이드가 신청한 클래스 전체조회


	int classAttendInsert(ClassAttendVO vo);//클래스 결제 후 출석테이블에 출결0으로 추가

	
	ClassChatVO classChatLink(ClassChatVO vo); //채팅방 연결

}

package co.itrip.prj.iclass.service;

import java.util.List;

public interface ClassService {
	
	List<ClassVO> classList(ClassVO vo); // 클래스 전체조회
	ClassVO classSelectOne(ClassVO vo); // 클래스 단건조회
	int classInsert(ClassVO vo); // 클래스 추가
	int classDelete(ClassVO vo); // 클래스 삭제

	List<ClassDtVO> classDtList(ClassDtVO vo);
	List<ClassVO> ajaxJobSearch(ClassVO vo);
	               
	List<ClassVO> myClassList(ClassVO vo); // 마이페이지 클래스 전체조회 소정
	List<ClassAttendVO> myClassAttendList(ClassAttendVO vo); // 마이페이지클래스출석 전체조회
	

	List<ClassVO> alreadyClass(ClassVO vo); // 가이드가 신청한 클래스 전체조회
	

	int classAttendInsert(ClassAttendVO vo);//클래스 결제 후 출석테이블에 출결0으로 추가

	ClassChatVO classChatLink(ClassChatVO vo); //채팅방 연결
	int classChk(ClassAttendVO vo);//출석체크
	ClassAttendVO classAttendSelect(ClassAttendVO vo); // (if수업횟수=출석횟수) 소정
	int classAttendUpdate(ClassAttendVO vo); // 수료여부 소정

}

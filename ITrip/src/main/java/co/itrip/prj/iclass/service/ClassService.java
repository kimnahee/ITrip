package co.itrip.prj.iclass.service;

import java.util.List;

public interface ClassService {
	
	List<ClassVO> classList(ClassVO vo); // 클래스 전체조회
	ClassVO classSelectOne(ClassVO vo); // 클래스 단건조회
	int classInsert(ClassVO vo); // 클래스 추가
	int classDelete(ClassVO vo); // 클래스 삭제

	List<ClassDtVO> classDtList(ClassDtVO vo);
	List<ClassVO> ajaxJobSearch(ClassVO vo);
	
	List<ClassVO> myClassList(ClassVO vo); // 마이페이지 클래스 전체조회
	

}

package co.itrip.prj.iclass.service;

import java.util.List;

public interface ClassService {
	
	List<ClassVO> classSelectList(ClassVO vo); // 클래스 전체조회
	ClassVO classSelect(ClassVO vo); // 클래스 단건조회
	int classInsert(ClassVO vo); // 클래스 추가
	int classDelete(ClassVO vo); // 클래스 삭제

}

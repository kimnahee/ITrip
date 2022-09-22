package co.itrip.prj.iclass.mapper;

import java.util.List;

import co.itrip.prj.iclass.service.ClassVO;

public interface ClassMapper {
	List<ClassVO> classSelectList(ClassVO vo); // 클래스 전체조회
	ClassVO classSelect(ClassVO vo); // 클래스 단건조회
	int classInsert(ClassVO vo); // 클래스 추가
	int classDelete(ClassVO vo); // 클래스 삭제

}

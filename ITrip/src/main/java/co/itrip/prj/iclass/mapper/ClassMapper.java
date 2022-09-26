package co.itrip.prj.iclass.mapper;

import java.util.List;

import co.itrip.prj.iclass.service.ClassDtVO;
import co.itrip.prj.iclass.service.ClassVO;

public interface ClassMapper {
	
	List<ClassVO> classList(ClassVO vo); // 클래스 전체조회
	ClassVO classSelectOne(ClassVO vo); // 클래스 단건조회
	int classInsert(ClassVO vo); // 클래스 추가
	int classDelete(ClassVO vo); // 클래스 삭제
	
	List<ClassDtVO> classDtList(ClassDtVO vo); // 클래스시간 전체조회
	ClassDtVO classDtSelectOne(ClassDtVO vo); // 클래스시간 단건조회
	int classDtInsert(ClassDtVO vo); // 클래스시간 추가
	int classDtDelete(ClassDtVO vo); // 클래스 시간 삭제
	

}

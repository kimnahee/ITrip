package co.itrip.prj.iclass.mapper;

import java.util.List;

import co.itrip.prj.iclass.service.ClassDtVO;


public interface ClassDtMapper {
	
	List<ClassDtVO> classDtSelectList(ClassDtVO vo); 
	ClassDtVO classDtSelect(ClassDtVO vo);
	int classDtInsert(ClassDtVO vo);
	int classDtDelete(ClassDtVO vo);

}

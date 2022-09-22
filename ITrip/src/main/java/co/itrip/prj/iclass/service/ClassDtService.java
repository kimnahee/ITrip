package co.itrip.prj.iclass.service;

import java.util.List;

public interface ClassDtService {
	
	List<ClassDtVO> classDtSelectList(ClassDtVO vo); 
	ClassDtVO classDtSelect(ClassDtVO vo);
	int classDtInsert(ClassDtVO vo);
	int classDtDelete(ClassDtVO vo);
	

}

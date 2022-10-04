package co.itrip.prj.guide.service;

import java.util.List;

import co.itrip.prj.iclass.service.ClassVO;

/**
 * 
 * @author 박은지, 권소정
 *
 */


public interface GuideService {
	
	List<GuideVO> guideSelectList(); // 은지 - 가이드 전체조회
	GuideVO guideSelect(GuideVO vo); // 은지 - 가이드 단건조회
	int guideInsert(GuideVO vo); // 가이드 입력 
	int guideUpdate(GuideVO vo); // 은지 - 가이드 수정 
	
	List<ClassVO> userList(ClassVO vo); // 은지 - 클래스 수강생 리스트
	

}

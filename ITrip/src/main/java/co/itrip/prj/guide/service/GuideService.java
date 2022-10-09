package co.itrip.prj.guide.service;

import java.util.List;

import co.itrip.prj.iclass.service.ClassVO;

/**
 * 
 * @author 박은지, 권소정
 *
 */


public interface GuideService {
	
	GuideVO guideSelect(GuideVO vo); // 은지 - 가이드 마이페이지(단건조회)
	int guideInsert(GuideVO vo); //  소정 - 가이드 입력 
	int guideUpdate(GuideVO vo); // 은지 - 가이드 수정 
	
	List<ClassVO> userList(ClassVO vo); // 은지 - 클래스 수강생 리스트
	List<ClassVO> myIClassList(ClassVO vo); // 은지 - 가이드 마이클래스 전체조회

	int guideDelete(GuideVO vo); // 경아 - 가이드승인거절시 가이드테이블에서삭제 

}

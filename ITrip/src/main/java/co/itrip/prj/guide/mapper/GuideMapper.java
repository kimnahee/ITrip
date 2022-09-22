package co.itrip.prj.guide.mapper;

import java.util.List;

import co.itrip.prj.guide.service.GuideVO;

/**
 * 
 * @author 박은지, 권소정
 *
 */

public interface GuideMapper {
	
	List<GuideVO> guideSelectList(); // 가이드 전체조회
	GuideVO guideSelect(GuideVO vo); // 가이드 단건조회
	int guideInsert(GuideVO vo); // 가이드 입력
	int guideUpdate(GuideVO vo); // 가이드 수정
	int guideDelete(GuideVO vo); // 가이드 삭제

}

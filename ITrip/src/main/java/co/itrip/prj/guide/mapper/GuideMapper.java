package co.itrip.prj.guide.mapper;

import java.util.List;

import co.itrip.prj.guide.service.GuideVO;



public interface GuideMapper {
	
	List<GuideVO> guideSelectList();
	GuideVO guideSelect(GuideVO vo);
	int guideInsert(GuideVO vo);
	int guideUpdate(GuideVO vo);
	int guideDelete(GuideVO vo);

}

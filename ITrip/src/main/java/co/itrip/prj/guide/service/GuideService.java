package co.itrip.prj.guide.service;

import java.util.List;



public interface GuideService {
	
	List<GuideVO> guideSelectList();
	GuideVO guideSelect(GuideVO vo);
	int guideInsert(GuideVO vo);
	int guideUpdate(GuideVO vo);
	int guideDelete(GuideVO vo);

}

package co.itrip.prj.cbtCustom.service;

import java.util.List;

import co.itrip.prj.cbtGuide.service.CbtGuideVO;

public interface CbtCustomService {
	List<CbtGuideVO> cbtCustomMakeSelect(CbtCustomVO vo);
}

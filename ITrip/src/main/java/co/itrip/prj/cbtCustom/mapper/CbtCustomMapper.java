package co.itrip.prj.cbtCustom.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import co.itrip.prj.cbtCustom.service.CbtCustomVO;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;

public interface CbtCustomMapper {
	List<CbtGuideVO> cbtCustomMakeSelect(CbtCustomVO vo);

}

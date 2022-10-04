package co.itrip.prj.cbtCustom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.cbtCustom.mapper.CbtCustomMapper;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;

@Service
public class CbtCustomServiceImpl implements CbtCustomService {
	@Autowired
	CbtCustomMapper map;
	
	@Override
	public List<CbtGuideVO> cbtCustomMakeSelect(CbtCustomVO vo) {
		return map.cbtCustomMakeSelect(vo);
	}

}

package co.itrip.prj.cbtGuide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.cbtGuide.mapper.CbtGuideMapper;

@Service
public class CbtGuideServiceImpl implements CbtGuideService {
	
	@Autowired
	private CbtGuideMapper map;

	@Override
	public List<CbtGuideVO> cbtGuideList() {
		return map.cbtGuideList();
	}

	@Override
	public CbtGuideVO cbtGuideListOne(CbtGuideVO VO) {
		return map.cbtGuideListOne(VO);
	}

	@Override
	public int cbtGuideInsert(CbtGuideVO VO) {
		return map.cbtGuideInsert(VO);
	}

	@Override
	public int cbtGuideUpdate(CbtGuideVO VO) {
		return map.cbtGuideUpdate(VO);
	}

	@Override
	public int cbutGuideDelet(CbtGuideVO VO) {
		return map.cbutGuideDelet(VO);
	}

}

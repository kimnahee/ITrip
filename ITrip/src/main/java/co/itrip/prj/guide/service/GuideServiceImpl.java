package co.itrip.prj.guide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.guide.mapper.GuideMapper;

@Service
public class GuideServiceImpl implements GuideService {

	@Autowired
	private GuideMapper map;
	
	@Override
	public List<GuideVO> guideSelectList() {
		// TODO Auto-generated method stub
		return map.guideSelectList();
	}

	@Override
	public GuideVO guideSelect(GuideVO vo) {
		// TODO Auto-generated method stub
		return map.guideSelect(vo);
	}

	@Override
	public int guideInsert(GuideVO vo) {
		// TODO Auto-generated method stub
		return map.guideInsert(vo);
	}

	@Override
	public int guideUpdate(GuideVO vo) {
		// TODO Auto-generated method stub
		return map.guideUpdate(vo);
	}

	@Override
	public int guideDelete(GuideVO vo) {
		// TODO Auto-generated method stub
		return map.guideDelete(vo);
	}

}

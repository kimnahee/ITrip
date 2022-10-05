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

	@Override
	public int cbtCustomHderInsert(CbtCustomHderVO vo) {
		//int r = map.cbtCustomHderInsert(vo); // 먼저 myCbtHder 등록함
	//	map.cbtCustomHderChkUpdate(vo);
		//map.cbtCustomHderList(vo);
		return map.cbtCustomHderInsert(vo);
		
	}

	@Override
	public int selectMcNo() {
		return map.selectMcNo();
	}

	@Override
	public List<CbtCustomHderVO> cbtCustomHderList(CbtCustomHderVO vo) {
		return map.cbtCustomHderList(vo);
	}

	@Override
	public int cbtCustomHderChkUpdate(CbtCustomHderVO vo) {
		return map.cbtCustomHderChkUpdate(vo);
	}

	@Override
	public List<CbtGuideVO> cbtCustomListO(CbtGuideVO vo) {
		return map.cbtCustomListO(vo);
	}

	@Override
	public List<CbtGuideVO> cbtCustomListX(CbtGuideVO vo) {
		return map.cbtCustomListX(vo);
	}


}

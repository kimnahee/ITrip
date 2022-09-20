package co.itrip.prj.cbtGuide.service;

import java.util.ArrayList;
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
	public CbtGuideVO cbtGuideListOne(CbtGuideVO vo) {
		return map.cbtGuideListOne(vo);
	}

	@Override
	public int cbtGuideInsert(CbtGuideVO vo) {
		// cbt등록
		
		//키워드 등록
		String[] kLists = new String[vo.getKeyword().size()];
		String kList = "";
		
		System.out.println(kLists);
		
		/*
		 * for(int i=0; i < vo.getKeyword().size(); i++) { kLists[i] =
		 * vo.KeywordInsert(vo.getKeyword().get(i)); }
		 */
		
		return map.cbtGuideInsert(vo);
	}

	@Override
	public int cbtGuideUpdate(CbtGuideVO vo) {
		return map.cbtGuideUpdate(vo);
	}

	@Override
	public int cbutGuideDelet(CbtGuideVO vo) {
		return map.cbutGuideDelet(vo);
	}

	@Override
	public List<CbtGuideVO> cbtGuideListTab(CbtGuideVO vo) {
		return map.cbtGuideListTab(vo);
	}

	@Override
	public CbtGuideVO ajaxExplnaList(CbtGuideVO vo) {
		return map.ajaxExplnaList(vo);
	}

	@Override
	public int KeywordInsert(CbtGuideVO vo) {
		return 0;
	}

	@Override
	public int KeywordList(CbtGuideVO vo) {
		return 0;
	}

}

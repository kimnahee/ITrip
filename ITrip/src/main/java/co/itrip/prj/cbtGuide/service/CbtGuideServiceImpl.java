package co.itrip.prj.cbtGuide.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.cbtGuide.mapper.CbtGuideMapper;

@Service
public class CbtGuideServiceImpl implements CbtGuideService {
	
	@Autowired
	private CbtGuideMapper map;
	
	//전체조회
	@Override
	public List<CbtGuideVO> cbtGuideList() {
		return map.cbtGuideList();
	}
	
	//단건 조회
	@Override
	public CbtGuideVO cbtGuideListOne(CbtGuideVO vo) {
		return map.cbtGuideListOne(vo);
	}
	
	//문제 등록
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
	
	//문제수정
	@Override
	public int cbtGuideUpdate(CbtGuideVO vo) {
		return map.cbtGuideUpdate(vo);
	}
	
	//문제 삭제
	@Override
	public int cbutGuideDelet(CbtGuideVO vo) {
		return map.cbutGuideDelet(vo);
	}
	
	//유형별, 언어별 문제 출력
	@Override
	public List<CbtGuideVO> cbtGuideListTab(CbtGuideVO vo) {
		return map.cbtGuideListTab(vo);
	}
	
	//ajax로 풀이 출력
	@Override
	public CbtGuideVO ajaxExplnaList(CbtGuideVO vo) {
		return map.ajaxExplnaList(vo);
	}
	
	//키워드 등록
	@Override
	public int KeywordInsert(CbtGuideVO vo) {
		return 0;
	}
	
	//키워드 조회
	@Override
	public int KeywordList(CbtGuideVO vo) {
		return 0;
	}
	
	//내 cbt에 등록
	@Override
	public int myCbtHderInsert(MyCbtHderVO vo) {
		return map.myCbtHderInsert(vo);
	}
	
	//등록된 내 cbt정보와 cbt_guide의 정보 비교해서 조회
	@Override
	public List<HashMap<String, String>> myCbtHerMapList() {
		// TODO Auto-generated method stub
		return null;
	}
	//등록된 내 cbt정보와 cbt_guide의 정보 비교해서 조회
	@Override
	public List<HashMap<String, String>> cbtGuideMapList() {
		// TODO Auto-generated method stub
		return null;
	}
	//등록된 내 cbt정보와 cbt_guide의 정보 비교해서 조회한 결과 등록 
	@Override
	public int myCbtchekInsert() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//채점결과 조회
	@Override
	public List<HashMap<String, String>> myCbtchekList() {
		// TODO Auto-generated method stub
		return null;
	}

}

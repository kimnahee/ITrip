package co.itrip.prj.cbtGuide.service;

import java.util.List;
import java.util.Map;

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
		//문제 등록
		int r = map.cbtGuideInsert(vo); //keyword 등록하기위해선 cbtGuideInsert 처리가 먼저 되어야함
		
		CbtKeywordVO kvo = new CbtKeywordVO(); //keyword 호출
		kvo.setCbtNo(vo.getCbtNo());
		
		//키워드 등록
		for(int i=0; i < vo.getKeyword().size(); i++) { 
			if(vo.getKeyword().get(i) != null) {
				kvo.setCKwrd(vo.getKeyword().get(i));
				map.KeywordInsert(kvo); 
			}
		}
		return r; 
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
	
	//키워드 조회
	@Override
	public int KeywordList(CbtKeywordVO vo) {
		return 0;
	}
	
	//내 cbt에 등록
	@Override
	public int myCbtHderInsert(MyCbtHderVO vo) {
		int r = map.myCbtHderInsert(vo); // 먼저 내CBT에 등록한다.
		map.myCbtHderChkUpdate(vo); // 등록된 내 CBT와 기존의 CBT를 비교하여 정답유무를 체크한다
		map.myCbtHderList(vo);  // 리스트 출력
		map.chkCuntUpdate(vo); // 정답과 오답 카운트 업데이트한다
		return r;
	}

	@Override
	public MyCbtHderVO myCbtHderList(MyCbtHderVO vo) {
		return map.myCbtHderList(vo);
	}

	@Override
	public List<Map<Integer, Object>> cbtGuideListFive(CbtGuideVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


	

}

package co.itrip.prj.cbtGuide.mapper;

import java.util.List;

import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.MyCbtHderVO;

public interface CbtGuideMapper {
	// 가이드가 등록한 문제 CRUD
		List<CbtGuideVO> cbtGuideList();//전체조회(R)
		List<CbtGuideVO> cbtGuideListTab(CbtGuideVO vo); //탭 클릭시 유형별, 언어별로 조회
		CbtGuideVO cbtGuideListOne(CbtGuideVO vo);//단건조회(R)
		public int cbtGuideInsert(CbtGuideVO vo); //등록(C)
		public int cbtGuideUpdate(CbtGuideVO vo); //수정(U)
		public int cbutGuideDelet(CbtGuideVO vo);//삭제(D)
		//정답률
		public CbtGuideVO ajaxExplnaList(CbtGuideVO vo); // 풀이 단건 리스트
		public int myCbtHderInsert(MyCbtHderVO vo); // myCBtHder에 담기
		public int KeywordInsert();
		public int KeywordList();
}

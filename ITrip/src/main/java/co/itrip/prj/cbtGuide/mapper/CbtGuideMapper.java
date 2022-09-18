package co.itrip.prj.cbtGuide.mapper;

import java.util.List;

import co.itrip.prj.cbtGuide.service.CbtGuideVO;

public interface CbtGuideMapper {
	// 가이드가 등록한 문제 CRUD
		List<CbtGuideVO> cbtGuideList();//전체조회(R)
		List<CbtGuideVO> cbtGuideListTab(CbtGuideVO vo); //탭 클릭시 유형별, 언어별로 조회
		CbtGuideVO cbtGuideListOne(CbtGuideVO VO);//단건조회(R)
		public int cbtGuideInsert(CbtGuideVO VO); //등록(C)
		public int cbtGuideUpdate(CbtGuideVO VO); //수정(U)
		public int cbutGuideDelet(CbtGuideVO VO);//삭제(D)
		//정답률
		

}

package co.itrip.prj.cbtGuide.mapper;

import java.util.List;
import java.util.Map;

import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.CbtKeywordVO;
import co.itrip.prj.cbtGuide.service.MyCbtHderVO;
import co.itrip.prj.cbtGuide.service.MyCbtLongVO;
import co.itrip.prj.gtpcd.service.GtpCdVO;

/**
* 가이드CBT Mapping
* @author 김하은
* @date 2022.09.16
* @version 1.6
*/
public interface CbtGuideMapper {
	    
		List<CbtGuideVO> cbtGuideList();           /* 가이드가 등록한 모든 문제 출력 */
		List<CbtGuideVO> cbtGuideMyList(CbtGuideVO vo);         /* 가이드 한 명의 등록한 문제 출력 */
		CbtGuideVO cbtGuideListOne(CbtGuideVO vo); /* 문제 한 건 조회 */
		List<CbtGuideVO> cbtGuideListTab(CbtGuideVO vo); /* 문제 조회 : 공통코드 (유형, 언어) 필터를 거쳐 출력 */
		List<Map<Integer,Object>> cbtGuideListFive(MyCbtHderVO vo); /* 사용자가 푼제 5개 조회 */ 
		MyCbtHderVO myCbtHderList(MyCbtHderVO vo); /* 내가 푼 문제 등록 */
		List<CbtGuideVO> cbtGuideListO(CbtGuideVO vo); /* 문제 조회 : 사용자가 푼 문제 중 정답처리 된 문제조회 */
		List<CbtGuideVO> cbtGuideListX(CbtGuideVO vo); /* 문제 조회 : 사용자가 푼 문제 중 정답처리 된 오답조회 */
		public List<CbtKeywordVO> keywordList(CbtKeywordVO vo); /* 키워드 조회 */
		public int KeywordListCount(CbtKeywordVO vo); /* 키워드 갯수 조회 */
		public GtpCdVO gtpNameList(String gtpNo); /* 사용자가 푼 문제 리스트의 유형 코드네임 출력 */
		
		public int cbtGuideInsert(CbtGuideVO vo);   /* 문제 등록 */
		public int cbtGuideUpdate(CbtGuideVO vo);   /* 문제 수정 */ 
		public int keywordUpdate(CbtKeywordVO vo);  /* 키워드 수정 */
		public int cbutGuideDelet(CbtGuideVO vo);   /* 문제 삭제 */
		public int keywordDelete(CbtGuideVO vo);    /* 키워드 삭제 */ 
		public int myCbtHderInsert(MyCbtHderVO vo); /* 사용자가 푼 문제 등록 */
		public int keywordInsert(CbtKeywordVO kvo); /* 키워드 등록 */ //mapper에만 있음
		
		public int myCbtHderChkUpdate(MyCbtHderVO vo); /* 정답 체크 등록 */ //mapper에만 있음
		
		public int chkCuntUpdate(MyCbtHderVO vo); /* 정답카운트 조회 */
		
		/* 정답률 */
		/* 2022.09.26 ajax 처리*/
		public MyCbtLongVO ajaxMyCbtLongList(MyCbtLongVO myVo); /* 객관식 문제 채점시 ajax로 정답 출력 */
		public int ajaxMyCbtLongInsert(MyCbtLongVO vo); /* 사용자가 푼 서술형 문제 등록 */
		public int ajaxMyCbtLongChkList(CbtGuideVO vo); /* REGEXP_COUNT를 이용하여 사용자가 입력한 값과 키워드를 비교하여 키워드 기준으로 존재하면 1 없으면 0 출력*/
		public int ajaxMyCbLongChkUpdate(Map<String,Integer> map); /*  사용자가 입력한 값과 가이드가 등록한 키워드들을 비교하여(AND) 정답유무 처리 */
}

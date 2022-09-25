package co.itrip.prj.cbtGuide.service;

import java.util.List;
import java.util.Map;

/**
* 가이드CBT 구현시 필요한 기능을 기재
* @author 김하은
* @date 2022.09.16
* @version 1.6
*/
public interface CbtGuideService {
	

	
	List<CbtGuideVO> cbtGuideList();           /* 가이드가 등록한 모든 문제 출력 */
	CbtGuideVO cbtGuideListOne(CbtGuideVO vo); /* 문제 한 건 조회 */
	List<CbtGuideVO> cbtGuideListTab(CbtGuideVO vo); /* 문제 조회 : 공통코드 (유형, 언어) 필터를 거쳐 출력 */
	List<Map<Integer,Object>> cbtGuideListFive(MyCbtHderVO vo); /* 사용자가 푼제 5개 조회 */ 
	MyCbtHderVO myCbtHderList(MyCbtHderVO vo); /* 내가 푼 문제 조회 */
	public List<Map<Integer, Object>> cbtGuideListO(CbtGuideVO vo); /* 문제 조회 : 사용자가 푼 문제 중 정답처리 된 문제조회 */
	public List<Map<Integer, Object>> cbtGuideListX(CbtGuideVO vo); /* 문제 조회 : 사용자가 푼 문제 중 정답처리 된 오답조회 */
	
	
	public CbtKeywordVO keywordList(CbtKeywordVO vo); /* 키워드 조회 */ //작업 아직 X
	
	public int cbtGuideInsert(CbtGuideVO vo);   /* 문제 등록 */
	public int cbtGuideUpdate(CbtGuideVO vo);   /* 문제 수정 */ //작업 아직 X
	public int cbutGuideDelet(CbtGuideVO vo);   /* 문제 삭제 */ //작업 아직 X
	public int myCbtHderInsert(MyCbtHderVO vo); /* 사용자가 푼 문제 등록 */

	
	/* 정답률 */
	
	public CbtGuideVO ajaxExplnaList(CbtGuideVO vo); /* 객관식 문제 채점시 ajax로 풀이 출력 */
}

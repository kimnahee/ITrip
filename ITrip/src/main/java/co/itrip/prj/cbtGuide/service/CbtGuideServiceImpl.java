package co.itrip.prj.cbtGuide.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.cbtGuide.mapper.CbtGuideMapper;

/**
 * 가이드CBT 구현시 필요한 기능을 구체적으로 기재
 * 
 * @author 김하은
 * @date 2022.09.16
 * @version 2.1 , 2022.09.23 가이드가 문제 제출시 테이블 두개
 * 
 */
@Service
public class CbtGuideServiceImpl implements CbtGuideService {

	@Autowired
	private CbtGuideMapper map;

	/* 가이드가 등록한 모든 문제 출력 */
	@Override
	public List<CbtGuideVO> cbtGuideList() {
		return map.cbtGuideList();
	}

	/* 문제 한 건 조회 */
	@Override
	public CbtGuideVO cbtGuideListOne(CbtGuideVO vo) {
		return map.cbtGuideListOne(vo);
	}

	/* 문제 등록 */
	@Override
	public int cbtGuideInsert(CbtGuideVO vo) {
		/* 2022.09.23 가이드가 서술형 문제 등록 시 CBT_GUIDE와 CBT_KEYWORD 두 개의 테이블에 한 번에 처리 */

		/* 서술형 문제 등록 */
		int r = map.cbtGuideInsert(vo); // keyword 등록하기위해선 cbtGuideInsert 처리가 먼저 되어야함

		CbtKeywordVO kvo = new CbtKeywordVO(); // keyword 인스턴스 생성
		kvo.setCbtNo(vo.getCbtNo()); // CBT_KEYWORD의 FK인 CBT_NO를 CBT_GUIDE CBT_NO에서 가져와 담음

		/* 키워드 등록 */
		// 입력 받은 vo.getKeyword 갯수만큼 반복문 실행

		if (vo.getKeyword() != null) {
			for (int i = 0; i < vo.getKeyword().size(); i++) {
				if (vo.getKeyword().get(i) != null) { // 여러값 입력 시 null이 들어갈 수 있으므로 처리
					kvo.setCKwrd(vo.getKeyword().get(i)); // vo.getKeyword()에 담긴 것들을 i만큼 돌면서 대입
					map.keywordInsert(kvo); // Mapping된 메소드 찾아 실행
				}
			}
		}
		return r;
	}

	/* 문제 수정 : 마이페이지에서 문제를 조회해서 수정할 예정 */
	@Override
	public int cbtGuideUpdate(CbtGuideVO vo) {
		return map.cbtGuideUpdate(vo);
	}

	/* 문제 삭제 : 마이페이지에서 문제를 조회해서 삭제할 예정 */
	@Override
	public int cbutGuideDelet(CbtGuideVO vo) {
		return map.cbutGuideDelet(vo);
	}

	/* 문제 조회 : 공통코드 (유형, 언어) 필터를 거쳐 출력 */
	@Override
	public List<CbtGuideVO> cbtGuideListTab(CbtGuideVO vo) {
		return map.cbtGuideListTab(vo);
	}

	/* 2022.09.26 객관식 문제 ajax로 전부 처리 */
	@Override
	public CbtGuideVO ajaxMyCbtLongList(CbtGuideVO vo) {
		
		/* 사용자가 입력한 값 등록*/
		MyCbtLongVO myVo = new MyCbtLongVO(); // MyCbtLongVO 인스턴스 생성
		map.ajaxMyCbtLongInsert(myVo); // 등록 (파라미터 값 : mcKwrd, cbtNo)
		
		/*사용자가 등록한 값과 키워드의 값 비교 */
		CbtKeywordVO kvo = new CbtKeywordVO();
		kvo.setCbtNo(vo.getCbtNo());
		map.ajaxMyCbtLongChkList(vo); // 키워드 기준으로 사용자의 답이 있으면 0, 없으면 1 반환(복수형태)
		// return 값이 CbtKeywordVO의 List<Integer>chklist 필드에 담김..?
		
		
		Map<String, Object> param = new HashMap<>();
		
		for (int i = 0; i < vo.getKeyword().size(); i++) {
			if (kvo.getChklist().get(i) != null) { // 여러값 입력 시 null이 들어갈 수 있으므로 처리
				if (kvo.getChklist().get(i) == 0) {
					param.put("chkOX", 0); // 오답처리
				} else {
					
				    param.put("chkOX", 1); // 정답처리
				}
			}
		}
		/* 정답유무 처리 업데이트 0 또는 1*/
		map.ajaxMyCbLongChkUpdate(myVo); 
		return map.ajaxMyCbtLongList(vo);
	} 

	/* 키워드 조회 */
	@Override
	public CbtKeywordVO keywordList(CbtKeywordVO vo) {
		return map.keywordList(vo);
	}

	/* 사용자가 푼 문제 등록 */
	@Override
	public int myCbtHderInsert(MyCbtHderVO vo) {
		/* 2022.09.23 가이드가 등록한 CBT 문제의 정답과 내가 입력한 답을 비교하기 위해 myCbtHder 테이블에 등록해야한다 */

		int r = map.myCbtHderInsert(vo); // 먼저 myCbtHder 등록함
		map.myCbtHderChkUpdate(vo); // 등록된 myCbtHder 정보와 기존의 CBT를 비교하여 정답유무를 체크함
		map.myCbtHderList(vo); // 리스트 출력
		map.chkCuntUpdate(vo); // 정답 갯수와 오답 갯수 업데이트함.

		/* 2022.09.26 Insert버튼 : 등록 + 출력 한꺼번에 처리 */
		CbtGuideVO cvo = new CbtGuideVO(); // CbtGuide 호출을 위해 인스턴스 생성
		cvo.setMcNo(vo.getMcNo()); // 사용자가 푼 문제 담기
		map.cbtGuideListO(cvo); // 맞은 문제 출력
		map.cbtGuideListX(cvo); // 틀린 문제 출력

		return r;
	}

	/* 내가 푼 문제 단 건 조회 */
	@Override
	public MyCbtHderVO myCbtHderList(MyCbtHderVO vo) {
		return map.myCbtHderList(vo);
	}

	/* 사용자가 푼제 5개 조회 */
	@Override
	public List<Map<Integer, Object>> cbtGuideListFive(MyCbtHderVO vo) {
		/* 2022.09.23 map을 이용해 사용자가 푼 문제의 번호를 찾아 출력 */

		// 사용자가 푼 문제 1~5번의 번호를 찾아 정보를 조회하기 위해 Map 인스턴스 생성
		Map<String, Object> param = new HashMap<>();

		// 받아온 값을 map에 담음
		param.put("cbtNo1", vo.getCbtNo1());
		param.put("cbtNo2", vo.getCbtNo2());
		param.put("cbtNo3", vo.getCbtNo3());
		param.put("cbtNo4", vo.getCbtNo4());
		param.put("cbtNo5", vo.getCbtNo5());

		return map.cbtGuideListFive(vo); // Map에 저장된 값이 Mapper.xml로 넘어감
	}
	
	/* 문제 조회 : 사용자가 푼 문제 중 정답처리 된 문제조회 */
	@Override
	public List<CbtGuideVO> cbtGuideListO(CbtGuideVO vo) {
		 /*2022.09.26 map을 이용해 사용자가 푼 문제의 번호를 담아 맞은 문제 출력*/ 
		  //Map < String, Object > param = new HashMap < > (); 
		  //param.put("mcNo", vo.getMcNo()); return
		return map.cbtGuideListO(vo);
	}

	/* 문제 조회 : 사용자가 푼 문제 중 오답처리 된 문제조회 */
	@Override
	public List<CbtGuideVO> cbtGuideListX(CbtGuideVO vo) {
		return map.cbtGuideListX(vo);
	}


	

	
	 

}

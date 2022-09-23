package co.itrip.prj.consult.service;

import java.util.List;
import java.util.Map;

public interface ConsultService {
	
	// 조인 또는 vo 객체를 만들지 않고 사용할때 프로젝트 20220825 noticeService 참고
	//List<Map<String, Object>> consultList(); // 상담 전체조회 
	// key: 컬럼명 객체타입에 상관없이 value를 받아오려고 object객체로 받음 key를 불러야 value가 나와서 key를 jsp에서 부름
	// 리스트구조와 맵객체를 이용해서 vo객체와 테이블객체가 다르거나 전달할때 vo와 받을때 vo가 조인해서 다를 경우
		// VO는 1:1로 맵핑되어야하는데 해결할 방법이 없을때 마이바티스 메뉴얼을 보면 1.MAP을 만들어서하거나 2.VO의 VO를 상속받아서 하거나 MAP을 사용하는게 더 쉬움
	
	/* 
	 * // 웹개발 List<ConsultVO> webList(); // 전체조회 // 프론트엔드 List<ConsultVO>
	 * frontList(); // 전체조회 // 백엔드 List<ConsultVO> backList(); // 전체조회 // 풀스택
	 * List<ConsultVO> fullList(); // 전체조회 // 데이터베이스 List<ConsultVO> dataList(); //
	 * 전체조회 // 자격증 // 개발도구 // 취업.이직 // 기타
	 */	
	
	List<ConsultVO> consultList();

	List<ConsultVO> findAll(ConsultVO vo); // 페이징처리
	
	
	int consultInsert(ConsultVO vo); // 유저 상담 신청

}

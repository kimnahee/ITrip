package co.itrip.prj.cbtCustom.mapper;

import java.util.List;

import co.itrip.prj.cbtCustom.service.CbtCustomHderVO;
import co.itrip.prj.cbtCustom.service.CbtCustomVO;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;

public interface CbtCustomMapper {
	List<CbtGuideVO> cbtCustomMakeSelect(CbtCustomVO vo);//선택한값으로 문제지생성
	int cbtCustomHderInsert(CbtCustomHderVO vo); //제출하기버튼 누르면 문제지등록
	int selectMcNo();//문제지번호 max불러오기
	int cbtCustomHderChkUpdate(CbtCustomHderVO vo); //비교해서정답체크
	List<CbtCustomHderVO> cbtCustomHderList(CbtCustomHderVO vo); //문제지목록 가져오기

	List<CbtGuideVO> cbtCustomListO(CbtGuideVO vo);
	List<CbtGuideVO> cbtCustomListX(CbtGuideVO vo);
}

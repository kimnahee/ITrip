package co.itrip.prj.cbtCustom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.cbtCustom.mapper.CbtCustomMapper;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;

/**
* 나만의CBT service
* @author 박경아
* @date 2022.10.04
*/
@Service
public class CbtCustomServiceImpl implements CbtCustomService {
	@Autowired
	CbtCustomMapper map;
	
	@Override //선택한값으로 문제지생성
	public List<CbtGuideVO> cbtCustomMakeSelect(CbtCustomVO vo) {
		return map.cbtCustomMakeSelect(vo);
	}

	@Override//제출하기버튼 클릭시 문제지등록
	public int cbtCustomHderInsert(CbtCustomHderVO vo) {
		return map.cbtCustomHderInsert(vo);
	}

	@Override //문제지번호 max불러오기
	public int selectMcNo() {
		return map.selectMcNo();
	}

	@Override //문제지목록 가져오기
	public List<CbtCustomHderVO> cbtCustomHderList(CbtCustomHderVO vo) {
		return map.cbtCustomHderList(vo);
	}

	@Override //비교해서정답체크
	public int cbtCustomHderChkUpdate(CbtCustomHderVO vo) {
		return map.cbtCustomHderChkUpdate(vo);
	}

	@Override //맞은문제리스트
	public List<CbtGuideVO> cbtCustomListO(CbtGuideVO vo) {
		return map.cbtCustomListO(vo);
	}

	@Override //틀린문제리스트
	public List<CbtGuideVO> cbtCustomListX(CbtGuideVO vo) {
		return map.cbtCustomListX(vo);
	}


}

package co.itrip.prj.cbtNote.service;

import java.util.List;

import co.itrip.prj.cbtCustom.service.CbtCustomHderVO;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.MyCbtHderVO;

public interface CbtNoteService {
	List<MyCbtHderVO> myWrongAnswerLangCd(MyCbtHderVO vo); // guide cbt 오답노트 언어조회
	List<CbtGuideVO> myWrongAnswerNote(CbtGuideVO vo); // guide cbt 틀린문제리스트
	MyCbtHderVO myWrongAnswerCnsr(MyCbtHderVO vo); // guide cbt 내가선택한 오답
	
	List<CbtCustomHderVO> customWrongAnswerLangCd(CbtCustomHderVO vo); //custom cbt 오답노트 언어조회
	List<CbtCustomHderVO> cusWrongAnswerCnsr(CbtCustomHderVO vo); // custom cbt 내가선택한 오답
	
}

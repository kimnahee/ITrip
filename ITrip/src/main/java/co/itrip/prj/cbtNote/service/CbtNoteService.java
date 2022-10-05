package co.itrip.prj.cbtNote.service;

import java.util.List;

import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.MyCbtHderVO;

public interface CbtNoteService {


	List<MyCbtHderVO> myWrongAnswerLangCd(MyCbtHderVO vo);
	List<CbtGuideVO> myWrongAnswerNote(CbtGuideVO vo);
	MyCbtHderVO myWrongAnswerCnsr(MyCbtHderVO vo);
}

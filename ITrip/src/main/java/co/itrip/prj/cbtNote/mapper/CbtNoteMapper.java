package co.itrip.prj.cbtNote.mapper;

import java.util.List;

import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.MyCbtHderVO;

public interface CbtNoteMapper {

	List<MyCbtHderVO> myWrongAnswerLangCd(MyCbtHderVO vo); //오답노트 언어조회
	List<CbtGuideVO> myWrongAnswerNote(CbtGuideVO vo);
	MyCbtHderVO myWrongAnswerCnsr(MyCbtHderVO vo);
}

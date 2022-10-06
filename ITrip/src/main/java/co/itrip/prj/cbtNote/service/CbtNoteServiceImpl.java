package co.itrip.prj.cbtNote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.itrip.prj.cbtCustom.service.CbtCustomHderVO;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.MyCbtHderVO;
import co.itrip.prj.cbtNote.mapper.CbtNoteMapper;

@Service
public class CbtNoteServiceImpl implements CbtNoteService {

	@Autowired
	private CbtNoteMapper map;

	/**
	 * 오답노트
	 * @author 박경아 
	 * @Date 2022.09.29 
	 */
	
	@Override
	public List<MyCbtHderVO> myWrongAnswerLangCd(MyCbtHderVO vo) {
		return map.myWrongAnswerLangCd(vo);
	}

	@Override
	public List<CbtGuideVO> myWrongAnswerNote(CbtGuideVO vo) {
		return map.myWrongAnswerNote(vo);
	}

	@Override
	public MyCbtHderVO myWrongAnswerCnsr(MyCbtHderVO vo) {
		return map.myWrongAnswerCnsr(vo);
	}

	@Override
	public List<CbtCustomHderVO> customWrongAnswerLangCd(CbtCustomHderVO vo) {
		return map.customWrongAnswerLangCd(vo);
	}

	@Override
	public List<CbtCustomHderVO> cusWrongAnswerCnsr(CbtCustomHderVO vo) {
		return map.cusWrongAnswerCnsr(vo);
	}

}

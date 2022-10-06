package co.itrip.prj.cbtNote.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import co.itrip.prj.cbtCustom.service.CbtCustomHderVO;
import co.itrip.prj.cbtCustom.service.CbtCustomService;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.MyCbtHderVO;
import co.itrip.prj.cbtNote.service.CbtNoteService;
import co.itrip.prj.cmmncd.service.CmmnCdService;

@Controller
public class CbtNoteController {
	@Autowired
	private CbtNoteService cnService;

	@Autowired
	CbtCustomService cbtCustomService;

	@Autowired
	CmmnCdService cmmnCdService;
	
	
	/*	cbt 오답노트메인  */
	@GetMapping("/answerNoteMain.do")
	public String answerNoteMain(Model model,MyCbtHderVO vo, Principal principal,CbtCustomHderVO cvo) {
		vo.setMemberId(principal.getName());
		cvo.setMemberId(principal.getName());
		model.addAttribute("gLangCdList", cnService.myWrongAnswerLangCd(vo));
		model.addAttribute("cusLangCdList", cnService.customWrongAnswerLangCd(cvo));
		return "answerNote/answerNoteMain";
	}
	
	/* guide cbt 오답노트 한건보기 */
	@GetMapping("/myWrongAnswerNote.do")
	public String myWrongAnswerNote(Model model,CbtGuideVO vo,MyCbtHderVO mvo) {
		model.addAttribute("note", cnService.myWrongAnswerNote(vo));
		model.addAttribute("myCnsr", cnService.myWrongAnswerCnsr(mvo));
		return "answerNote/answerNoteOne";
	}
	
	/* custom cbt 오답노트 한건보기 */
	@GetMapping("cusWrongAnswerNote.do")
	public String cusWrongAnswerNote(Model model,CbtGuideVO vo,CbtCustomHderVO cvo) {
		model.addAttribute("note", cbtCustomService.cbtCustomListX(vo));
		model.addAttribute("langCdName",cmmnCdService.cdList("L"));
		model.addAttribute("myCnsr", cnService.cusWrongAnswerCnsr(cvo));
		return "answerNote/answerNoteOneCus";
	}

	
}

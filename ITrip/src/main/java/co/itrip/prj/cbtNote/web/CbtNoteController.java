package co.itrip.prj.cbtNote.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.MyCbtHderVO;
import co.itrip.prj.cbtNote.service.CbtNoteService;

@Controller
public class CbtNoteController {
	@Autowired
	private CbtNoteService cnService;
	
	//경아 - 오답노트
	@GetMapping("/answerNoteMain.do")
	public String answerNoteMain(Model model,MyCbtHderVO vo, Principal principal) {
		vo.setMemberId(principal.getName());
		model.addAttribute("langCdList",cnService.myWrongAnswerLangCd(vo));
		return "answerNote/answerNoteMain";
	}
	
	@GetMapping("/myWrongAnswerNote.do")
	public String myWrongAnswerNote(Model model,CbtGuideVO vo,MyCbtHderVO mvo) {
		model.addAttribute("note", cnService.myWrongAnswerNote(vo));
		model.addAttribute("myCnsr", cnService.myWrongAnswerCnsr(mvo));
		return "answerNote/answerNoteSolve";
	}

	
}

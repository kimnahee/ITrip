package co.itrip.prj.cbtCustom.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.itrip.prj.cbtCustom.service.CbtCustomHderListVO;
import co.itrip.prj.cbtCustom.service.CbtCustomHderVO;
import co.itrip.prj.cbtCustom.service.CbtCustomService;
import co.itrip.prj.cbtCustom.service.CbtCustomVO;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cmmncd.service.CmmnCdService;

/**
* 나만의CBT 
* @author 박경아
* @date 2022.10.04
*/
@Controller
public class CbtCustomController {

	@Autowired
	CmmnCdService cmmnCdService;

	@Autowired
	CbtCustomService cbtCustomService;

	
	//커스텀cbt메인화면 시간,언어,문제갯수선택
	@RequestMapping("/cbtCustomMain.do")
	public String cbtCustomMain(Model model) {
		model.addAttribute("langCdList", cmmnCdService.cdList("L"));
		return "cbtCustom/cbtCustomInsertForm";
	}
	
	//선택한 값으로 문제지생성
	@RequestMapping("/cbtCustomMakeSelect.do")
	public String cbtCustomMakeSelect(Model model,CbtCustomVO vo,CbtCustomHderVO cvo) {
		model.addAttribute("time", vo.getTime());
		model.addAttribute("pcs", vo.getPcs());
		model.addAttribute("cbtList", cbtCustomService.cbtCustomMakeSelect(vo));
		return "cbtCustom/cbtCustomMakeSelect";
	}
	

	//사용자가 선택한 답 hder에 넣기
	@RequestMapping("/cbtCustomHderInsert.do")
	public String cbtCustomHderInsert(Model model,CbtCustomHderListVO hvoList,CbtCustomHderVO hdvo,CbtCustomVO ccvo) { 
		int mcNo = cbtCustomService.selectMcNo();
		
		for(CbtCustomHderVO hvo:hvoList.getList()) {
			hvo.setMcNo(mcNo);
			cbtCustomService.cbtCustomHderInsert(hvo);
			cbtCustomService.cbtCustomHderChkUpdate(hvo); //정답비교
			
			CbtGuideVO cvo = new CbtGuideVO(); // CbtGuide 호출을 위해 인스턴스 생성
			cvo.setMcNo(hvo.getMcNo()); // 사용자가 푼 문제 담기
			model.addAttribute("ListO", cbtCustomService.cbtCustomListO(cvo)); // 맞은 문제 출력
			model.addAttribute("ListX", cbtCustomService.cbtCustomListX(cvo)); // 틀린 문제 출력
			model.addAttribute("myCbtList", cbtCustomService.cbtCustomHderList(hvo)); 
			model.addAttribute("pcs", ccvo.getPcs());
		}
		return "cbtCustom/cbtCustomScore"; //문제지결과화면으로 이동해야됨,일단db들어가는지
	}
}

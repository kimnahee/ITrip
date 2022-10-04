package co.itrip.prj.cbtCustom.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.itrip.prj.cbtCustom.service.CbtCustomService;
import co.itrip.prj.cbtCustom.service.CbtCustomVO;
import co.itrip.prj.cmmncd.service.CmmnCdService;

@Controller
public class CbtCustomController {

	@Autowired
	CmmnCdService cmmnCdService;

	@Autowired
	CbtCustomService cbtCustomService;
	
	@RequestMapping("/cbtCustomMain.do")
	public String cbtCustomMain(Model model) {
		model.addAttribute("langCdList", cmmnCdService.cdList("L"));
		return "cbtCustom/cbtCustomInsertForm";
	}
	
	@RequestMapping("/cbtCustomMakeSelect.do")
	public String cbtCustomMakeSelect(Model model,CbtCustomVO vo) {
		model.addAttribute("cbtList", cbtCustomService.cbtCustomMakeSelect(vo));
		
		return "cbtCustom/cbtCustomMakeSelect";
	}
}

package co.itrip.prj.cbtGuide.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.itrip.prj.cbtGuide.mapper.CbtGuideMapper;

@Controller
public class CbtGuideController {
	@Autowired
	private CbtGuideMapper dao;
	@GetMapping("/cbtGuideMain")
	public String cbtGuideMain(Model model) {
		//model.addAttribute("cbtList", dao.cbtGuideList());
		return "cbtGuide/cbtGuideMain";
	}
	
	@RequestMapping("/cbtGuideList")
	public String cbtGuideList(Model model) {
		model.addAttribute("cbtList", dao.cbtGuideList());
		return "cbtGuide/cbtGuideList";
	}

}

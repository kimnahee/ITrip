package co.itrip.prj.langcd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.itrip.prj.langcd.service.LangCdService;

@Controller
public class LangCdController {
	@Autowired
	LangCdService dao;
	
	@RequestMapping("/cbtUserMain.do")
	public String langCdList(Model model) {
		model.addAttribute("langCdList",dao.langCdList());
		return "cbtUser/cbtUserMain";
	}
}

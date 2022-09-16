package co.itrip.prj.langcd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.itrip.prj.langcd.mapper.LangCdMapper;

@Controller
public class LangCdController {
	@Autowired
	LangCdMapper dao;
	
	@RequestMapping("/langCdList")
	public String langCdList(Model model) {
		model.addAttribute("langCdList",dao.langCdList());
		return "cbtUser/langCdList";
	}
}

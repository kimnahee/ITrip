package co.itrip.prj.cbtUser.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.itrip.prj.cbtUser.mapper.CbtUserMapper;

@Controller
public class CbtUserController {
	
	@Autowired
	CbtUserMapper dao;
	
	@RequestMapping("/cbtUserList")
	public String cbtUserList(Model model) {
		model.addAttribute("cbtList",dao.cbtUserList());
		return "cbtUser/cbtUserList";
	}
}

package co.itrip.prj.cbtUser.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.itrip.prj.cbtUser.mapper.CbtUserMapper;
import co.itrip.prj.cbtUser.service.CbtUserVO;

@Controller
public class CbtUserController {
	
	@Autowired
	CbtUserMapper dao;
	
	@RequestMapping("/cbtUserList")
	public String cbtUserList(CbtUserVO vo, Model model) {
		model.addAttribute("cbtList",dao.cbtUserList(vo));
		return "cbtUser/cbtUserList";
	}
	
	@GetMapping("/cbtUserInsertForm")
	public String cbtUserInsertForm() {
		return "cbtUser/cbtUserInsertForm";
	}
}

package co.itrip.prj.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.itrip.prj.admin.service.AdminService;
import co.itrip.prj.guide.service.GuideVO;
import co.itrip.prj.member.service.MemberVO;

@Controller
public class AdminController {
	
	@Autowired
	AdminService dao;
	
	@GetMapping("/approve.do")
	public String approve() {
		
		return "admin/approve";
	}
	
	@GetMapping("/memberAuthList.do")
	public String memberAuthList(GuideVO vo,Model model) {
		model.addAttribute("memberList", dao.memberAuthList(vo));
		return "admin/memberAuthList";
	}

	@GetMapping("/memberList.do")
	public String memberList(MemberVO vo,Model model) {
		model.addAttribute("memberList", dao.memberList(vo));
		return "admin/memberList";
	}
	
	@PostMapping("/memberAuthUpdate.do")
	public String memberAuthUpdate(GuideVO vo) {
		dao.memberAuthUpdate(vo);
		return "admin/memberAuthList";
	}
}

package co.itrip.prj.follow.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.itrip.prj.follow.service.FollowService;

@Controller
public class FollowController {
	
	@Autowired
	private FollowService fodao;
	
	@GetMapping("/followSelectList.do")
	public String followSelectList(Model model) {
		model.addAttribute("follows", fodao.followSelectList());
		return "member/mypage";
	}
	

}

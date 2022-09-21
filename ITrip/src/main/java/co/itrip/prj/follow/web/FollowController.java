package co.itrip.prj.follow.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.itrip.prj.follow.service.FollowService;
import co.itrip.prj.follow.service.FollowVO;


@Controller
public class FollowController {
	
	@Autowired
	private FollowService fService;
	
	
	// followList 띄우기 -> header로 html바꾸기
	@GetMapping("/followList") 
	public String followList(Model model, FollowVO vo, HttpServletRequest request) {
		System.out.println(request.getParameter("memberId"));
	    vo.setMemberId(request.getParameter("memberId"));
		model.addAttribute("guides", fService.followSelectList(vo));
		
		return "member/mypage";
	}
	
	

	

}

package co.itrip.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.itrip.prj.community.service.CommunityService;

@Controller
public class MemberController {
	@Autowired
	private CommunityService com;
	
	@GetMapping("/myPage")
	public String myPage() {
		return "member/mypage";
	}

	@GetMapping("/mClass")
	public String mClass() {
		return "member/mclass";
	}
	
	@GetMapping("/mConsult")
	public String mConsult() {
		return "member/mconsult";
	}
	
	@GetMapping("/gApply")
	public String gApply() {
		return "member/gapply";
	}
	
	@GetMapping("/mcReview")
	public String mcReview() {
		return "member/mcreview";
	}
	
	@GetMapping("/mmFollow")
	public String mmFollow() {
		return "member/mmfollow";
	}
	
	@GetMapping("/myWriter")
	public String myWriter(Model model) {
		model.addAttribute("communityList", com.communityList());
		return "member/mywriter";
	}
	
	@GetMapping("/iClass") // 경아언니
	public String iClass(Model model) {
		return "member/iclass";
	}
	
	@GetMapping("/cStart")
	public String cStart(Model model) {
		return "member/cstart";
	}
}

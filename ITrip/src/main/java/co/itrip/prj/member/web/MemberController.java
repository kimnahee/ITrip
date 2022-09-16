package co.itrip.prj.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
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
}

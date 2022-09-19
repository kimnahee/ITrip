package co.itrip.prj.member.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;



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
	
	// 가이드 마이페이지
	@GetMapping("/gmyPage.do")
	public String gmyPage() {
		return "member/gmypage";
	}
	
	// 가이드 마이페이지 가이드가 개설한 컨설턴트
	@GetMapping("/gconsult.do")
	public String gconsult() {
		return "member/gconsult";
	}
	
	// 가이드 마이페이지 가이드가 개설한 클래스
	@GetMapping("/gclass.do")
	public String gclass() {
		return "member/gclass";
	}
	
	// 가이드 마이페이지 가이드가 개설한 클래스
	@RequestMapping("/grevice.do")
	public String grevice(HttpServletRequest request) {
		request.getSession().setAttribute("id", "eunji");
		return "member/grevice";
	}
	
}

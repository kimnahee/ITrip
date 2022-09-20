package co.itrip.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.itrip.prj.community.service.CommunityService;
import co.itrip.prj.member.service.MemberService;
import co.itrip.prj.member.service.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private CommunityService com;
	
	@Autowired
	private MemberService dao;
	
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
	
	
	@GetMapping("/cStart")
	public String cStart() {
		return "member/cstart";
	}
	
	// 가이드 마이페이지
	@GetMapping("/gmyPage.do")
	public String gmyPage(Model model, MemberVO vo) {
		String guideId = "enji";
		vo.setMemberId(guideId);
		System.out.println(vo.getMemberId());
		model.addAttribute("id", dao.memberSelect(vo));
		vo = dao.memberSelect(vo);
		System.out.println("========"+vo.getName());
		return "member/gmypage";
	}
	
	
}

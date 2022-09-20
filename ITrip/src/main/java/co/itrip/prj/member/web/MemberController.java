package co.itrip.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import co.itrip.prj.community.service.CommunityService;
import co.itrip.prj.follow.service.FollowService;
import co.itrip.prj.member.service.MemberService;
import co.itrip.prj.member.service.MemberVO;


@Controller
public class MemberController {
	
	@Autowired
	private CommunityService com;
	
	@Autowired
	private MemberService dao;
	
	@Autowired
	private FollowService fodao;
	
	// 마이페이지
	@GetMapping("/myPage")
	public String myPage(Model model) {
		model.addAttribute("count", fodao.followCount());
		model.addAttribute("follows", fodao.followSelectList());
		return "member/mypage";
	}	

	// 마이페이지-클래스
	@GetMapping("/mClass")
	public String mClass() {
		return "member/mclass";
	}
	
	// 마이페이지 1:1상담
	@GetMapping("/mConsult")
	public String mConsult() {
		return "member/mconsult";
	}
	
	// 가이드 신청폼
	@GetMapping("/gApply")
	public String gApply() {
		return "member/gapply";
	}
	
	// 클래스 리뷰
	@GetMapping("/mcReview")
	public String mcReview() {
		return "member/mcreview";
	}
	
	// 마이페이지 내가 쓴 글
	@GetMapping("/myWriter")
	public String myWriter(Model model) {
		model.addAttribute("communityList", com.communityList());
		return "member/mywriter";
	}
	
	// 클래스 신청 폼
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

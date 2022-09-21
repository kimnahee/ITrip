package co.itrip.prj.member.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.itrip.prj.cmmncd.service.CmmnCdService;
import co.itrip.prj.community.service.CommunityService;
import co.itrip.prj.follow.service.FollowService;
import co.itrip.prj.member.service.MemberService;
import co.itrip.prj.member.service.MemberVO;


@Controller
public class MemberController { //Principal
	
	@Autowired
	private CommunityService cService;
	
	@Autowired
	private MemberService mService;
	
	@Autowired
	private FollowService fService;
	
	@Autowired
	private CmmnCdService cdService;
	
	// 마이페이지
	@GetMapping("/myPage")
	public String myPage(Model model) {
		model.addAttribute("count", fService.followCount());
		model.addAttribute("follows", fService.followSelectList());
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
	public String gApply(Model model, MemberVO vo) {
		// 가이드 신청폼에 member테이블 id,name 가져옴
		String guideId = "qwe";
		vo.setMemberId(guideId);
		model.addAttribute("guides", mService.memberSelect(vo));
		// 가이드 신청폼 select 태그
		model.addAttribute("careerCdList", cdService.careerCdList());
		model.addAttribute("dutyCdList", cdService.dutyCdList());
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
		model.addAttribute("communityList", cService.communityList());
		return "member/mywriter";
	}
	
	// 클래스 신청 폼
	@GetMapping("/cStart")
	public String cStart(Model model) {
		model.addAttribute("joblist", cdService.jobCdList());
		return "member/cstart";
	}
	
	// 가이드 마이페이지
	@GetMapping("/gmyPage.do")
	public String gmyPage(Model model, MemberVO vo) {
		String guideId = "enji";
		vo.setMemberId(guideId);
		System.out.println(vo.getMemberId());
		model.addAttribute("id", mService.memberSelect(vo));
		vo = mService.memberSelect(vo);
		System.out.println("========"+vo.getName());
		return "member/gmypage";
	}
	
	// 회원정보수정
	@GetMapping("/mrecive.do")
	public String mrecive() {
		return "member/mrecive";
	}

	
	
	
}


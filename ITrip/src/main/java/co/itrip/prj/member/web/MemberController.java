package co.itrip.prj.member.web;



import java.security.Principal;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.itrip.prj.cmmncd.service.CmmnCdService;
import co.itrip.prj.community.service.CommunityService;
import co.itrip.prj.community.service.CommunityVO;
import co.itrip.prj.community.service.ReplyVO;
import co.itrip.prj.follow.service.FollowService;
import co.itrip.prj.follow.service.FollowVO;
import co.itrip.prj.iclass.service.ClassService;
import co.itrip.prj.iclass.service.ClassVO;
import co.itrip.prj.member.service.MemberService;
import co.itrip.prj.member.service.MemberVO;


@Controller
public class MemberController { //Principal
	
	@Autowired
	private CommunityService comService;
	
	@Autowired
	private MemberService mService;
	
	@Autowired
	private CmmnCdService cdService;
	
	@Autowired
	private ClassService cService;

	
	// 마이페이지
	@GetMapping("/myPage")
	public String myPage(Model model) {
//		System.out.println(request.getParameter("memberId"));
//	    vo.setMemberId(request.getParameter("memberId"));
//		model.addAttribute("count", fService.followCount());
//		model.addAttribute("guides", fService.followSelectList(vo));
		return "member/mypage";
	}
	
		
	// 마이페이지-클래스
	@GetMapping("/mClass")
	public String mClass(ClassVO vo,Model model, HttpServletRequest request) {
//		model.addAttribute("pageInfo", PageInfo.of(cService.classList(vo)));
		model.addAttribute("classList", cService.classList(vo));
		return "member/mclass";
	}
	
	// 마이페이지 1:1상담
	@GetMapping("/mConsult")
	public String mConsult() {
		return "member/mconsult";
	}
	
	// 가이드 신청폼
	@GetMapping("/gApply")
	public String gApply(Model model, MemberVO vo, HttpServletRequest request) {
		// 가이드 신청폼에 member테이블 id,name 가져옴
		System.out.println(request.getParameter("memberId"));
		vo.setMemberId(request.getParameter("memberId"));
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
	
	

	// 마이페이지 내가 쓴 글(스터디게시판)
		@GetMapping("/myWriter")
		public String myWriter(CommunityVO vo, Model model, HttpServletRequest request,
				@RequestParam(required = false, defaultValue = "1") int pageNum,
				@RequestParam(required = false, defaultValue = "10") int pageSize) {
			PageHelper.startPage(pageNum, pageSize);
			vo.setCtgry("''");
			vo.setMemberId(request.getParameter("memberId"));
			model.addAttribute("pageInfo", PageInfo.of(comService.findAll(vo)));
			return "member/mywriter";
		}
		

	// 유저 회원 정보 수정페이지
	@GetMapping("/mrecive.do")
	public String mrecive(Principal principal, MemberVO vo, Model model) {
		vo.setMemberId(principal.getName());
		model.addAttribute("member", mService.memberSelect(vo)); 
		return "member/mrecive";
	}
	
	// 회원 정보 수정페이지에서 수정 후  form action -> DB수정 -> 수정된 정보 바로 적용
	@PostMapping("/mreviceUpdate.do")
	public String mreviceUpdate(MemberVO vo, Principal principal) {
		vo.setMemberId(principal.getName());
		mService.memberUpdate(vo);
		return "redirect:myPage";
	}
	
//	// 가이드 회원 정보 수정페이지
//	@GetMapping("/gmrecive.do")
//	public String mrecive1(Principal principal, MemberVO vo, Model model) {
//		vo.setMemberId(principal.getName());
//		model.addAttribute("member", mService.memberSelect(vo)); 
//		return "member/gmrecive";
//	}
	
//	// 회원 정보 수정페이지에서 수정 후  form action -> DB수정 -> 수정된 정보 바로 적용
//	@PostMapping("/gmreviceUpdate.do")
//	public String mreviceUpdate1(MemberVO vo, Principal principal) {
//		vo.setMemberId(principal.getName());
//		mService.memberUpdate(vo);
//		// principal 로 아이디값 받아올때 변경한값 담을 위치
//		return "redirect:gmyPage.do";
//	}

}


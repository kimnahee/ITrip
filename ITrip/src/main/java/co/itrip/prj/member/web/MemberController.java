package co.itrip.prj.member.web;



import java.security.Principal;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.itrip.prj.cmmncd.service.CmmnCdService;
import co.itrip.prj.community.service.CommunityService;
import co.itrip.prj.community.service.CommunityVO;
import co.itrip.prj.consult.service.ConsultService;
import co.itrip.prj.consult.service.ConsultVO;
import co.itrip.prj.cs.service.CSBoardService;
import co.itrip.prj.cs.service.CSBoardVO;
import co.itrip.prj.guide.service.GuideService;
import co.itrip.prj.guide.service.GuideVO;
import co.itrip.prj.iclass.service.ClassAttendVO;
import co.itrip.prj.iclass.service.ClassService;
import co.itrip.prj.iclass.service.ClassVO;
import co.itrip.prj.member.service.MemberService;
import co.itrip.prj.member.service.MemberVO;
import co.itrip.prj.review.service.ReviewVO;


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
	
	@Autowired
	private CSBoardService csService;
	
	@Autowired
	private ConsultService conService;
	
	@Autowired
	private GuideService guiService;

	
	
	// 마이페이지
	@GetMapping("/myPage")
	public String myPage() {
		return "member/mypage";
	}
	
		
	// 마이페이지-클래스
	@GetMapping("/mClass")
	public String mClass(ClassVO vo, ClassAttendVO avo, Model model, Principal principal) {
		vo.setMemberId(principal.getName());
		avo.setMemberId(principal.getName());
		model.addAttribute("classList", cService.myClassList(vo)); 
		model.addAttribute("attend", cService.myClassAttendList(avo)); // 수료여부 확인 후 수료증버튼 활성화, 비활성화
		return "member/mclass";
	}
	
	// 마이페이지-1:1상담
	@GetMapping("/mConsult")
	public String mConsult(ConsultVO vo, Model model, Principal principal) {
		vo.setMemberId(principal.getName());
		model.addAttribute("consultList", conService.myConsultList(vo));
		return "member/mconsult";
	}
	
	// 가이드 신청 요청
	@GetMapping("/gApply")
	public String gApply(Model model, MemberVO vo, GuideVO gvo, Principal principal) {
		// 가이드 신청폼에 member테이블 id,name 가져옴
		vo.setMemberId(principal.getName());
		gvo.setGuideId(principal.getName());
		
		if(guiService.guideSelect(gvo) == null) {
			model.addAttribute("guides", mService.memberSelect(vo));
			// 가이드 신청폼 select 태그
			model.addAttribute("careerCdList", cdService.careerCdList());
			model.addAttribute("dutyCdList", cdService.dutyCdList());
			return "member/gapply";
		} else {
			model.addAttribute("members", mService.memberSelect(vo));
			model.addAttribute("guides", guiService.guideSelect(gvo));
			return "member/error";
		}
		
	}
	
	// 클래스 리뷰폼
	@PostMapping("/mcReview")
	public String mcReview(ReviewVO vo, Model model, Principal principal) {
		// 클래스 리뷰폼에 가이드 아이디, 클래스 번호 가져감
		return "member/classReview";
	}

	// 마이페이지 내가 쓴 글(스터디게시판)
	@GetMapping("/myWriter")
	public String myWriter(CommunityVO vo,CSBoardVO csvo, Model model, Principal principal,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "5") int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		vo.setCtgry("''");
		vo.setMemberId(principal.getName());
		
		csvo.setMemberId(principal.getName());
		csvo.setCtgry("QNA");
		
		model.addAttribute("pageOutfo", PageInfo.of(csService.findAll(csvo)));
		model.addAttribute("pageInfo", PageInfo.of(comService.findAll(vo)));
		
		return "member/mywriter";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	
	// 상담 리뷰
	@GetMapping("/conReview")
	public String conReview() {
		return "member/consultReview";
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

	
	/* 김하은 : 회원가입*/
	@PostMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo) {
		mService.memberInsert(vo);
		return "main/main";
	}
	
	/* 김하은 : 회원탈퇴 전 비밀번호 확인 폼 */
	@GetMapping("/pwChkForm.do")
	public String pwChkForm() {
		return "main/pwChkForm";
	}
	/* 김하은 : 비밀번호 확인 후 회원정보 수정폼으로... */
	@PostMapping("/pwChk.do")
	public String pwChk(MemberVO vo, @RequestParam(value ="error", required =false)String error,
			@RequestParam(value ="exception", required =false)String exception, Model model) {
	
		MemberVO memberDao = mService.memberSelect(vo); //DB의 pw를 가져옴 
		String DBpw = memberDao.getPw(); // DB의 비밀번호
		
		
		PasswordEncoder reqPw = new BCryptPasswordEncoder(); // 암호화처리를 위한 인스턴스 생성
	
		if(reqPw.matches(vo.getPw(), DBpw)) {
			System.out.println("비밀번호가 맞음...!");
			return "redirect:/mrecive.do";
		}else {
			System.out.println("비밀번호가 틀림...!");
			model.addAttribute("error", "비밀번호가 틀렸습니다.");
			model.addAttribute("exception", exception);
			
			return "redirect:/pwChkForm.do?error=true&exception='+error'";
		}
    }
	/* 김하은 : 회원 탈퇴 */
	@GetMapping("/memberDelete.do")
	public String memberDelete(MemberVO vo, Principal prin, HttpSession session) {
		vo.setMemberId(prin.getName());
		mService.memberDelete(vo);
		session.invalidate(); //로그아웃
		return "redirect:/";
	}
	/* 김하은 : 회원 아이디/비밀번호 찾기 폼 */
	@GetMapping("/memberSearchForm.do")
	public String memberSearchForm(MemberVO vo){
		
		return "main/memberSearchForm";
	}
	
	/* 김하은 : 아이디/비밀번호 찾기 */
	@PostMapping("/memberSearch.do")
	public String memberSearch(MemberVO vo, Model model, @RequestParam(value ="error", required =false)String error,
			@RequestParam(value ="exception", required =false)String exception) {
		
		MemberVO dbVo = mService.memberSearch(vo);
		
		// 사용자가 입력한 값(이름, 이메일)이 DB에 저장된 이름과 이메일이 동일하면...
		if (dbVo.getName().equals(vo.getName())  && dbVo.getEmail().equals(vo.getEmail())) {
			 model.addAttribute("v", dbVo);
			 return "main/memberSearchList";
		}else {
			model.addAttribute("error", "정보가 일치하지 않습니다.");
			model.addAttribute("exception", "정보가 일치하지 않습니다.");
			
			return "redirect:/memberSearchForm.do?error=true&exception='+error'";
		}
	
	}
	
	@GetMapping("/memberPwUpdateForm.do")
	public String memberPwUpdateForm(MemberVO vo, Model model) {
		return "main/memberPwUpdateForm";
	}

	
	@PostMapping("/memberPwUpdate.do")
	public String memberPwUpdate(MemberVO vo, Model model) {
	  mService.memberPwUpdate(vo);
		return "main/main";
	}
}

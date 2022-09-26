package co.itrip.prj.guide.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import co.itrip.prj.cmmncd.service.CmmnCdService;
import co.itrip.prj.follow.service.FollowService;
import co.itrip.prj.follow.service.FollowVO;
import co.itrip.prj.guide.service.GuideService;
import co.itrip.prj.guide.service.GuideVO;
import co.itrip.prj.iclass.service.ClassDtVO;
import co.itrip.prj.iclass.service.ClassVO;
import co.itrip.prj.member.service.MemberService;
import co.itrip.prj.member.service.MemberVO;

@Controller
public class GuideController {
	
	@Autowired
	private GuideService guService; // 가이드 서비스
  
	@Autowired
	private MemberService mService; // 유저 서비스

	@Autowired
	private CmmnCdService cdService; // 공통코드 서비스
	
	@Autowired
	private FollowService fService; // 팔로우 서비스
	

	
	int r = 0;
	
	// 가이드 insert & 파일처리
	@PostMapping("/guideInsert.do")
	public String guideInsert(GuideVO vo, Model model, MultipartFile file) throws IllegalStateException, IOException {
		
		if(!file.getOriginalFilename().isEmpty()) {
			String projectpath = System.getProperty("user.dir")+"/src/main/resources/static/files"; // user.dir은 프로젝트 경로를 담아주게 된다. 
			UUID uuid = UUID.randomUUID(); // 랜덤으로 이름생성
			String filename = uuid+"_"+file.getOriginalFilename(); // 파일이름은 UUID에 있는 랜덤값 + 원래 파일이름으로 설정된다.
			File saveFile = new File(projectpath,filename);
			file.transferTo(saveFile);
			vo.setAttach(filename);
			vo.setAttachDir("/files/"+filename);
		}
		
		guService.guideInsert(vo);
					
		return "member/mypage";
	}
	
	
	// 가이드 클래스 신청 폼
	@GetMapping("/startClass.do")
	public String startClass(Model model, MemberVO vo, HttpServletRequest request) {
		// guideId 폼에 뿌려주기
		System.out.println(request.getParameter("memberId"));
		vo.setMemberId(request.getParameter("memberId"));
		model.addAttribute("members", mService.memberSelect(vo));
		
		// job카테고리 뿌려주기
		model.addAttribute("joblist", cdService.jobCdList());
		return "guide/cstart";
	}
	
	// 가이드 마이페이지 
	@GetMapping("/gmyPage.do")
	public String gmyPage(Model model, Principal principal, FollowVO vo) {
		 vo.setMemberId(principal.getName());
		 model.addAttribute("count", fService.followCount()); 
			/*
			 * vo = mService.memberSelect(vo); System.out.println("========"+vo.getName());
			 */
		return "guide/gmypage";
	}	
	// 가이드 마이페이지 가이드가 개설한 컨설턴트
	@GetMapping("/gconsult.do")
	public String gconsult(Model model) {
		model.addAttribute("joblist", cdService.jobCdList());
		return "guide/gconsult";
	}
	// 상담 등록 폼
	@GetMapping("/consultStart.do")
	public String consultStart() {
		return "guide/consultStart";
	}
	
	// 가이드 마이페이지 가이드가 개설한 클래스
	@GetMapping("/gclass.do")
	public String gclass() {
		return "guide/gclass";
	}
	

	// 가이드 정보 수정페이지
	@RequestMapping("/grevice.do")
	public String grevice(Model model, GuideVO vo, Principal principal) {
		//request.getParameter("guideId");
		//request.getSession().setAttribute("id", "eunji"); 
		//String guideId = "junga";
		//System.out.println(principal.getName()); // 아이디확인
		vo.setGuideId(principal.getName());
		model.addAttribute("guide", guService.guideSelect(vo));
		model.addAttribute("careerCdList", cdService.careerCdList()); // 경력공통코드
		model.addAttribute("dutyCdList", cdService.dutyCdList()); // 직무공통코드
		return "guide/grevice";
	}
	
	// 가이드 수정페이지에서 수정 후 form action -> DB수정
	@PostMapping("/greviceUpdate.do")
	public String greviceUpdate(GuideVO vo, Principal principal) {
		// System.out.println(principal.getName()); // 아이디 확인
		vo.setGuideId(principal.getName());
		guService.guideUpdate(vo); // 업데이트
		return "redirect:gmyPage.do";
	}
	
	// 가이드 회원 정보 수정페이지
	@GetMapping("/gmrecive.do")
	public String mrecive1(Principal principal, MemberVO vo, Model model) {
		vo.setMemberId(principal.getName());
		model.addAttribute("member", mService.memberSelect(vo)); 
		return "guide/gmrevice";
	}
	
	// 회원 정보 수정페이지에서 수정 후  form action -> DB수정 -> 수정된 정보 바로 적용
	@PostMapping("/gmreviceUpdate.do")
	public String mreviceUpdate1(MemberVO vo, Principal principal) {
		vo.setMemberId(principal.getName());
		mService.memberUpdate(vo);
		// principal 로 아이디값 받아올때 변경한값 담을 위치
		return "redirect:gmyPage.do";
	}
	
	

}

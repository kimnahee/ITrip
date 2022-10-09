package co.itrip.prj.guide.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.itrip.prj.cmmncd.service.CmmnCdService;
import co.itrip.prj.consult.service.ConsultService;
import co.itrip.prj.consult.service.ConsultVO;
import co.itrip.prj.follow.service.FollowService;
import co.itrip.prj.follow.service.FollowVO;
import co.itrip.prj.guide.service.GuideService;
import co.itrip.prj.guide.service.GuideVO;
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
	
	@Autowired
	private ConsultService conservice; // 컨설트 서비스
	
	@Value("${file.dir}")
	private String fileDir; // 파일 저장할 디폴트 경로 C:/Temp
	

	
	int r = 0;
	
	//소정 가이드 insert & 파일처리
	@PostMapping("/guideInsert.do")
	public String guideInsert(GuideVO vo, Model model, MultipartFile file) throws IllegalStateException, IOException {
		
		String oFileName = file.getOriginalFilename();
		if (!oFileName.isEmpty()) {
			String sFileName = UUID.randomUUID().toString() + oFileName.substring(oFileName.lastIndexOf(".")); // 마지막.뒤에값
																												// 가져오기
			String path = fileDir + "/guide/" + sFileName;
			file.transferTo(new File(path));
			vo.setAttach(oFileName);
			vo.setAttachDir(sFileName);
			
		}
		guService.guideInsert(vo);
					
		return "member/mypage";
	}
	
	
	//소정 가이드 클래스 신청 폼
	@GetMapping("/startClass.do")
	public String startClass(Model model, MemberVO vo, HttpServletRequest request, Principal principal) {
		// guideId 폼에 뿌려주기
		vo.setMemberId(principal.getName());
		model.addAttribute("members", mService.memberSelect(vo));
		
		// job카테고리 뿌려주기
		model.addAttribute("joblist", cdService.jobCdList());
		return "guide/cstart";
	}
	

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 은지 - 가이드 마이페이지 
	@GetMapping("/gmyPage.do")
	public String gmyPage(Model model, Principal principal, FollowVO vo) {
		 vo.setMemberId(principal.getName());
		 model.addAttribute("count", fService.followCount()); 
			/*
			 * vo = mService.memberSelect(vo); System.out.println("========"+vo.getName());
			 */
		return "guide/gmypage";
	}	
	
	// 은지 - 가이드 마이페이지 -가이드가 개설한 상담 리스트
	@GetMapping("/gconsult.do")
	public String gconsult(ConsultVO vo, Model model, Principal principal) {
		
		vo.setGuideId(principal.getName());
		
		// 승인 완료된 상담 
		vo.setStateCd("2");
		model.addAttribute("consultList", conservice.consultList(vo));
		return "guide/gconsult";
	}
	
	
	// 은지 - 가이드 마이페이지 -가이드가 개설한 클래스 리스트
	@GetMapping("/gclass.do")
	public String gclass(ClassVO vo, Model model, Principal principal) {
		vo.setGuideId(principal.getName());
		vo.setConfmCd("2");
		model.addAttribute("classList", guService.myIClassList(vo));
		return "guide/gclass";
	}
	
	// 은지 - 가이드 정보 수정페이지
	@RequestMapping("/grevice.do")
	public String grevice(Model model, GuideVO vo, Principal principal) {
		vo.setGuideId(principal.getName());
		model.addAttribute("guide", guService.guideSelect(vo));
		model.addAttribute("careerCdList", cdService.careerCdList()); // 경력공통코드
		model.addAttribute("dutyCdList", cdService.dutyCdList()); // 직무공통코드
		return "guide/grevice";
	}
	
	// 은지 - 가이드 정보 수정 처리
	@PostMapping("/greviceUpdate.do")
	public String greviceUpdate(GuideVO vo, Principal principal) {
		vo.setGuideId(principal.getName());
		guService.guideUpdate(vo); // 업데이트
		return "redirect:gmyPage.do";
	}
	
	// 은지 - 가이드 회원 정보 수정페이지
	@GetMapping("/gmrecive.do")
	public String mrecive1(Principal principal, MemberVO vo, Model model) {
		vo.setMemberId(principal.getName());
		model.addAttribute("member", mService.memberSelect(vo)); 
		return "guide/gmrevice";
	}
	
	// 은지 - 가이드 회원 정보 수정 처리
	@PostMapping("/gmreviceUpdate.do")
	public String mreviceUpdate1(MemberVO vo, Principal principal) {
		vo.setMemberId(principal.getName());
		mService.memberUpdate(vo);
		// principal 로 아이디값 받아올때 변경한값 담을 위치
		return "redirect:gmyPage.do";
	}
	
	// 은지 - 클래스 수강생 리스트(페이징)
	@GetMapping("/userList.do")
	public String userList(ClassVO vo, Principal principal, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "8") int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		vo.setGuideId(principal.getName());
		model.addAttribute("pageInfo", PageInfo.of(guService.userList(vo)));
		return "guide/userList";
	}

	//경아 - 가이드신청 승인거절시 가이드테이블에서삭제 
	@RequestMapping("/guideDelete.do")
	public String guideDelete(GuideVO vo) {
		guService.guideDelete(vo);
		return "redirect:gApply";
	}
}

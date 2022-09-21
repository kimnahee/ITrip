package co.itrip.prj.guide.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import co.itrip.prj.cmmncd.service.CmmnCdService;
import co.itrip.prj.guide.service.GuideService;
import co.itrip.prj.guide.service.GuideVO;
import co.itrip.prj.member.service.MemberService;
import co.itrip.prj.member.service.MemberVO;

@Controller
public class GuideController {
	
	@Autowired
	private GuideService guService;
  
	@Autowired
	private MemberService mService;

	@Autowired
	private CmmnCdService cdService;
	
	
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
	
	// 가이드 마이페이지 가이드가 개설한 컨설턴트
	@GetMapping("/gconsult.do")
	public String gconsult() {
		return "guide/gconsult";
	}
	
	// 가이드 마이페이지 가이드가 개설한 클래스
	@GetMapping("/gclass.do")
	public String gclass() {
		return "guide/gclass";
	}
	

	// 가이드 수정페이지
	@RequestMapping("/grevice.do")
	public String grevice(Model model, GuideVO vo, Principal princ) {
		/* request.getSession().setAttribute("id", "eunji"); */
		String guideId = "junga";
		vo.setGuideId(guideId);
		model.addAttribute("guide", guService.guideSelect(vo));
		/* vo = mService.memberSelect(vo); */
		/* System.out.println("========"+vo.getName()); */
		model.addAttribute("careerCdList", cdService.careerCdList());
		model.addAttribute("dutyCdList", cdService.dutyCdList());
		return "guide/grevice";
	}


}

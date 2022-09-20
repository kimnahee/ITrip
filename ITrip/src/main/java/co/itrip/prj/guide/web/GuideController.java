package co.itrip.prj.guide.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.itrip.prj.cmmncd.service.CmmnCdService;
import co.itrip.prj.guide.mapper.GuideMapper;
import co.itrip.prj.guide.service.GuideVO;
import co.itrip.prj.member.service.MemberService;
import co.itrip.prj.member.service.MemberVO;

@Controller
public class GuideController {
	
	@Autowired
	GuideMapper gudao;

	@Autowired
	private MemberService dao;
	
	@Autowired
	private CmmnCdService cd;
	
	int r = 0;
	
	@PostMapping("/guideInsert.do")
	public String guideInsert(GuideVO vo, Model model, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		String saveFolder = "c://fileUpload"; // 저장할 공간 폴더명
		
		String orignalFileName = file.getOriginalFilename(); // 넘어온 파일명
		
		if(!orignalFileName.isEmpty()) {
			
			// 파일명 충돌방지를 위해서 랜덤 파일명 돌리기
			String saveFileName = UUID.randomUUID().toString() + orignalFileName.substring(orignalFileName.lastIndexOf('.'));
			
			// 파일을 물리적 위치에 저장
			file.transferTo(new File(saveFolder, saveFileName));
			
			vo.setAttach(orignalFileName);
			vo.setAttachDir(saveFolder + File.separator + saveFileName);
			
		}
		r = gudao.guideInsert(vo);
		if(r>0) {
			r++;
		}
		model.addAttribute("r", r);
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
	
	// 가이드 마이페이지 가이드가 개설한 클래스
	@RequestMapping("/grevice.do")
	public String grevice(Model model, MemberVO vo, HttpServletRequest request) {
		/* request.getSession().setAttribute("id", "eunji"); */
		String guideId = "enji";
		vo.setMemberId(guideId);
		/* System.out.println(vo.getMemberId()); */
		model.addAttribute("id", dao.memberSelect(vo));
		vo = dao.memberSelect(vo);
		/* System.out.println("========"+vo.getName()); */
		model.addAttribute("careerCdList", cd.careerCdList());
		model.addAttribute("dutyCdList", cd.dutyCdList());
		return "guide/grevice";
	}


}

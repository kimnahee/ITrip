package co.itrip.prj.community.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.itrip.prj.community.service.CommunityService;
import co.itrip.prj.community.service.CommunityVO;

@Controller

public class CommunityController {
	@Autowired
	private CommunityService dao;
	
	@Autowired
	private ServletContext servletContext;

	// 실시간 타임라인 게시판(일단 출력만)
	@GetMapping("/timeline")
	public String timeLine(Model model) {
		model.addAttribute("communityList", dao.communityList());
		return "community/timeLine";
	}

	// 게시글 단일출력
	@GetMapping("/selectCommunity.do")
	public String selectCommunity(CommunityVO vo, Model model, HttpServletRequest request) {
		System.out.println(request.getParameter("comNo")); // 글번호 확인
		vo.setComNo(Integer.parseInt(request.getParameter("comNo")));
		model.addAttribute("selectCommunity", dao.selectCommunity(vo));
		return "community/selectCommunity";
	}

	// 스터디게시판
	@GetMapping("/study.do")
	public String study(Model model) {
		model.addAttribute("studyList", dao.studyList());
		return "community/study";
	}

	// 스터디게시판 글쓰기 폼
	@GetMapping("/studyInsertForm.do")
	public String studyInsertForm() {
		return "community/studyInsertForm";
	}

	// 스터디게시판 글 작성(파일업로드)
	@PostMapping("/studyInsert.do")
	public String studyInsert(CommunityVO vo, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		// 파일 업로드 처리
		String saveFolder = servletContext.getRealPath("/fileUpload"); // 저장할 공간 폴더 명
		File sfile = new File(saveFolder); // 물리적 저장할 위치
		String oFileName = file.getOriginalFilename(); // 넘어온 파일의 이름
		if (!oFileName.isEmpty()) {
			// 파일 명 충돌방지를 위한 별명
			String sFileName = UUID.randomUUID().toString() + oFileName.substring(oFileName.lastIndexOf("."));// 물리적 위치에
			file.transferTo(new File(sfile, sFileName)); // 파일을 물리적 위치에 저장
			vo.setAttach(oFileName);
			vo.setAttachDir(saveFolder + File.separator + sFileName); // fileUpload/273747.txt | File.separator 대신
		}
		dao.studyInsert(vo);
		return "redirect:study.do";
	}
}

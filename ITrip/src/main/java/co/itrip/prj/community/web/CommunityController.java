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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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

//	// 스터디게시판
//	@GetMapping("/study.do")
//	public String study(Model model) {
//		model.addAttribute("studyList", dao.studyList());
//		return "community/study";
//	}

	// 스터디게시판 글쓰기 폼
	@GetMapping("/studyInsertForm.do")
	public String studyInsertForm() {
		return "community/studyInsertForm";
	}

	// 스터디게시판 글 작성(파일업로드)
	@PostMapping("/studyInsert.do")
	public String studyInsert(CommunityVO vo, MultipartFile file) throws IllegalStateException, IOException {
		String projectPath = System.getProperty("user.dir")+"/src/main/resources/static/files"; //프로젝트 경로
		UUID uuid = UUID.randomUUID();
		String filename = uuid + "_" + file.getOriginalFilename();

		File saveFile = new File(projectPath, filename);
		file.transferTo(saveFile);
		vo.setAttach(filename);
		String path = "/files/" + filename;
		vo.setAttachDir(path);
		dao.studyInsert(vo);
		return "redirect:study.do";
	}
	
	//스터디게시판 글 수정 폼
	@GetMapping("/studyUpdateForm.do")
	public String studyUpdateForm(CommunityVO vo, Model model, HttpServletRequest request) {
		System.out.println(request.getParameter("comNo")); // 글번호 확인
		vo.setComNo(Integer.parseInt(request.getParameter("comNo")));
		model.addAttribute("selectStudy", dao.selectCommunity(vo));
		return "community/studyUpdateForm";
	}
	
	//스터디게시판 글 수정
	@GetMapping("/studyUpdate.do")
	public String studyUpdate(CommunityVO vo, Model model, HttpServletRequest request) {
		System.out.println(request.getParameter("comNo")); // 글번호 확인
		vo.setComNo(Integer.parseInt(request.getParameter("comNo")));
		return "redirect:study.do";
	}
	
	//스터디게시판 글 삭제
	@GetMapping("/studyDelete.do")
	public String studyDelete(CommunityVO vo, Model model, HttpServletRequest request) {
		System.out.println(request.getParameter("comNo")); // 글번호 확인
		vo.setComNo(Integer.parseInt(request.getParameter("comNo")));
		dao.studyDelete(vo);
		return "redirect:study.do";
	}
	
	//페이징 처리
	@GetMapping("/pageTest.do")
	public String findPage(Model model, HttpServletRequest request, @RequestParam(required = false, defaultValue = "1") int pageNum, 
																	@RequestParam(required = false, defaultValue = "10") int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(dao.findAll()));
		return "community/timeline";
	}
	
	@GetMapping("/study.do")
	public String findStudyPage(Model model, HttpServletRequest request, @RequestParam(required = false, defaultValue = "1") int pageNum, 
																	     @RequestParam(required = false, defaultValue = "10") int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(dao.findStudy()));
		return "community/study";
	}
	
	
}

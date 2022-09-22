package co.itrip.prj.community.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.itrip.prj.community.service.CommunityService;
import co.itrip.prj.community.service.CommunityVO;
import co.itrip.prj.community.service.ReplyVO;

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

	// 게시글 단일출력(스터디게시판 : 작동 O)
	@GetMapping("/selectCommunity.do")
	public String selectCommunity(CommunityVO vo, ReplyVO rvo, Model model, HttpServletRequest request) {
		// System.out.println(request.getParameter("comNo")); // 글번호 확인
		vo.setComNo(Integer.parseInt(request.getParameter("comNo")));
		model.addAttribute("selectCommunity", dao.selectCommunity(vo));
		dao.commHitUpdate(vo);
		return "community/study/selectStudy";
	}

	// 게시글 단일출력(자유게시판)
	@GetMapping("/selectFree.do")
	public String selectFree(CommunityVO vo, ReplyVO rvo, Model model, HttpServletRequest request) {
		// System.out.println(request.getParameter("comNo")); // 글번호 확인
		vo.setComNo(Integer.parseInt(request.getParameter("comNo")));
		model.addAttribute("selectCommunity", dao.selectCommunity(vo));
		dao.commHitUpdate(vo);
		return "community/free/selectFree";
	}

	// 스터디게시판
	// 스터디게시판 글쓰기 폼
	@GetMapping("/studyInsertForm.do")
	public String studyInsertForm() {
		return "community/study/studyInsertForm";
	}

	// 스터디게시판 글 작성(파일업로드)
	@PostMapping("/studyInsert.do")
	public String studyInsert(CommunityVO vo, MultipartFile file) throws IllegalStateException, IOException {
		if (!file.getOriginalFilename().isEmpty()) {
			String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files"; // 프로젝트 경로
			UUID uuid = UUID.randomUUID();
			String filename = uuid + "_" + file.getOriginalFilename();
			File saveFile = new File(projectPath, filename);
			file.transferTo(saveFile);
			vo.setAttach(filename);
			String path = "/files/" + filename;
			vo.setAttachDir(path);
		}
		dao.studyInsert(vo);
		return "redirect:study.do";
	}

	// 스터디게시판 글 수정 폼
	@GetMapping("/studyUpdateForm.do")
	public String studyUpdateForm(CommunityVO vo, Model model, HttpServletRequest request) {
		System.out.println(request.getParameter("comNo")); // 글번호 확인
		vo.setComNo(Integer.parseInt(request.getParameter("comNo")));
		model.addAttribute("selectStudy", dao.selectCommunity(vo));
		return "community/study/studyUpdateForm";
	}

	// 스터디게시판 글 수정
	@PostMapping("/studyUpdate.do")
	public String studyUpdate(CommunityVO vo, MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {
		System.out.println("==============" + request.getParameter("comNo")); // 글번호 확인
		vo.setComNo(Integer.parseInt(request.getParameter("comNo")));
		if (!file.getOriginalFilename().isEmpty()) {
			String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files"; // 프로젝트 경로
			UUID uuid = UUID.randomUUID();
			String filename = uuid + "_" + file.getOriginalFilename();
			File saveFile = new File(projectPath, filename);
			file.transferTo(saveFile);
			vo.setAttach(filename);
			String path = "/files/" + filename;
			vo.setAttachDir(path);
		}
		dao.studyUpdate(vo);
		return "redirect:study.do";
	}

	// 스터디게시판 글 삭제
	@GetMapping("/studyDelete.do")
	public String studyDelete(CommunityVO vo, Model model, HttpServletRequest request) {
		System.out.println(request.getParameter("comNo")); // 글번호 확인
		vo.setComNo(Integer.parseInt(request.getParameter("comNo")));
		dao.studyDelete(vo);
		return "redirect:study.do";
	}

	// 자유게시판
	// 자유게시판 글쓰기 폼
	@GetMapping("/freeInsertForm.do")
	public String freeInsertForm() {
		return "community/free/freeInsertForm";
	}

	// 자유게시판 글 작성(파일업로드)
	@PostMapping("/freeInsert.do")
	public String freeInsert(CommunityVO vo, MultipartFile file) throws IllegalStateException, IOException {
		if (!file.getOriginalFilename().isEmpty()) {
			String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files"; // 프로젝트 경로
			UUID uuid = UUID.randomUUID();
			String filename = uuid + "_" + file.getOriginalFilename();

			File saveFile = new File(projectPath, filename);
			file.transferTo(saveFile);
			vo.setAttach(filename);
			String path = "/files/" + filename;
			vo.setAttachDir(path);
		}
		dao.freeInsert(vo);
		return "redirect:free.do";
	}

	//자유게시판 글 수정 폼
	@GetMapping("/freeUpdateForm.do")
	public String freeUpdateForm(CommunityVO vo, Model model, HttpServletRequest request) {
		System.out.println(request.getParameter("comNo")); // 글번호 확인
		vo.setComNo(Integer.parseInt(request.getParameter("comNo")));
		model.addAttribute("selectStudy", dao.selectCommunity(vo));
		return "community/free/freeUpdateForm";
	}

	// 자유게시판 글 수정
	@PostMapping("/freeUpdate.do")
	public String freeUpdate(CommunityVO vo, MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {
		vo.setComNo(Integer.parseInt(request.getParameter("comNo")));
		if (!file.getOriginalFilename().isEmpty()) {
			String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files"; // 프로젝트 경로
			UUID uuid = UUID.randomUUID();
			String filename = uuid + "_" + file.getOriginalFilename();
			File saveFile = new File(projectPath, filename);
			file.transferTo(saveFile);
			vo.setAttach(filename);
			String path = "/files/" + filename;
			vo.setAttachDir(path);
		}
		dao.freeUpdate(vo);
		return "redirect:free.do";
	}

	// 페이징
	// 페이징 처리(전체게시판)
	@GetMapping("/pageTest.do")
	public String findPage(CommunityVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		vo.setCtgry("''");
		model.addAttribute("pageInfo", PageInfo.of(dao.findAll(vo)));
		return "community/timeline";
	}

	// 페이징 처리(스터디게시판)
	@GetMapping("/study.do")
	public String findStudyPage(CommunityVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		vo.setCtgry("스터디");
		model.addAttribute("pageInfo", PageInfo.of(dao.findAll(vo)));
		return "community/study/study";
	}

	// 페이징 처리(자유게시판)
	@GetMapping("/free.do")
	public String findFreePage(CommunityVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		vo.setCtgry("자유게시판");
		model.addAttribute("pageInfo", PageInfo.of(dao.findAll(vo)));
		return "community/free/free";
	}

	// 댓글
	// 댓글 리스트
	@GetMapping("/replyList.do")
	@ResponseBody
	public List<ReplyVO> replyList(ReplyVO vo, HttpServletRequest request, Model model) {
		String comNo = request.getParameter("comNo");
		// System.out.println("===============원글번호" + comNo);
		vo.setComNo(Integer.parseInt(comNo));
		return dao.replyList(vo);
	}

	// 댓글입력
	@PostMapping("/replyInsert.do")
	@ResponseBody
	public int replyInsert(ReplyVO vo, HttpServletRequest request) {
		String comNo = request.getParameter("comNo");
		String content = request.getParameter("content");
		String memberId = request.getParameter("memberId");
		//System.out.println("댓글insert확인" + comNo + "내용확인" + content + memberId);
		vo.setComNo(Integer.parseInt(comNo));
		vo.setContent(content);
		vo.setMemberId(memberId);
		return dao.replyInsert(vo);
	}

	// 댓글삭제
	@PostMapping("/replyDelete.do")
	@ResponseBody
	public int replyDelete(ReplyVO vo, HttpServletRequest request) {
		String reNo = request.getParameter("reNo");
		vo.setReNo(Integer.parseInt(reNo));
		return dao.replyDelete(vo);
	}

	// 댓글수정
	@PostMapping("/replyUpdate.do")
	@ResponseBody
	public int replyUpdate(ReplyVO vo, HttpServletRequest request) {
		String reNo = request.getParameter("reNo");
		String content = request.getParameter("content");
		vo.setReNo(Integer.parseInt(reNo));
		vo.setContent(content);
		return dao.replyUpdate(vo);
	}
}

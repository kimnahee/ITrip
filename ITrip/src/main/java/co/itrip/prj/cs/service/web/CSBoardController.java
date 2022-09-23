package co.itrip.prj.cs.service.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.itrip.prj.cs.service.CSBoardService;
import co.itrip.prj.cs.service.CSBoardVO;

@Controller
public class CSBoardController {

	@Autowired
	private CSBoardService service;
	
	//공지사항 리스트
	@GetMapping("/noticeList.do")
	public String findPage(CSBoardVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		vo.setCtgry("공지사항");
		model.addAttribute("pageInfo", PageInfo.of(service.findAll(vo)));
		return "csboard/notice/noticeList";
	}
	
	//단건조회
	@GetMapping("/csSelect.do")
	public String csSelect(CSBoardVO vo, Model model, HttpServletRequest request) {
		System.out.println(request.getParameter("csNo"));
		vo.setCsNo(Integer.parseInt(request.getParameter("csNo")));
		model.addAttribute("csSelect", service.selectCs(vo));
		return "csboard/notice/selectNotice";
	}
	
	//공지사항 작성 폼
	@GetMapping("/noticeInsertForm.do")
	public String noticeInsertForm() {
		return "csboard/notice/noticeInsertForm";
	}
	
	//공지사항 작성
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(CSBoardVO vo) {
		service.csInsert(vo);
		return "redirect:noticeList.do";
	}
	
	//게시글 수정 폼
	@GetMapping("/noticeUpdateForm.do")
	public String noticeUpdateForm(CSBoardVO vo, Model model, HttpServletRequest request) {
		System.out.println(request.getParameter("csNo")); // 글번호 확인
		vo.setCsNo(Integer.parseInt(request.getParameter("csNo")));
		model.addAttribute("selectCs", service.selectCs(vo));
		return "csboard/notice/noticeUpdateForm";
	}
	
	//게시글 수정
	@PostMapping("/noticeUpdate.do")
	public String noticeUpdate(CSBoardVO vo) {
		service.csUpdate(vo);
		return "redirect:noticeList.do";
	}

	//게시글 삭제
	@GetMapping("/noticeDelete.do")
	public String noticeDelete(CSBoardVO vo, HttpServletRequest request) {
		vo.setCsNo(Integer.parseInt(request.getParameter("csNo")));
		service.csDelete(vo);
		return "redirect:noticeList.do";
	}
}

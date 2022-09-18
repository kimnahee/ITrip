package co.itrip.prj.community.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.itrip.prj.community.service.CommunityService;
import co.itrip.prj.community.service.CommunityVO;

@Controller

public class CommunityController {
	@Autowired
	private CommunityService dao;

	//실시간 타임라인 게시판(일단 출력만)
	@GetMapping("/timeline")
	public String timeLine(Model model) {
		model.addAttribute("communityList", dao.communityList());
		return "community/timeLine";
	}
	
	//게시글 단일출력
	@GetMapping("/selectCommunity.do")
	public String selectCommunity(CommunityVO vo, Model model, HttpServletRequest request) {
		System.out.println(request.getParameter("comNo")); //글번호 확인
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

}

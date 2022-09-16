package co.itrip.prj.member.community.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.itrip.prj.member.community.service.CommunityService;

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

	// 스터디게시판
	@GetMapping("/study.do")
	public String study() {
		return "community/study";
	}

}

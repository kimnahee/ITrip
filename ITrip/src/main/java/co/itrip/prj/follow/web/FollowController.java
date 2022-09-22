package co.itrip.prj.follow.web;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.itrip.prj.follow.service.FollowService;
import co.itrip.prj.follow.service.FollowVO;


@Controller
public class FollowController {
	
	@Autowired
	private FollowService fService;
	

		@GetMapping("/followList.do")
		@ResponseBody
		public List<FollowVO> followList(FollowVO vo, HttpServletRequest request, Model model) {
			System.out.println(request.getParameter("memberId"));
			vo.setMemberId(request.getParameter("memberId"));
			return fService.followSelectList(vo);
		}
		
		@GetMapping("/followDelete.do")
		@ResponseBody
		public int followDelete(FollowVO vo, HttpServletRequest request) {
			System.out.println(request.getParameter("memberId"));
			System.out.println(request.getParameter("deleteF"));
			vo.setMemberId(request.getParameter("memberId"));
			vo.setGuideId(request.getParameter("deleteF"));
			return fService.followDelete(vo);
		}
	

	

	
	

	

}

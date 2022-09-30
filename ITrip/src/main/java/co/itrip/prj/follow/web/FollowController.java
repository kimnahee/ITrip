package co.itrip.prj.follow.web;


import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		// 가이드를 팔로우한 유저리스트
		@GetMapping("/followerList.do")
		@ResponseBody
		public List<FollowVO> followerList(FollowVO vo, HttpServletRequest request, Model model) {
			System.out.println(request.getParameter("guideId"));
			vo.setMemberId(request.getParameter("guideId"));
			return fService.followerSelectList(vo);
		}
		
		// 가이드가 유저의 팔로우 취소하기 (언팔로우)
		@GetMapping("/followerDelete.do")
		@ResponseBody
		public int followerDelete(FollowVO vo, HttpServletRequest request) {
			System.out.println(request.getParameter("guideId"));
			System.out.println(request.getParameter("deleteF")); // 유저 아이디
			vo.setGuideId(request.getParameter("guideId"));
			vo.setMemberId(request.getParameter("deleteF")); // 유저 아이디 담기
			return fService.followerDelete(vo);
		}
	
		/*
		 * // 해당 가이드 찜(팔로우) 여부 확인용 데이터 가져오기
		 * 
		 * @PostMapping("/heartCount.do")
		 * 
		 * @ResponseBody public int heartCount(FollowVO vo, HttpServletRequest request)
		 * { String memberId = request.getParameter("memberId"); String guideId =
		 * request.getParameter("guideId"); int consultNo =
		 * Integer.parseInt(request.getParameter("consultNo"));
		 * System.out.println(memberId+guideId+consultNo); vo.setMemberId(memberId);
		 * vo.setGuideId(guideId); vo.setConsultNo(consultNo); return
		 * fService.heartCount(vo); }
		 */
		
	

	
	

	

}

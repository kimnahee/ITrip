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
	
		// 소정 - 마이페이지 팔로우 리스트 
		@GetMapping("/followList.do")
		@ResponseBody
		public List<FollowVO> followList(FollowVO vo, HttpServletRequest request, Model model) {
			return fService.followSelectList(vo);
		}
		
		// 소정 - 마이페이지 언팔로우
		@GetMapping("/followDelete.do")
		@ResponseBody
		public int followDelete(FollowVO vo, HttpServletRequest request) {
			return fService.followDelete(vo);
		}
		
		// 은지 - 가이드 마이페이지에서 가이드를 팔로우한 유저리스트
		@GetMapping("/followerList.do")
		@ResponseBody
		public List<FollowVO> followerList(FollowVO vo) {
			return fService.followerSelectList(vo);
		}
		
		//  은지 - 가이드 마이페이지에서 가이드가 유저의 팔로우 취소하기 (언팔로우)
		@GetMapping("/followerDelete.do")
		@ResponseBody
		public int followerDelete(FollowVO vo, HttpServletRequest request) {
			return fService.followerDelete(vo);
		}
	


}

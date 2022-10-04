package co.itrip.prj.follow.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.itrip.prj.follow.service.FollowService;
import co.itrip.prj.follow.service.FollowVO;

@Controller
public class AjaxFollowController { // 유저가 가이드 ♡ 눌러서 팔로우하기 ♥ (찜기능)
	
	@Autowired
	private FollowService fService;
	
	// 해당 가이드 찜(팔로우) 여부 확인용 데이터 가져오기 (리스트 GetMapping)
	@GetMapping("/ajaxHeartCount.do") 
	@ResponseBody
	public int heartCount(FollowVO vo) {
		return fService.heartCount(vo);
	}
	
	// 찜(팔로우)기능 등록 (등록 PostMapping)
	@PostMapping("/ajaxHeartInsert.do")
	@ResponseBody
	public int heartInsert(FollowVO vo) {
		return fService.heartInsert(vo);
	}
	
	// 찜(언팔로우)기능 삭제 (삭제 GetMapping)
	@GetMapping("/ajaxHeartDelete.do")
	@ResponseBody
	public int heartDelete(FollowVO vo) {
		return fService.heartDelete(vo);
	}
	
	
}

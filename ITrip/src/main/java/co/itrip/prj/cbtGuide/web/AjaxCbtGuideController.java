package co.itrip.prj.cbtGuide.web;


import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.itrip.prj.cbtGuide.service.BookmarkVO;
import co.itrip.prj.cbtGuide.service.CbtGuideService;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.MyCbtLongVO;

/**
* 사용자가 서술형 문제를 풀면 ajax를 통해 화면에 풀이 출력
* @author 김하은
* @date 2022.09.19 
* @version 1.1
*/
@RestController
public class AjaxCbtGuideController {
	
	@Autowired
	private CbtGuideService cgService;

	@PostMapping("/ajaxMyCbtLongList.do")
	public MyCbtLongVO ajaxMyCbtLongList(CbtGuideVO vo, MyCbtLongVO myVo) {
		cgService.ajaxMyCbtLongInsert(myVo); // 사용자가 입력한 값 등록
		return cgService.ajaxMyCbtLongList(myVo);
	}
	
	/* 즐겨찾기 등록 */
	@PostMapping("/ajaxBookmarkInsert.do")
	public int ajaxBookmarkInsert(BookmarkVO vo, Principal prin) {
		vo.setMemberId(prin.getName()); //로그인된 사용자 정보 가져와 담기
		return cgService.ajaxBookmarkInsert(vo);
	}
	
	/* 즐겨찾기 카운트 */
	@RequestMapping("/ajaxBookmarkCount.do")
	public List<Integer> ajaxBookmarkCount(BookmarkVO vo, @RequestParam(value="cbtNos[]") List<Integer> cbtNos, Principal prin) {
		//파라미터 값 : memberId, cbtNo
		vo.setMemberId(prin.getName());
		return cgService.ajaxBookmarkCount(vo);
	}
	
	@GetMapping("/ajaxBookmarDelete.do")
	public int ajaxBookmarkDelete(BookmarkVO vo, Principal prin) {
		//파라미터 값 : memberId, cbtNo
		vo.setMemberId(prin.getName());
		return cgService.ajaxBookmarkDelete(vo);
	}
	

}

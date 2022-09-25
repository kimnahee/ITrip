package co.itrip.prj.cbtGuide.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.itrip.prj.cbtGuide.service.CbtGuideService;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;

/**
* 사용자가 서술형 문제를 풀면 ajax를 통해 화면에 풀이 출력
* @author 김하은
* @date 2022.09.19 
* @version 1.0
*/
@RestController
public class AjaxCbtGuideController {
	@Autowired
	private CbtGuideService cgDao;
	
	@PostMapping("/ajaxExplnaList.do")
	public CbtGuideVO ajaxExplnaList(CbtGuideVO vo, Model model) {
		model.addAttribute("cbtList", cgDao.ajaxExplnaList(vo));
		return cgDao.ajaxExplnaList(vo);
	}

}

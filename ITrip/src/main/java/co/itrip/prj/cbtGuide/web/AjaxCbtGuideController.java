package co.itrip.prj.cbtGuide.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.itrip.prj.cbtGuide.service.CbtGuideService;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.MyCbtLongVO;

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
	public CbtGuideVO ajaxExplnaList(CbtGuideVO vo, MyCbtLongVO myVo,  Model model) {
		model.addAttribute("cbtList", cgDao.ajaxMyCbtLongList(vo));
		model.addAttribute("myList", cgDao.myCbtLongInsert(myVo));
		return cgDao.ajaxMyCbtLongList(vo);
	}
	
	

}

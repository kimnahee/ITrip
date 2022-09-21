package co.itrip.prj.cbtGuide.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.itrip.prj.cbtGuide.service.CbtGuideService;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;

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

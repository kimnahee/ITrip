package co.itrip.prj.cbtGuide.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.itrip.prj.cbtGuide.mapper.CbtGuideMapper;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;

@RestController
public class AjaxCbtGuideController {
	@Autowired
	private CbtGuideMapper cgDao;
	
	@RequestMapping("/ajaxExplnaList.do")
	public String ajaxExplnaList(CbtGuideVO vo, Model model) {
		model.addAttribute("cbtList", cgDao.ajaxExplnaList(vo));
		System.out.println("cbtNo :"+vo.getCbtNo());
		System.out.println("cbtEx :"+vo.getExplna());
		return vo.getExplna();
	}

}

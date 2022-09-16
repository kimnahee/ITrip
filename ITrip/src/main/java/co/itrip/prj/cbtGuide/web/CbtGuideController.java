package co.itrip.prj.cbtGuide.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.itrip.prj.cbtGuide.mapper.CbtGuideMapper;
import co.itrip.prj.gtpcd.mapper.GtpCdMapper;
import co.itrip.prj.langcd.mapper.LangCdMapper;

@Controller
public class CbtGuideController {
	@Autowired
	private CbtGuideMapper cgDao;
	@Autowired
	private GtpCdMapper gtpDao;
	@Autowired
	private LangCdMapper langDao;
	
	@RequestMapping("/cbtGuideMain")
	public String cbtGuideMain(Model model) {
		model.addAttribute("cbtList", cgDao.cbtGuideList());
	    model.addAttribute("gtpCdList", gtpDao.gtpCdList());
		model.addAttribute("langCdList", langDao.langCdList());
	    return "cbtGuide/cbtGuideMain";
	}
	
	@RequestMapping("/cbtGuideList")
	public String cbtGuideList(Model model) {
		model.addAttribute("cbtList", cgDao.cbtGuideList());
		return "cbtGuide/cbtGuideList";
	}

}

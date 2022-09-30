package co.itrip.prj.consult.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.itrip.prj.cmmncd.service.CmmnCdService;
import co.itrip.prj.consult.service.ConsultService;
import co.itrip.prj.consult.service.ConsultVO;
import co.itrip.prj.guide.service.GuideService;



@Controller
public class AjaxConsultController {

	@Autowired
	private GuideService guService; // 가이드 서비스
	
	@Autowired
	private CmmnCdService cdService; // 공통코드 서비스
	
	@Autowired
	private ConsultService conService; // 1:1상담 서비스
	
	// 검색
	@RequestMapping("/ajaxJobListSearch.do")
	@ResponseBody
	public PageInfo<ConsultVO> ajaxJobListSearch(ConsultVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "8") int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		vo.setEnnc("활성화");
		return PageInfo.of(conService.findAll(vo));
	}
	
	

	
}

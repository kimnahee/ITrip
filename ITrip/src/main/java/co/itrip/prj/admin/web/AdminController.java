package co.itrip.prj.admin.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.itrip.prj.consult.service.ConsultService;
import co.itrip.prj.consult.service.ConsultVO;

@Controller
public class AdminController {
	
	@Autowired
	private ConsultService conService; // 1:1 상담서비스
	
	
	@GetMapping("/appClass.do")
	public String appClass() {
		
		return "admin/appclass";
	}
	
	@GetMapping("/appConsult.do")
	public String appConsult(ConsultVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "8") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(conService.findAll(vo)));
		return "admin/appconsult";
	}
	
	

}

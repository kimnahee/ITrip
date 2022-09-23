package co.itrip.prj.consult.web;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.itrip.prj.cmmncd.service.CmmnCdService;
import co.itrip.prj.consult.service.ConsultService;
import co.itrip.prj.consult.service.ConsultVO;

@Controller
public class ConsultController {

	@Autowired
	private CmmnCdService cdService; // 공통코드 서비스
	
	@Autowired
	private ConsultService conService; // 1:1상담 서비스
	
	/*
	 * // 1:1상담 전체 게시판 목록
	 * 
	 * @RequestMapping("/consultList.do") public String consultList(ConsultVO vo,
	 * Model model ) {
	 * //vo.setConsultNo(Integer.parseInt(request.getParameter("consult_no"))); //
	 * 글번호 확인 //model.addAttribute("jobCdList", cdService.jobCdList());
	 * //model.addAttribute("dutyCdList", cdService.dutyCdList()); // 직무공통코드
	 * model.addAttribute("consultList", conService.consultList()); return
	 * "consult/consultList2"; }
	 */
	
	//페이징
	@GetMapping("/consultList.do")
	public String findPage(ConsultVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "8") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(conService.findAll(vo)));
		return "consult/consultList2";
	}
	/*
	 * @GetMapping("/jobCd.do") public String jobCd(Model model) {
	 * model.addAttribute("jobCdList", cdService.jobCdList()); // 업무 공통코드 리스트 return
	 * "layout/layout"; }
	 */
	
	/*
	 * int listCnt = testtableService.testTableCount(); Pagination pagination = new
	 * Pagination(currentPage, cntPerPage, pageSize);
	 * pagination.setTotalRecordCount(listCnt);
	 */
}

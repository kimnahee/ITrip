package co.itrip.prj.consult.web;



import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.itrip.prj.cmmncd.service.CmmnCdService;
import co.itrip.prj.consult.service.ConsultDtVO;
import co.itrip.prj.consult.service.ConsultService;
import co.itrip.prj.consult.service.ConsultVO;
import co.itrip.prj.guide.service.GuideService;
import co.itrip.prj.guide.service.GuideVO;

@Controller
public class ConsultController {

	@Autowired
	private GuideService guService; // 가이드 서비스
	
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
		vo.setEnnc("활성화");
		model.addAttribute("pageInfo", PageInfo.of(conService.findAll(vo)));
		return "consult/consultList";
	}
	
	@RequestMapping("/consultStart.do")
	public String consultStart(Model model, GuideVO vo, ConsultVO cvo, Principal principal) {
		vo.setGuideId(principal.getName());
		model.addAttribute("guide", guService.guideSelect(vo)); // 로그인된 가이드 아이디 확인 (단건조회)
		model.addAttribute("joblist", cdService.jobCdList()); // 카테고리 공통코드
		System.out.println(cdService.jobCdList());
		/*
		 * model.addAttribute("careerCdList", cdService.careerCdList()); // 경력공통코드
		 * model.addAttribute("dutyCdList", cdService.dutyCdList()); // 직무공통코드
		 */		
		return "consult/consultStart";
	}
	
	@PostMapping("/consultInsert.do")
	public String consultInsert(ConsultVO vo) {
		conService.consultInsert(vo);
		return "redirect:gconsult.do";
	}
	
	@RequestMapping("/consultSelectOne.do")
	public String consultSelectOne(ConsultVO vo, Model model, ConsultDtVO dtvo) {
		model.addAttribute("consultOne", conService.consultSelectOne(vo));
		model.addAttribute("consultDt", conService.consultDtList(dtvo));
		return "consult/consultSelectOne";
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

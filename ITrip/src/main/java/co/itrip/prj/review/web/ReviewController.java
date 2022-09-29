package co.itrip.prj.review.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import co.itrip.prj.consult.service.ConsultService;
import co.itrip.prj.consult.service.ConsultVO;
import co.itrip.prj.review.service.ReviewService;
import co.itrip.prj.review.service.ReviewVO;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reServicce;
	
	@Autowired
	private ConsultService conService;
	
	@PostMapping("/reviewConsultInsert.do")
	public String reviewConsultInsert(ReviewVO vo, Principal principal, ConsultVO cvo, Model model) {
		vo.setMemberId(principal.getName());
		/*
		 * cvo.setGuideId(principal.getName()); model.addAttribute("consultList",
		 * conService.consultList());
		 */
		reServicce.reviewConsultInsert(vo);
		return "redirect:myPage"; 
	}
	
	@PostMapping("/reviewClassInsert.do")
	public String reviewClassInsert(ReviewVO vo) {
		reServicce.classReviewInsert(vo);
		return "redirect:mClass";
	}
}

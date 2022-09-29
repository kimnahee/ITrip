package co.itrip.prj.review.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import co.itrip.prj.review.service.ReviewService;
import co.itrip.prj.review.service.ReviewVO;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reServicce;
	
	@PostMapping("/reviewConsultInsert.do")
	public String reviewConsultInsert(ReviewVO vo, Principal principal) {
		vo.setMemberId(principal.getName());
		reServicce.reviewConsultInsert(vo);
		return "redirect:myPage"; 
	}
	
	@PostMapping("/reviewClassInsert.do")
	public String reviewClassInsert(ReviewVO vo) {
		reServicce.classReviewInsert(vo);
		return "redirect:mClass";
	}
}

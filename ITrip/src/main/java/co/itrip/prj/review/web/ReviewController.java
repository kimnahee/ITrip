package co.itrip.prj.review.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	// 은지 상담 리뷰 등록
	@PostMapping("/reviewConsultInsert.do")
	public String reviewConsultInsert(ReviewVO vo, Principal principal, ConsultVO cvo, Model model) {
		vo.setMemberId(principal.getName());
		reServicce.reviewConsultInsert(vo);
		return "redirect:myPage"; 
	}
	
	// class review insert
	@PostMapping("/reviewClassInsert.do")
	public String reviewClassInsert(ReviewVO vo) {
		reServicce.classReviewInsert(vo);
		return "redirect:mClass";
	}
	
	@GetMapping("/classReviewSelect.do")
	@ResponseBody
	public ReviewVO classReviewSelect(ReviewVO vo, HttpServletRequest request, Principal principal) {
		var no = request.getParameter("no");
		System.out.println("출력요망" +no);
		vo.setMemberId(principal.getName());
		vo.setNo(Integer.parseInt(request.getParameter("no")));
		return reServicce.classReviewSelect(vo);
		
	}
	
	
}

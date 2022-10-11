package co.itrip.prj.review.web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.itrip.prj.consult.service.ConsultVO;
import co.itrip.prj.review.service.ReviewService;
import co.itrip.prj.review.service.ReviewVO;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reServicce; // 리뷰서비스
	
	// 은지-상담 리뷰 등록
	@PostMapping("/reviewConsultInsert.do")
	public String reviewConsultInsert(ReviewVO vo, Principal principal, ConsultVO cvo, Model model) {
		vo.setMemberId(principal.getName());
		reServicce.reviewConsultInsert(vo);
		return "redirect:myPage"; 
	}
	
	// 은지-상담상세페이지 리뷰 리스트
	@GetMapping("/reviewList.do")
	@ResponseBody
	public List<ReviewVO> reviewList(ReviewVO vo) {
		return reServicce.reviewList(vo);
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 소정 - 리뷰 삭제
	@PostMapping("/deleteReview.do")
	@ResponseBody
	public int deleteReview(ReviewVO vo) {
		return reServicce.deleteReview(vo);
	}
	
	// 소정 class review insert
	@PostMapping("/reviewClassInsert.do")
	public String reviewClassInsert(ReviewVO vo) {
		reServicce.classReviewInsert(vo);
		return "redirect:mClass";
	}
	
	// 소정 리뷰 이미 작성했는지 조회
	@GetMapping("/classReviewSelect.do")
	@ResponseBody
	public ReviewVO classReviewSelect(ReviewVO vo, HttpServletRequest request, Principal principal) {
		vo.setMemberId(principal.getName());
		return reServicce.classReviewSelect(vo);
		
	}
	
	// (consult) 리뷰 이미 작성했는지 상태 확인
	@GetMapping("/consultReviewSelect.do")
	@ResponseBody
	public ReviewVO consultReviewSelect(ReviewVO vo, HttpServletRequest request, Principal principal) {
		vo.setMemberId(principal.getName());
		return reServicce.consultReviewSelect(vo);
		
	}
	
	
}

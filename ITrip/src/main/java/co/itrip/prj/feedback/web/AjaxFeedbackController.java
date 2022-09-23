package co.itrip.prj.feedback.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.itrip.prj.feedback.service.FeedbackService;
import co.itrip.prj.feedback.service.FeedbackVO;

@RestController
public class AjaxFeedbackController {
	
	@Autowired
	FeedbackService fDao;
	
	@RequestMapping("/feedbackList.do")
	public List<FeedbackVO> ajaxFeedbackList(FeedbackVO vo) {
		return fDao.ajaxFeedbackList(vo);
	}
	
	
	@PostMapping("/feedbackInsert.do")
	public int ajaxFeedbackInsert(FeedbackVO vo,Principal principal) {
		vo.setMemberId(principal.getName());
		
		System.out.println(vo.getCbtNo());

		System.out.println(vo.getContent());

		System.out.println(vo.getFeedbackNo());

		System.out.println(vo.getMemberId());

		
		return fDao.ajaxFeedbackInsert(vo);
	}
}

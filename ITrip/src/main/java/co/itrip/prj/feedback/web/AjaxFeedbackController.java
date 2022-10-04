package co.itrip.prj.feedback.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.itrip.prj.feedback.service.FeedbackService;
import co.itrip.prj.feedback.service.FeedbackVO;

@RestController
public class AjaxFeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	
	@RequestMapping("/feedbackList.do")
	public PageInfo<FeedbackVO> ajaxFeedbackList(FeedbackVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "5") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		return PageInfo.of(feedbackService.ajaxFeedbackList(vo));
	}
	
	
	@PostMapping("/feedbackInsert.do")
	public int ajaxFeedbackInsert(FeedbackVO vo,Principal principal) {
		vo.setMemberId(principal.getName());
		return feedbackService.ajaxFeedbackInsert(vo);
	}
	
	@PostMapping("/feedbackDelete.do")
	public int ajaxFeedbackDelete(FeedbackVO vo) {
		return feedbackService.ajaxFeedbackDelete(vo);
	}
	
}

package co.itrip.prj.feedback.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.itrip.prj.feedback.service.FeedbackService;
import co.itrip.prj.feedback.service.FeedbackVO;

@RestController
public class AjaxFeedbackController {
	
	@Autowired
	FeedbackService fDao;
	
	@RequestMapping("/feedbackList.do")
	public List<FeedbackVO> ajaxFeedbackList(FeedbackVO vo,Model model) {
		//model.addAttribute("feedbackList", fDao.feedbackList(vo));
		//return "cbtUser/cbtUserList";
		return fDao.ajaxFeedbackList(vo);
	}
}

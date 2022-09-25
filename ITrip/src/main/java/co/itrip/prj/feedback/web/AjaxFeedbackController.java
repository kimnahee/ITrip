package co.itrip.prj.feedback.web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
	FeedbackService fDao;
	
	@RequestMapping("/feedbackList.do")
	public List<FeedbackVO> ajaxFeedbackList(FeedbackVO vo) {
		
		return fDao.ajaxFeedbackList(vo);
	}
	
	
	@PostMapping("/feedbackInsert.do")
	public int ajaxFeedbackInsert(FeedbackVO vo,Principal principal) {
		vo.setMemberId(principal.getName());
		return fDao.ajaxFeedbackInsert(vo);
	}
	
	@PostMapping("/feedbackDelete.do")
	public int ajaxFeedbackDelete(FeedbackVO vo) {
		return fDao.ajaxFeedbackDelete(vo);
	}
	
}

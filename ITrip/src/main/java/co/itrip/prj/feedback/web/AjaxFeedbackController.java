package co.itrip.prj.feedback.web;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
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
	public PageInfo<FeedbackVO> ajaxFeedbackList(FeedbackVO vo, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "5") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		return PageInfo.of(fDao.ajaxFeedbackList(vo));
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

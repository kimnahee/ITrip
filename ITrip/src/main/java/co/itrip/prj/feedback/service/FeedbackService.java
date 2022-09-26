package co.itrip.prj.feedback.service;

import java.util.List;

import co.itrip.prj.feedback.web.PageBean;


public interface FeedbackService {
	List<FeedbackVO> ajaxFeedbackList(FeedbackVO vo);
	int ajaxFeedbackInsert(FeedbackVO vo);
	int ajaxFeedbackDelete(FeedbackVO vo);
	

	//page test..
	PageBean<FeedbackVO> ajaxFeedbackList(int pageNum, int pageSize);
}

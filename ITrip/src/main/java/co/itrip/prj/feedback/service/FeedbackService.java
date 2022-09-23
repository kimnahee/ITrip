package co.itrip.prj.feedback.service;

import java.util.List;


public interface FeedbackService {
	List<FeedbackVO> ajaxFeedbackList(FeedbackVO vo);
	int ajaxFeedbackInsert(FeedbackVO vo);
}

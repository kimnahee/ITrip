package co.itrip.prj.feedback.mapper;

import java.util.List;

import co.itrip.prj.feedback.service.FeedbackVO;

public interface FeedbackMapper {
	
	List<FeedbackVO> ajaxFeedbackList(FeedbackVO vo);
}

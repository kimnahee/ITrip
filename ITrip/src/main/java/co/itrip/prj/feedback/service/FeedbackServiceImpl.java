package co.itrip.prj.feedback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.feedback.mapper.FeedbackMapper;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackMapper map;
	
	@Override
	public List<FeedbackVO> ajaxFeedbackList(FeedbackVO vo) {
		return map.ajaxFeedbackList(vo);
	}

	@Override
	public int ajaxFeedbackInsert(FeedbackVO vo) {
		return map.ajaxFeedbackInsert(vo);
	}

	@Override
	public int ajaxFeedbackDelete(FeedbackVO vo) {
		return map.ajaxFeedbackDelete(vo);
	}

}

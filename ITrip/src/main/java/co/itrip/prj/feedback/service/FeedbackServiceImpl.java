package co.itrip.prj.feedback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import co.itrip.prj.feedback.mapper.FeedbackMapper;
import co.itrip.prj.feedback.web.PageBean;

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

	@Override //test...
	public PageBean<FeedbackVO> ajaxFeedbackList(int pageNum, int pageSize) {
			 PageHelper.startPage(pageNum, pageSize);
			 List<FeedbackVO> list = this.map.ajaxFeedbackList();
			 return new PageBean<>(list);
			 
	}



}

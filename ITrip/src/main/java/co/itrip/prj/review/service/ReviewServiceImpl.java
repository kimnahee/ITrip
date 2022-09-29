package co.itrip.prj.review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.review.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper map;
	@Override
	public int reviewConsultInsert(ReviewVO vo) {
		// TODO Auto-generated method stub
		return map.reviewConsultInsert(vo);
	}

}

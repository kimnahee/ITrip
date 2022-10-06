package co.itrip.prj.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.review.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper map;
	
	@Override
	public int reviewConsultInsert(ReviewVO vo) {
		// 은지 - 상담 리뷰 등록 2022.09.28
		return map.reviewConsultInsert(vo);
	}

	@Override
	public int classReviewInsert(ReviewVO vo) {
		// 소정 - 클래스 리뷰 등록
		return map.classReviewInsert(vo);
	}

	@Override
	public ReviewVO classReviewSelect(ReviewVO vo) {
		// 소정 - 클래스 리뷰 선택된것
		return map.classReviewSelect(vo);
	}

	@Override
	public List<ReviewVO> reviewList(ReviewVO vo) {
		// 은지 - 리뷰 리스트 , 평점 평균출력 2022.10.06
		return map.reviewList(vo);
	}



}

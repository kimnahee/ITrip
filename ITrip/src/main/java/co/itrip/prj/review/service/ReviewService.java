package co.itrip.prj.review.service;

import java.util.List;

public interface ReviewService {
	
	List<ReviewVO> reviewList(ReviewVO vo); // 은지 -  상담& 클래스 리뷰 리스트, 별뿌리기, 평점평균 출력 2022.10.06
	int reviewConsultInsert(ReviewVO vo); // 은지 - 상담 리뷰 등록 2022.09.28
	
	
	int classReviewInsert(ReviewVO vo); // 소정 - 클래스 리뷰등록
	ReviewVO classReviewSelect(ReviewVO vo);  // 소정 - 리뷰 단건조회
	ReviewVO consultReviewSelect(ReviewVO vo);  // 소정 - 리뷰 단건조회
	int deleteReview(ReviewVO vo); //소정 - 리뷰삭제

}

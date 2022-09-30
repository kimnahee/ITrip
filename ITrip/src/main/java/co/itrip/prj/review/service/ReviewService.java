package co.itrip.prj.review.service;


public interface ReviewService {
	
	int reviewConsultInsert(ReviewVO vo); // 리뷰 등록
	int classReviewInsert(ReviewVO vo); // 클래스 리뷰등록
	ReviewVO classReviewSelect(ReviewVO vo);  // 리뷰 단건조회

}

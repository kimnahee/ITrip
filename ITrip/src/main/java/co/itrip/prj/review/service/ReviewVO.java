package co.itrip.prj.review.service;

import java.sql.Date;

import lombok.Data;

@Data
public class ReviewVO {

	// 리뷰 테이블
	private int reviewNo; // 리뷰글번호
	private String guideId; // 가이드 아이디
	private String nick; // 닉네임
	private String content; // 내용
	private Date dt; // 날짜
	private String ctgry; // 리뷰종류 1:1 상담, 클래스
	private String memberId; // 회원 아이디
	private int star; // 별점
	private int no; // 상품 번호
	
}

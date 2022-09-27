package co.itrip.prj.payform.service;

import java.util.Date;

import lombok.Data;

/**
* 결제 및 사용자가 클래스 혹은 상담 신청 하면 정보 담는 곳
* @author 김하은
* @date 2022.09.27
* @version 1.0
*/
@Data
public class PayformVO {
	
	private int partnerOrderId;       //가맹점 주문버호
	private String cid;               //가맹점 코드
	private String memberId;          //신청자 id
	private String partnerMemberId;   //가맹점 회원 id
	private String category;          //상담 또는 클래스 구분
	private String itemName;          //주문 번호
	private int quantity;             //상품 수량
	private int totalAmount;          //상품 총액
	private int taxFreeAmount;        //상품 비과세 금액
	private Date setlede;             //신청일자(결제일)
	private String qestn;             //상담 사전 질문
}

package co.itrip.prj.payform.service;

import java.sql.Date;

import lombok.Data;

/**
* 결제 및 사용자가 클래스 혹은 상담 신청 하면 정보 담는 곳
* @author 김하은
* @date 2022.09.27
* @version 1.1
*/
@Data
public class PayformVO {
	
	private String merchant_uid;      // 주문번호 (결제고유번호 class : cl001..., consult: co001...)
	                                  // ※ 한 번 결제고유번호로 결제 수행하면 결제 안되니 테스트 할 때 주의 필요 
	private String name;              // 주문명 : 클래스 이름, 상담 이름...
	private int amount;               // 금액
	private String member_id;         // 결제 신청자
	private String category;          // 상담 또는 클래스 구분
	private int no;                // 상품 번호
	private Date setlede;             // 결제일자
	
	
	private Date conday;			// 상담날짜
	private String beginTime;       // 상담 시작시간
	private String endTime;  		// 상담 끝시간
	
}

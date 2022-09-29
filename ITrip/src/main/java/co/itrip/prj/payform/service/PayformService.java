package co.itrip.prj.payform.service;

/**
* 결제 및 신청 기능 모아놓은 인터페이스
* @author 김하은
* @date 2022.09.27
* @version 1.0
*/
public interface PayformService {
	//결제처리
	public void addPay(PayformVO vo);

	//경아 - 클래스결제테이블insert
	int clPayformInsert(PayformVO vo);
}

package co.itrip.prj.payform.mapper;



import co.itrip.prj.payform.service.PayformVO;

public interface PayFormMapper {
	int clPayformInsert(PayformVO vo);
	
	//은지 - 상담결제테이블insert
	int coPayformInsert(PayformVO vo);
	
	//은지 - 결제 카운트 
	int payCount(PayformVO vo); // 결제 횟수 체크

}

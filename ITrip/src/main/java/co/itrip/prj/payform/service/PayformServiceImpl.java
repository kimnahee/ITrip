package co.itrip.prj.payform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.itrip.prj.payform.mapper.PayFormMapper;

@Service
public class PayformServiceImpl implements PayformService {

	@Autowired
	PayFormMapper map;
	
	@Override
	public void addPay(PayformVO vo) {
		// TODO Auto-generated method stub

	}

	@Override 
	public int clPayformInsert(PayformVO vo) {
		return map.clPayformInsert(vo);
	}

}

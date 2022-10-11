package co.itrip.prj.payform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.itrip.prj.calendar.mapper.CalendarMapper;
import co.itrip.prj.calendar.service.CalendarVO;
import co.itrip.prj.consult.service.ConsultDtVO;
import co.itrip.prj.consult.service.ConsultVO;
import co.itrip.prj.iclass.mapper.ClassMapper;
import co.itrip.prj.iclass.service.ClassAttendVO;
import co.itrip.prj.payform.mapper.PayFormMapper;

@Service
public class PayformServiceImpl implements PayformService {

	@Autowired
	PayFormMapper map;
	@Autowired
	ClassMapper cmap;
	@Autowired
	CalendarMapper calmap;
	
	@Override
	public void addPay(PayformVO vo) {
		// TODO Auto-generated method stub

	}

	@Override 
	@Transactional
	public int clPayformInsert(PayformVO vo,ClassAttendVO cvo) {
		map.clPayformInsert(vo);
		return cmap.classAttendInsert(cvo);
	}

	@Override
	@Transactional
	public int coPayformInsert(PayformVO vo, CalendarVO cvo) {
		map.coPayformInsert(vo);
		return calmap.calendarInsert(cvo);
	}

}

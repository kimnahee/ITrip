package co.itrip.prj.payform.web;

import java.security.Principal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.itrip.prj.calendar.service.CalendarService;
import co.itrip.prj.calendar.service.CalendarVO;
import co.itrip.prj.iclass.service.ClassAttendVO;
import co.itrip.prj.iclass.service.ClassDtVO;
import co.itrip.prj.iclass.service.ClassService;
import co.itrip.prj.iclass.service.ClassVO;
import co.itrip.prj.payform.service.PayformService;
import co.itrip.prj.payform.service.PayformVO;

/**
* 결제 관련 컨트롤러
* @author 김하은
* @date 2022.09.27
* @version 1.1
*/
@Controller
public class PayformController {
	
	@Autowired
	private PayformService payformService;
	
	@Autowired
	private ClassService classService; //클래스 서비스
	
	@Autowired
	private CalendarService calendarService; //캘린더 서비스

	
	
	//경아 - 클래스구입
	@PostMapping("/ClPayformInsert.do")
	public String ClPayformInsert(PayformVO vo, ClassVO clvo, ClassDtVO cdvo ,ClassAttendVO cvo, CalendarVO cavo, Principal prin, HttpServletRequest request) {
		cvo.setMemberId(prin.getName());
		int classNo = Integer.parseInt(request.getParameter("classNo"));
		String merchantUid = request.getParameter("merchantUid");
		String guideId = request.getParameter("guideId");
		String name = request.getParameter("name");
		
		//payform에 먼저 insert해야함(부모키가 없음) => 수정필요
		vo.setNo(classNo);
		payformService.clPayformInsert(vo, cvo, cavo);
		cdvo.setClassNo(classNo);
		List<ClassDtVO> dtList = classService.classDtList(cdvo);
		System.out.println("dtList : " + dtList);
		//System.out.println(dtList.size());
		//cavo => calendar_no, merchant_uid, guide_id, name, conday, begin_time, no 필요
		//conday랑 begin time은 dtList에 들어있음 / no = classNo임
		
		for(int i = 0; i<dtList.size(); i++) {
			//System.out.println("dtList~~:" + dtList.get(i));
			String conday = dtList.get(i).getTerm();
			String beginTime = dtList.get(i).getBeginTime();
			cavo.setMerchantUid(merchantUid);
			cavo.setGuideId(guideId);
			cavo.setName(name);
			cavo.setNo(classNo); //no
			cavo.setConday(conday);
			cavo.setBeginTime(beginTime);
			System.out.println(cavo);
			calendarService.calendarInsert(cavo);
		}
		
		return "redirect:iClassList.do";
	}
	
	
	//은지 - 상담구입
	@PostMapping("/CoPayformInsert.do")
	public String CoPayformInsert(PayformVO vo, CalendarVO cvo, Principal prin) {
		//int no = Integer.parseInt(request.getParameter("consultNo"));
		//System.out.println("!!!!!!!!!"+no);
		//System.out.println("!!!!!!!!!"+vo.getNo());
		vo.setMember_id(prin.getName());
		int end = Integer.parseInt(vo.getBeginTime()) + 1;
		String begin = vo.getBeginTime();
		String beginTime = begin + ":00";
		String endTime = end + ":00";
		System.out.println("testttttttt" + endTime);
		vo.setBeginTime(beginTime);
		vo.setEndTime(endTime);
		payformService.coPayformInsert(vo,cvo);
		System.out.println(vo);
		return "redirect:myPage";
	}
	
	
	
	/*
	 * 2022.09.27 작업하였으나 API변경으로 인해 사용안함
	 * @GetMapping("/payformTest.do") public String payformTest() { return
	 * "payform/payformTest"; } 
	 */
	
	 //결제 성공하면 이동할 페이지 !
	 @GetMapping("/payformSuccess.do") 
	 public String payformSuccess() { 
		 return "payform/payformSuccess"; 
    } 
	   
	  //결제 실패하면 이동할 페이지 함!
	 @GetMapping("/payformFail.do") 
	 public String payformFail() { 
		 return"payform/payformFail"; 
	 } 
	 
	 //결제 취소하면 이동할 페이지 : 혹시 변경되면 ajax에서 변경해줘야함!
	 @GetMapping("/payformCancel.do") 
	 public String payformCancel() { 
		 return "payform/payformCancel"; 
	}
	 
	
	// I'mport를 통해 카카오페이 호출
	@GetMapping("/payformIamport.do")
	public String payformIamport() {
		return "payform/payformIamport";
	}

}

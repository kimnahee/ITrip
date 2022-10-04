package co.itrip.prj.payform.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.itrip.prj.iclass.service.ClassAttendVO;
import co.itrip.prj.iclass.service.ClassService;
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

	
	//경아 - 클래스구입
	@PostMapping("/ClPayformInsert.do")
	public String ClPayformInsert(PayformVO vo,ClassAttendVO cvo,Principal prin) {
		cvo.setMemberId(prin.getName());
		payformService.clPayformInsert(vo,cvo);
		
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

package co.itrip.prj.payform.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
* ajax를 통해 결제 처리
* @author 김하은
* @date 2022.09.27
* @version 1.1
*/
@Controller
public class PayformController {
	
	@GetMapping("/payformTest.do")
	public String payformTest() {
		return "payform/payformTest";
	}

}

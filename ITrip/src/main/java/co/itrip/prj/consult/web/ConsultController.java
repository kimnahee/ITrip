package co.itrip.prj.consult.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsultController {

	@GetMapping("/consultList.do")
	public String consultList() {
		return "consult/consultList2";
	}
	
}

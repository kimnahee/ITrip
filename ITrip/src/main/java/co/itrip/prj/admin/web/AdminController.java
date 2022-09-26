package co.itrip.prj.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/approve.do")
	public String approve() {
		
		return "admin/approve";
	}

}

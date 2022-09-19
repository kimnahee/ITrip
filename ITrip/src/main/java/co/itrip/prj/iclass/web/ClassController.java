package co.itrip.prj.iclass.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassController {
	
	@GetMapping("/iClass") 
	public String iClass() {
		return "class/iclass";
	}

}

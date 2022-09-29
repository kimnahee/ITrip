package co.itrip.prj;


import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
@MapperScan(basePackages = "co.itrip.prj.**.mapper")
public class ITripApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ITripApplication.class, args);
	}

	// 메인화면
	@GetMapping("/")
	public String main(Model model,Authentication authentication) {
		//UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        //model.addAttribute("author",userDetails.getUsername());
		
		return "main/main";
	}
	
	//로그인 폼
	@GetMapping("/loginForm.do")
	public String loginForm(HttpServletRequest request) {
		request.getSession(true); //세션 강제 세션 추가
		return "main/loginForm";
	}
	
	//회원가입 폼
	@GetMapping("/signupForm.do")
	public String signupForm() {
		return "main/signupForm";
	}
	
}

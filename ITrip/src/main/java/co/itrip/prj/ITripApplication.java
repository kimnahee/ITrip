package co.itrip.prj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
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
	public String main() {
		return "main/main";
	}
	
	//로그인 폼
	@GetMapping("/loginForm.do")
	public String loginForm() {
		return "main/loginForm";
	}
	
	//회원가입 폼
	@GetMapping("/signupForm.do")
	public String signupForm() {
		return "main/signupForm";
	}
}

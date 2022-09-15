package co.itrip.prj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class ITripApplication {

	public static void main(String[] args) {
		SpringApplication.run(ITripApplication.class, args);
	}

	@GetMapping("/")
	public String main() {
		return "main/main";
	}
	
	@GetMapping("/study.do")
	public String study() {
		return "community/study";
	}
}

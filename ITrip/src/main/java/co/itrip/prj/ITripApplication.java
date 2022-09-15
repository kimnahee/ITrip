package co.itrip.prj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "co.itrip.prj.**.mapper")
public class ITripApplication {

	public static void main(String[] args) {
		SpringApplication.run(ITripApplication.class, args);
	}

}

package co.itrip.prj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.MyCbtHderVO;
import net.bytebuddy.utility.dispatcher.JavaDispatcher.Container;

@SpringBootTest
class ITripApplicationTests {

	@Test
	void contextLoads() {
	}
	
	//han : Map TEST 
	@Test
    public List<Map<Integer, Object>> cbtGuideListFive(CbtGuideVO vo) {
		
		MyCbtHderVO myVO = new MyCbtHderVO();
		
	
		Map < String, Object > param = new HashMap < > ();
		
		param.put("cbtNo1", myVO.getCbtNo1());
		param.put("cbtNo2", myVO.getCbtNo2());
		param.put("cbtNo3", myVO.getCbtNo3());
		param.put("cbtNo4", myVO.getCbtNo4());
		param.put("cbtNo5", myVO.getCbtNo5());
		
		
		return null;
	}

}

package co.itrip.prj.cbtGuide.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.itrip.prj.cbtGuide.service.CbtGuideService;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.MyCbtLongVO;

/**
* 사용자가 서술형 문제를 풀면 ajax를 통해 화면에 풀이 출력
* @author 김하은
* @date 2022.09.19 
* @version 1.1
*/
@RestController
public class AjaxCbtGuideController {
	@Autowired
	private CbtGuideService cgDao;
	
	@PostMapping("/ajaxMyCbtLongList.do")
	public MyCbtLongVO ajaxMyCbtLongList(CbtGuideVO vo, MyCbtLongVO myVo,  Model model, HttpServletRequest request) {
		myVo.setCbtNo(Integer.parseInt(request.getParameter("cbtNo"))); // 요청된 파라미터 값 유형코드 담음 
		
		cgDao.ajaxMyCbtLongInsert(myVo); // 사용자가 입력한 값 등록
		//System.out.println("vo.getChklist()===="+ vo.getChklist());
		
		//model.addAttribute("cbtList", cgDao.ajaxMyCbtLongList(vo));
		//model.addAttribute("myList", cgDao.myCbtLongInsert(myVo));
		return cgDao.ajaxMyCbtLongList(myVo);
	}
	
	
	

}

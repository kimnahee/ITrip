package co.itrip.prj.cbtUser.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.itrip.prj.cbtUser.service.CbtUserService;
import co.itrip.prj.cbtUser.service.CbtUserVO;

@RestController
public class AjaxCbtUserController {

	@Autowired
	CbtUserService dao;
	
	@RequestMapping("/ajaxQuestion.do")
	public CbtUserVO AjaxQuestion(CbtUserVO vo) {
		return dao.ajaxQuestion(vo);
	}
}

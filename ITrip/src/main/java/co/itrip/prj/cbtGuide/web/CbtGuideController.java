package co.itrip.prj.cbtGuide.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.itrip.prj.cbtGuide.mapper.CbtGuideMapper;
import co.itrip.prj.cbtGuide.service.CbtGuideService;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.CbtKeywordVO;
import co.itrip.prj.gtpcd.mapper.GtpCdMapper;
import co.itrip.prj.langcd.mapper.LangCdMapper;

@Controller
public class CbtGuideController {
	@Autowired
	private CbtGuideMapper cgDao;
	@Autowired
	private GtpCdMapper gtpDao;
	@Autowired
	private LangCdMapper langDao;
	
	@Autowired
	private CbtGuideService cgService;
	
	
	
	//메인화면
	@RequestMapping("/cbtGuideMain.do")
	public String cbtGuideMain(Model model) {
		model.addAttribute("cbtList", cgDao.cbtGuideList());
	    model.addAttribute("gtpCdList", gtpDao.gtpCdList());
		model.addAttribute("langCdList", langDao.langCdList());
	    return "cbtGuide/cbtGuideMain";
	}
	
	/*@RequestMapping("/cbtGuideList")
	public String cbtGuideList(CbtGuideVO vo, Model model) {
		model.addAttribute("cbtList", cgDao.cbtGuideList());
		return "cbtGuide/cbtGuideList";
	}*/
	//유형, 언어별로 리스트 문제 출력
	@PostMapping("/cbtGuideListTab.do")
	public String cbtGuideListTab(CbtGuideVO vo, Model model) {
		model.addAttribute("cbtList", cgDao.cbtGuideListTab(vo));
		return "cbtGuide/cbtGuideListTab";
	}
	//문제 등록 폼
	@GetMapping("/cbtGuideInsertForm.do")
	public String cbtGuideInsertForm(Model model) {
	    model.addAttribute("gtpCdList", gtpDao.gtpCdList());
		model.addAttribute("langCdList", langDao.langCdList());
		return "cbtGuide/cbtGuideInsertForm";
	}
	//등록
	@PostMapping("/cbtGuideInsert.do")
	public String cbtGuideInsert(CbtGuideVO vo, CbtKeywordVO kvo, Model model,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		//파일 처리
		String saveFolder = "c://fileUpload"; //저장할 공간 폴더 명
		String originalFileName= file.getOriginalFilename(); //넘어온 파일명
		
		if(!file.isEmpty()) {
			//파일명 충돌방지를 위한 파일별명만듦
			String saveFileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf('.'));
			//파일 물리적 위치에 저장
			file.transferTo(new File(saveFolder, saveFileName));
			
			vo.setAttach(originalFileName);
			vo.setAttachDir(saveFolder + File.separator + saveFileName);
		}
		cgService.cbtGuideInsert(vo);

		return "redirect:/cbtGuideMain.do";
	}

}

package co.itrip.prj.cbtUser.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.itrip.prj.cbtUser.service.CbtUserService;
import co.itrip.prj.cbtUser.service.CbtUserVO;
import co.itrip.prj.cmmncd.service.CmmnCdService;

@Controller
public class CbtUserController {
	
	@Value("${file.dir}")
	private String fileDir;

	@Autowired
	CbtUserService cbtUserService;
	
	@Autowired
	CmmnCdService cmmnCdService;
	

	@RequestMapping("/cbtUserMain.do")
	public String langCdList(Model model) {
		model.addAttribute("langCdList",cmmnCdService.cdList("L"));
		return "cbtUser/cbtUserMain";
	}
	
	@RequestMapping("/cbtUserSelectOne.do")
	public String cbtUserSelectOne(CbtUserVO vo,Model model) {
		model.addAttribute("cbtOne", cbtUserService.cbtUserSelectOne(vo));
		return "cbtUser/cbtUserList";
	}
	
	@GetMapping("/cbtUserInsertForm.do")
	public String cbtUserInsertForm(Model model) {
		model.addAttribute("utpCdList", cmmnCdService.cdList("U"));
		model.addAttribute("langCdList", cmmnCdService.cdList("L"));
		return "cbtUser/cbtUserInsertForm";
	}

	
	@PostMapping("/cbtUserInsert.do")
	public String cbtUserInsert(CbtUserVO vo, Model  model, MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		
		String oFileName = file.getOriginalFilename();
		if(!oFileName.isEmpty()) {
			String sFileName = UUID.randomUUID().toString()+oFileName.substring(oFileName.lastIndexOf("."));
			String path = fileDir+"/CBT_USER/"+sFileName;
			file.transferTo(new File(path));
			vo.setAttach(oFileName); 
			vo.setAttachDir(sFileName);
		}
		
		cbtUserService.cbtUserInsert(vo);
		
		return "redirect:cbtUserMain.do";
	}
	
	
	// 나의 문제 출제 목록 
	@GetMapping("/cbtUserMyList.do")
	public String cbtGuideMyList(Principal prin, CbtUserVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		
		vo.setMemberId(prin.getName());
		PageHelper.startPage(pageNum, pageSize); 
		List<CbtUserVO> list = cbtUserService.cbtUserMyList(vo);
	
		model.addAttribute("pageInfo", PageInfo.of(list));
		return "cbtUser/cbtUserMyList";
	}
	
	// 나의 문제 상세보기
	@PostMapping("/cbtUserMyOne.do")
	public String cbtUserListOne(CbtUserVO vo, Model model) {
		model.addAttribute("langCdList",cmmnCdService.cdList("L"));
		String ucd = cmmnCdService.cdNameList("U", vo.getUtpCd()); 
	    String lcd = cmmnCdService.cdNameList("L", vo.getLangCd());
		vo.setUtpCdName(ucd);
		vo.setLangCdName(lcd);
		
		model.addAttribute("myCbt", cbtUserService.cbtUserMyOne(vo));
		return "cbtUser/cbtUserMyOne";
	}
	
	@PostMapping("/cbtUserMyUpdate.do")
	public String cbtUserMyUpdate(CbtUserVO vo, Model  model, MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		
		String oFileName = file.getOriginalFilename();
		if(!oFileName.isEmpty()) {
			//기존파일삭제
			
			//업로드
			String sFileName = UUID.randomUUID().toString()+oFileName.substring(oFileName.lastIndexOf("."));
			String path = fileDir+"/CBT_USER/"+sFileName;
			file.transferTo(new File(path));
			vo.setAttach(oFileName); 
			vo.setAttachDir(sFileName);
		}
		cbtUserService.cbtUserMyUpdate(vo);
		return "redirect:cbtUserMyList.do";
	}
	
	@PostMapping("/cbtUserMyDelete.do")
	public String cbtUserMyDelete(CbtUserVO vo) {
		cbtUserService.cbtUserMyDelete(vo);
		return "redirect:cbtUserMyList.do";
	}
	
	@RequestMapping("/cbtCustomMain.do")
	public String cbtCustomMain(Model model) {
		return "cbtCustom/cbtCustomInsertForm";
	}
}

package co.itrip.prj.cbtUser.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.itrip.prj.cbtUser.mapper.CbtUserMapper;
import co.itrip.prj.cbtUser.service.CbtUserVO;
import co.itrip.prj.langcd.mapper.LangCdMapper;
import co.itrip.prj.utpcd.mapper.UtpCdMapper;

@Controller
public class CbtUserController {
	
	@Autowired
	CbtUserMapper cuDao;
	@Autowired
	UtpCdMapper utpDao;
	@Autowired
	LangCdMapper langDao;
	
	int r=0;
	
	@RequestMapping("/cbtUserList.do")
	public String cbtUserList(CbtUserVO vo, Model model) {
		model.addAttribute("cbtList",cuDao.cbtUserList(vo));
		
		return "cbtUser/cbtUserList";
	}
	
	@GetMapping("/cbtUserInsertForm.do")
	public String cbtUserInsertForm(Model model) {
		model.addAttribute("utpCdList", utpDao.utpCdList());
		model.addAttribute("langCdList", langDao.langCdList());
		return "cbtUser/cbtUserInsertForm";
	}
	
	@PostMapping("/cbtUserInsert.do")
	public String cbtUserInsert(CbtUserVO vo, Model  model, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		String saveFolder ="c://fileUpload";//저장할 공간 폴더 명
		
		String originalFileName = file.getOriginalFilename();//넘어온 파일명
		
		//if(!originalFileName.isEmpty()) {
		if(!file.isEmpty()) {
			//파일명 충돌방지를 위한 파일별명만듦
			String saveFileName = UUID.randomUUID().toString() + originalFileName.substring(originalFileName.lastIndexOf('.'));
			//파일을 물리적 위치에 저장
			file.transferTo(new File(saveFolder, saveFileName));
			
			vo.setAttach(originalFileName);
			vo.setAttachDir(saveFolder + File.separator + saveFileName);
			
		}
		cuDao.cbtUserInsert(vo);
	
		//model.addAttribute("r", r);
		model.addAttribute("langCdList",langDao.langCdList());
		return "cbtUser/cbtUserMain";
		//return "cbtUserMain.do";
	}
}

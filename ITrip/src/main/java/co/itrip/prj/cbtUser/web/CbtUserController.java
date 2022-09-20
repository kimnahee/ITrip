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
import co.itrip.prj.cbtUser.service.CbtUserService;
import co.itrip.prj.cbtUser.service.CbtUserVO;
import co.itrip.prj.langcd.mapper.LangCdMapper;
import co.itrip.prj.langcd.service.LangCdService;
import co.itrip.prj.utpcd.mapper.UtpCdMapper;
import co.itrip.prj.utpcd.service.UtpCdService;

@Controller
public class CbtUserController {
	
	@Autowired
	CbtUserService cuDao;
	@Autowired
	UtpCdService utpDao;
	@Autowired
	LangCdService langDao;
	
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
	public String cbtUserInsert(CbtUserVO vo, Model  model, MultipartFile file) throws IllegalStateException, IOException {
		String projectPath = System.getProperty("user.dir")+"/src/main/resources/static/files"; //프로젝트 경로
		UUID uuid = UUID.randomUUID();
		String filename = uuid + "_" + file.getOriginalFilename();
		File saveFile = new File(projectPath, filename);
		file.transferTo(saveFile);
		vo.setAttach(filename);
		String path = "/files/" + filename;
		vo.setAttachDir(path);
		cuDao.cbtUserInsert(vo);
	
		model.addAttribute("langCdList",langDao.langCdList());
		return "cbtUser/cbtUserMain";
		//return "cbtUserMain.do";
	}
}

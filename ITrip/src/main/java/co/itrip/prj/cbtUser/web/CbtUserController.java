package co.itrip.prj.cbtUser.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
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
import co.itrip.prj.feedback.service.FeedbackService;
import co.itrip.prj.feedback.service.FeedbackVO;
import co.itrip.prj.langcd.service.LangCdService;
import co.itrip.prj.member.service.MemberVO;
import co.itrip.prj.utpcd.service.UtpCdService;

@Controller
public class CbtUserController {
	
	@Autowired
	CbtUserService cuDao;
	@Autowired
	UtpCdService utpDao;
	@Autowired
	LangCdService langDao;
	

//	@RequestMapping("/cbtUserList.do")
//	public String cbtUserList(CbtUserVO vo, Model model) {
//		model.addAttribute("cbtList",cuDao.cbtUserList(vo));
//		return "cbtUser/cbtUserList";
//	}

	
	@RequestMapping("/cbtUserSelectOne.do")
	public String cbtUserSelectOne(CbtUserVO vo,Model model) {
		model.addAttribute("cbtOne", cuDao.cbtUserSelectOne(vo));
		return "cbtUser/cbtUserList";
	}
	
	@GetMapping("/cbtUserInsertForm.do")
	public String cbtUserInsertForm(Model model) {
		model.addAttribute("utpCdList", utpDao.utpCdList());
		model.addAttribute("langCdList", langDao.langCdList());
		return "cbtUser/cbtUserInsertForm";
	}
	
	@Value("${file.dir}")
	private File fileDir;
	
	@PostMapping("/cbtUserInsert.do")
	public String cbtUserInsert(CbtUserVO vo, Model  model, MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		/*
		 * if (!file.getOriginalFilename().isEmpty()) { String projectPath =
		 * System.getProperty("user.dir")+"/src/main/resources/static/files"; //프로젝트 경로
		 * 
		 * UUID uuid = UUID.randomUUID(); String filename = uuid + "_" +
		 * file.getOriginalFilename(); File saveFile = new File(projectPath, filename);
		 * file.transferTo(saveFile); vo.setAttach(filename); String path = "/files/" +
		 * filename; vo.setAttachDir(path); }
		 */
		
		String saveFolder = ("");
		File sfile = new File(saveFolder);
		String oFileName = file.getOriginalFilename();
		if(!oFileName.isEmpty()) {
			String sFileName = UUID.randomUUID().toString()+oFileName.substring(oFileName.lastIndexOf("."));
			String path = fileDir+"/"+sFileName;
			file.transferTo(new File(path));
			vo.setAttach(oFileName); 
			vo.setAttachDir(saveFolder+"/"+sFileName);
		}
		
		cuDao.cbtUserInsert(vo);
	
		model.addAttribute("langCdList",langDao.langCdList());
		return "cbtUser/cbtUserMain";
		//return "cbtUserMain.do";
	}
}

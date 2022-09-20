package co.itrip.prj.guide.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.multipart.MultipartFile;

import co.itrip.prj.guide.service.GuideService;
import co.itrip.prj.guide.service.GuideVO;

@Controller
public class GuideController {
	
	@Autowired
	private GuideService gudao;
	
	int r = 0;
	
	// 가이드 insert & 파일처리
	@PostMapping("/guideInsert.do")
	public String guideInsert(GuideVO vo, Model model, MultipartFile file) throws IllegalStateException, IOException {
		if(!file.getOriginalFilename().isEmpty()) {
			String projectpath = System.getProperty("user.dir")+"/src/main/resources/static/files"; // user.dir은 프로젝트 경로를 담아주게 된다. 
			UUID uuid = UUID.randomUUID(); // 랜덤으로 이름생성
			String filename = uuid+"_"+file.getOriginalFilename(); // 파일이름은 UUID에 있는 랜덤값 + 원래 파일이름으로 설정된다.
			File saveFile = new File(projectpath,filename);
			file.transferTo(saveFile);
			vo.setAttach(filename);
			vo.setAttachDir("/files/"+filename);
		}
		
		    gudao.guideInsert(vo);
					
		return "member/mypage";
	}

}

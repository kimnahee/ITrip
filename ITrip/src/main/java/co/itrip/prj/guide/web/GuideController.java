package co.itrip.prj.guide.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.itrip.prj.guide.mapper.GuideMapper;
import co.itrip.prj.guide.service.GuideVO;

@Controller
public class GuideController {
	
	@Autowired
	GuideMapper gudao;
	
	int r = 0;
	
	@PostMapping("/guideInsert.do")
	public String guideInsert(GuideVO vo, Model model, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		String saveFolder = "c://fileUpload"; // 저장할 공간 폴더명
		
		String orignalFileName = file.getOriginalFilename(); // 넘어온 파일명
		
		if(!orignalFileName.isEmpty()) {
			
			// 파일명 충돌방지를 위해서 랜덤 파일명 돌리기
			String saveFileName = UUID.randomUUID().toString() + orignalFileName.substring(orignalFileName.lastIndexOf('.'));
			
			// 파일을 물리적 위치에 저장
			file.transferTo(new File(saveFolder, saveFileName));
			
			vo.setAttach(orignalFileName);
			vo.setAttachDir(saveFolder + File.separator + saveFileName);
			
		}
		r = gudao.guideInsert(vo);
		if(r>0) {
			r++;
		}
		model.addAttribute("r", r);
		return "member/mypage";
	}

}

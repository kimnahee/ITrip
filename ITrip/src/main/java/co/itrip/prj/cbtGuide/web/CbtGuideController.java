package co.itrip.prj.cbtGuide.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.itrip.prj.cbtGuide.service.CbtGuideService;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.CbtKeywordVO;
import co.itrip.prj.cbtGuide.service.MyCbtHderVO;
import co.itrip.prj.cbtGuide.service.MyCbtLongVO;
import co.itrip.prj.gtpcd.service.GtpCdService;
import co.itrip.prj.langcd.service.LangCdService;

/**
* 가이드CBT 제어하는 곳
* @author 김하은
* @date 2022.09.19 
* @version 1.5
*/
@Controller
public class CbtGuideController {
	@Autowired
	private CbtGuideService cgDao;
	@Autowired
	private GtpCdService gtpDao;
	@Autowired
	private LangCdService langDao;
	
	/* 가이드 CBT 메인화면 */
	@RequestMapping("/cbtGuideMain.do")
	public String cbtGuideMain(Model model) {
		model.addAttribute("cbtList", cgDao.cbtGuideList()); // 모든 문제 출력
	    model.addAttribute("gtpCdList", gtpDao.gtpCdList()); // 모든 타입코드 출력
		model.addAttribute("langCdList", langDao.langCdList()); //모든 언어코드 출력
	    return "cbtGuide/cbtGuideMain";
	}
	
	/* 탭을 눌러 유형, 언어별로 선택 후 문제 리스트를 출력하는 화면 */
	@PostMapping("/cbtGuideListTab.do")
	public String cbtGuideListTab(CbtGuideVO vo, Model model, HttpServletRequest request) {
		vo.setGtpCd(request.getParameter("gtpCd")); // 요청된 파라미터 값 유형코드 담음
		vo.setLangCd(request.getParameter("langCd")); // 요청된 파라미터 값 언어코드 담음
		//변수 생성
		String tCd = request.getParameter("gtpCd");
		String lCd = request.getParameter("langCd");
		
		model.addAttribute("cbtList", cgDao.cbtGuideListTab(vo));
		model.addAttribute("tCd", tCd); 
		model.addAttribute("lCd", lCd);
		return "cbtGuide/cbtGuideListTab";
	}
	
	/* 가이드가 문제 등록 폼 */
	@GetMapping("/cbtGuideInsertForm.do")
	public String cbtGuideInsertForm(Model model) {
	    model.addAttribute("gtpCdList", gtpDao.gtpCdList());
		model.addAttribute("langCdList", langDao.langCdList());
		return "cbtGuide/cbtGuideInsertForm";
	}
	
	/* 가이드가 문제 등록 */ 
	@PostMapping("/cbtGuideInsert.do")
	public String cbtGuideInsert(CbtGuideVO vo, CbtKeywordVO kvo, Model model,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		
		// 파일처리 
		String projectPath = System.getProperty("user.dir")+"/src/main/resources/static/files"; //프로젝트 경로
		UUID uuid = UUID.randomUUID(); // 랜덤으로 고유의 값 생성
		
		if(!file.isEmpty()) { //파일이 등록되어있다면...
			
			String filename= uuid +"_"+file.getOriginalFilename(); //파일명 충돌방지를 위한 파일별명만듦
			File saveFile = new File(projectPath, filename);
			//파일 물리적 위치에 저장
			file.transferTo(saveFile);
			vo.setAttach(filename);
			String path ="/files/"+filename;
			vo.setAttachDir(path);
		}
		
		cgDao.cbtGuideInsert(vo); //파일 처리를 진행 후 등록함

		return "redirect:/cbtGuideMain.do";
	}
	/* 사용자가 입력한 값 등록 */
	@PostMapping("/myCbtHderInsert.do")
	public String myCbtHderInsert(MyCbtHderVO mvo, CbtGuideVO vo, Model model, HttpServletRequest request, Principal prin) {
		 
		cgDao.myCbtHderInsert(mvo); // 등록 
		//int mcNo = Integer.parseInt(request.getParameter("mcNo"));
		model.addAttribute("myCbtListS", cgDao.myCbtHderList(mvo)); // 사용자가 푼 문제 출력
		vo.setMcNo(mvo.getMcNo());
		model.addAttribute("ListO", cgDao.cbtGuideListO(vo)); // 사용자가 푼 정답문제 출력
		model.addAttribute("ListX", cgDao.cbtGuideListX(vo)); // 사용자가 푼 오답문제 출력
		System.out.println("======controller vo.getMcNo : "+vo.getMcNo());
		
		return "cbtGuide/cbtScoreList";
	};
	/* 서술형 리스트 출력 */
	@PostMapping("/cbtGuideListTabLong.do")
	public String cbtGuideListTabLong(CbtGuideVO vo, Model model, HttpServletRequest request) {
		vo.setGtpCd(request.getParameter("gtpCd")); // 요청된 파라미터 값 유형코드 담음
		vo.setLangCd(request.getParameter("langCd")); // 요청된 파라미터 값 언어코드 담음
		//변수 생성
		String tCd = request.getParameter("gtpCd");
		String lCd = request.getParameter("langCd");
		
		model.addAttribute("cbtList", cgDao.cbtGuideListTab(vo));
		model.addAttribute("tCd", tCd); 
		model.addAttribute("lCd", lCd);
		return "cbtGuide/cbtGuideListTabLong";
	}
	
	
	
}

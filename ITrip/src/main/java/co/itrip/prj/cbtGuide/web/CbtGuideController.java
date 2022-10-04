package co.itrip.prj.cbtGuide.web;

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

import co.itrip.prj.cbtGuide.service.CbtGuideService;
import co.itrip.prj.cbtGuide.service.CbtGuideVO;
import co.itrip.prj.cbtGuide.service.CbtKeywordVO;
import co.itrip.prj.cbtGuide.service.MyCbtHderVO;
import co.itrip.prj.cmmncd.service.CmmnCdService;
import co.itrip.prj.gtpcd.service.GtpCdService;

/**
* 가이드CBT 제어하는 곳
* @author 김하은
* @date 2022.09.19 
* @version 1.8
*/
@Controller
public class CbtGuideController {
	@Autowired
	private CbtGuideService cgDao;
	@Autowired
	private GtpCdService gtpDao;
	//@Autowired
	//private LangCdService langDao;
	@Autowired
	private CmmnCdService cdDao;
	
	/* 가이드 CBT 메인화면 */
	@RequestMapping("/cbtGuideMain.do")
	public String cbtGuideMain(Model model) {
		model.addAttribute("cbtList", cgDao.cbtGuideList()); // 모든 문제 출력
	    model.addAttribute("gtpCdList", gtpDao.gtpCdList()); // 모든 타입코드 출력
		model.addAttribute("langCdList", cdDao.cdList("L")); //모든 언어코드 출력 -- 수정했음 확인요망
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
		model.addAttribute("langCdList", cdDao.cdList("L")); //모든 언어코드 출력 -- 수정했음 확인요망
		return "cbtGuide/cbtGuideInsertForm";
	}
	@Value("${file.dir}")
	private File fileDir;
	
	/* 가이드가 문제 등록 */ 
	@PostMapping("/cbtGuideInsert.do")
	public String cbtGuideInsert(CbtGuideVO vo, CbtKeywordVO kvo, Model model,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		
		// 파일처리 (static 폴더로 업로드 됨)
		/*String projectPath = System.getProperty("user.dir")+"/src/main/resources/static/files"; //프로젝트 경로
		UUID uuid = UUID.randomUUID(); // 랜덤으로 고유의 값 생성
		
		if(!file.isEmpty()) { //파일이 등록되어있다면...
			String filename= uuid +"_"+file.getOriginalFilename(); //파일명 충돌방지를 위한 파일별명만듦
			File saveFile = new File(projectPath, filename);
			//파일 물리적 위치에 저장
			file.transferTo(saveFile);
			vo.setAttach(filename);
			String path ="/files/"+filename;
			vo.setAttachDir(path);
		}*/
		
		// 파일처리 : C에 파일이 업로드 되도록 수정
		String saveFolder=("");
		File sfile = new File(saveFolder);
		String oFileName = file.getOriginalFilename();
		if(!oFileName.isEmpty()) {
			String sFileName = UUID.randomUUID().toString()+oFileName.substring(oFileName.lastIndexOf("."));
			String path = fileDir+"/cbtGuide/"+sFileName;
		    file.transferTo(new File(path));
		    vo.setAttach(oFileName);
		    vo.setAttachDir(saveFolder+"/cbtGuide/"+sFileName);
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
	
	public String cbtGuideListTabLong(CbtGuideVO vo, Model model, HttpServletRequest request ) {
		
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
	
	/* 로그인한 가이드의 문제 출제 목록 + 페이징 처리 */
	@GetMapping("/cbtGuideMyList.do")
	public String cbtGuideMyList(Principal prin, CbtGuideVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		
		vo.setMemberId(prin.getName()); //로그인된 사용자 정보 가져와 담기
		//페이징 처리
		PageHelper.startPage(pageNum, pageSize); 
		// 리턴 된 여러값을 담기위해서는 service에서 값을 담아서 for문 돌려서 처리를 해야함
		List<CbtGuideVO> list = cgDao.cbtGuideMyList(vo);
		//model.addAttribute("myList", list);
		
		model.addAttribute("pageInfo", PageInfo.of(list));
		return "cbtGuide/cbtGuideMyList";
	}
	
	/* 문제 상세 정보 */
	@PostMapping("/cbtGuideListOne.do")
	public String cbtGuideListOne(CbtGuideVO vo, CbtKeywordVO kVo, Model model, HttpServletRequest request) {
		model.addAttribute("myList", cgDao.cbtGuideListOne(vo));
		model.addAttribute("keyword", cgDao.keywordList(kVo));
		return "cbtGuide/cbtGuideListOne";
	}
	/* 문제 수정 폼 */
	@PostMapping("/cbtGuideUpdateForm.do")
	public String cbtGuideUpdateForm(CbtGuideVO vo,  CbtKeywordVO kVo, Model model, HttpServletRequest request) { 
			//Get으로 어케넘겨....!!!! @RequestParam int cbtNo, @RequestParam String gtpCd, @RequestParam String langCd) 
		//System.out.println("==========================cbtNo : "+cbtNo);
		//System.out.println("==========================gtpCd : "+gtpCd);
		//System.out.println("==========================langCd : "+langCd);
		model.addAttribute("myList", cgDao.cbtGuideListOne(vo));
		model.addAttribute("keyword", cgDao.keywordList(kVo));
		return "cbtGuide/cbtGuideUpdateForm";
	}
	
	/* 문제 수정 */
	@PostMapping("/cbtGuideUpdate.do")
	public String cbtGuideUpdate(CbtGuideVO vo, CbtKeywordVO kVo, HttpServletRequest request) {
		
		cgDao.cbtGuideUpdate(vo);
		return "redirect:/cbtGuideMyList";
	}
	
	/* 문제 삭제 */
	@GetMapping("/cbtGuideDelete.do")
	public String cbtGuideDelete(CbtGuideVO vo, HttpServletRequest request) {
		vo.setCbtNo(Integer.parseInt(request.getParameter("cbtNo")));
		cgDao.cbutGuideDelet(vo);
		return "redirect:/cbtGuideMain.do";
	}
	/* 즐겨 찾기 */
	@GetMapping("/bookmark.do")
	public String bookmark(Principal prin) {
		//vo.setMemberId(prin.getName()); //로그인된 사용자 정보 가져와 담기
		return "bookmark/bookmark";
	}
	
}

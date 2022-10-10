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
import org.springframework.web.bind.annotation.ModelAttribute;
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

/**
* 가이드CBT 제어하는 곳
* @author 김하은
* @date 2022.09.19 
* @version 1.8
*/
@Controller
public class CbtGuideController {
	
	@Value("${file.dir}")
	private File fileDir;
	
	@Autowired
	private CbtGuideService cgService;
	@Autowired
	private CmmnCdService cdService;
	
	/* 가이드 CBT 메인화면 */
	@RequestMapping("/cbtGuideMain.do")
	public String cbtGuideMain(Model model) {
		model.addAttribute("cbtList", cgService.cbtGuideList()); // 모든 문제 출력
	    model.addAttribute("gtpCdList", cdService.cdList("G")); // 모든 타입코드 출력  
		model.addAttribute("langCdList", cdService.cdList("L")); //모든 언어코드 출력 
	    return "cbtGuide/cbtGuideMain";
	}
	
	/* 탭을 눌러 유형, 언어별로 선택 후 문제 리스트를 출력하는 화면 */
	@PostMapping("/cbtGuideListTab.do")
	public String cbtGuideListTab(Model model,  CbtGuideVO vo, HttpServletRequest request) {
		model.addAttribute("cbtList", cgService.cbtGuideListTab(vo));
		return "cbtGuide/cbtGuideListTab";
	}
	
	/* 가이드가 문제 등록 폼 */
	@GetMapping("/cbtGuideInsertForm.do")
	public String cbtGuideInsertForm(Model model) {
	    model.addAttribute("gtpCdList",  cdService.cdList("G"));
		model.addAttribute("langCdList", cdService.cdList("L"));
		return "cbtGuide/cbtGuideInsertForm";
	}

	
	/* 가이드가 문제 등록 */ 
	@PostMapping("/cbtGuideInsert.do")
	public String cbtGuideInsert(CbtGuideVO vo, CbtKeywordVO kvo, Model model, MultipartFile file) throws IllegalStateException, IOException {
		
		// 파일처리 : C에 파일이 업로드 되도록 수정
		String oFileName=file.getOriginalFilename();
		if(!oFileName.isEmpty()) {
			String sFileName = UUID.randomUUID().toString()+oFileName.substring(oFileName.lastIndexOf("."));
			String path = fileDir+"/cbtGuide/"+sFileName;
		    file.transferTo(new File(path));
		    vo.setAttach(oFileName);
		    vo.setAttachDir(sFileName);
		}
		
		cgService.cbtGuideInsert(vo); //파일 처리를 진행 후 등록함

		return "redirect:/cbtGuideMain.do";
	}
	
	/* 사용자가 입력한 값 등록 */
	@PostMapping("/myCbtHderInsert.do")
	public String myCbtHderInsert(MyCbtHderVO mvo, CbtGuideVO vo, Model model, HttpServletRequest request, Principal prin) {
		 
		cgService.myCbtHderInsert(mvo); // 등록 
		
		model.addAttribute("myCbtListS", cgService.myCbtHderList(mvo)); // 사용자가 푼 문제 출력
		vo.setMcNo(mvo.getMcNo());
		model.addAttribute("ListO", cgService.cbtGuideListO(vo)); // 사용자가 푼 정답문제 출력
		model.addAttribute("ListX", cgService.cbtGuideListX(vo)); // 사용자가 푼 오답문제 출력
		
		return "cbtGuide/cbtScoreList";
	};
	
	/* 서술형 리스트 출력 */
	@PostMapping("/cbtGuideListTabLong.do")
	public String cbtGuideListTabLong(CbtGuideVO vo, Model model, HttpServletRequest request ) {
        //CbtGuideVO에 담긴 gtpCd와 langCd를 html에 쓰려면 cbtGuideVO.gtpCd 방식으로 사용하면 된다.
		//html에서 CBTGuideVO를 사용하기 너무 번거로울 경우 , @ModelAttribute 설정해서 사용가능
		//Controller에서 값을 다시 변수에 담아 보낼 필요 없음
		model.addAttribute("cbtList", cgService.cbtGuideListTab(vo));
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
		List<CbtGuideVO> list = cgService.cbtGuideMyList(vo);
		
		model.addAttribute("pageInfo", PageInfo.of(list));
		return "cbtGuide/cbtGuideMyList";
	}
	
	/* 문제 상세 정보 */
	@PostMapping("/cbtGuideListOne.do")
	public String cbtGuideListOne(CbtGuideVO vo, CbtKeywordVO kVo, Model model, HttpServletRequest request) {
		model.addAttribute("myList", cgService.cbtGuideListOne(vo));
		model.addAttribute("keyword", cgService.keywordList(kVo));
		return "cbtGuide/cbtGuideListOne";
	}
	
	/* 문제 수정 폼 */
	@PostMapping("/cbtGuideUpdateForm.do")
	public String cbtGuideUpdateForm(CbtGuideVO vo,  CbtKeywordVO kVo, Model model, HttpServletRequest request) { 
		model.addAttribute("myList", cgService.cbtGuideListOne(vo));
		model.addAttribute("keyword", cgService.keywordList(kVo));
		return "cbtGuide/cbtGuideUpdateForm";
	}
	
	/* 문제 수정 */
	@PostMapping("/cbtGuideUpdate.do")
	public String cbtGuideUpdate(CbtGuideVO vo, CbtKeywordVO kVo, HttpServletRequest request,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
	    //CbtGuideVO fVo = cgService.cbtGuideListOne(vo);
	    
	    //File file = new File("C:/Temp/cbtGuide/"+fVo.getAttachDir());
		
		// 파일처리 수정해야함 ! 파일이 지워졌다가 다시 등록되도록...
		// 파일처리 : C에 파일이 업로드 되도록 수정
		String oFileName=file.getOriginalFilename();
		if(!oFileName.isEmpty()) {
			String sFileName = UUID.randomUUID().toString()+oFileName.substring(oFileName.lastIndexOf("."));
			String path = fileDir+"/cbtGuide/"+sFileName;
		    file.transferTo(new File(path));
		    vo.setAttach(oFileName);
		    vo.setAttachDir(sFileName);
		}
		
		cgService.cbtGuideUpdate(vo); //파일 처리 후 수정
		return "redirect:/cbtGuideMyList.do";
	}
	
	/* 문제 삭제 */
	@GetMapping("/cbtGuideDelete.do")
	public String cbtGuideDelete(CbtGuideVO vo, HttpServletRequest request) {
		cgService.cbutGuideDelet(vo);
		return "redirect:/cbtGuideMain.do";
	}
	/* 즐겨찾기 목록*/
	@GetMapping("/bookmarkList.do")
	public String bookmarkList(CbtGuideVO vo,Principal prin, Model model, HttpServletRequest request) {
		vo.setMemberId(prin.getName()); //로그인된 사용자 정보 가져와 담기
		model.addAttribute("bookmark", cgService.bookmarkList(vo));
		
		System.out.println("============================================vo :"+vo);
		return "bookmark/bookmarkList";
	}
	
	
}

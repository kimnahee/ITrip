package co.itrip.prj.admin.web;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import co.itrip.prj.admin.service.AdminService;
import co.itrip.prj.cmmncd.service.CmmnCdService;
import co.itrip.prj.consult.service.ConsultVO;
import co.itrip.prj.guide.service.GuideService;
import co.itrip.prj.guide.service.GuideVO;
import co.itrip.prj.iclass.service.ClassVO;
import co.itrip.prj.member.service.MemberVO;


@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService; // 1:1 상담서비스
	
	@Autowired
	private CmmnCdService cdService; // 공통코드 서비스
	
	@Value("${file.dir}")
	private String fileDir;

	//소정 - admin-Class 승인신청리스트
	@GetMapping("/appClass.do") 
	public String appClass(ClassVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "5") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(adminService.classList(vo)));
		
		// job카테고리 뿌려주기
		model.addAttribute("joblist", cdService.jobCdList());
		return "admin/appclass";
	}
	
	//소정 - admin-Consult 승인신청리스트
	@GetMapping("/appConsult.do") 
	public String appConsult(ConsultVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "5") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(adminService.ConsultList(vo)));
		return "admin/appconsult";
	}
	
	//소정 - class 승인처리
	@PostMapping("/classUpdate.do")
	@ResponseBody
	public int classUpdate(ClassVO vo) {
		return adminService.classUpdate(vo);
	}
	
	//소정 - consult 승인처리
	@PostMapping("/consultUpdate.do")
	@ResponseBody
	public int consultUpdate(ConsultVO vo) {
		return adminService.consultUpdate(vo);
	}
	
	// 상담 검색
	@GetMapping("/consultSearch.do")
	@ResponseBody
	private List<ConsultVO> consultSearch(@RequestParam("key") String key,
			@RequestParam("val") String val, Model model, ConsultVO vo) {
		vo.setVal(val);
		vo.setKey(key);
		return adminService.consultSearch(vo);
	}
	
	// 클래스 검색
	@GetMapping("/dateSearch.do")
	@ResponseBody
	private List<ClassVO> dateSearch(@RequestParam("sdate") String sdate,
			@RequestParam("edate") String edate, Model model, ClassVO vo) {
		vo.setSdate(sdate);
		vo.setEdate(edate);
		return adminService.classSearch(vo);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//경아 - 가이드신청리스트
	@GetMapping("/memberAuthList.do")
	public String memberAuthList(GuideVO vo,Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(adminService.memberAuthList(vo)));
		return "admin/memberAuthList";
	}

	//경아 - 회원리스트
	@GetMapping("/memberList.do")
	public String memberList(MemberVO vo,Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(adminService.memberList(vo)));
		return "admin/memberList";
	}

	//경아 - 권한별 회원리스트
	@GetMapping("/memberListOf.do")
	@ResponseBody
	public PageInfo<MemberVO> memberListOf(MemberVO vo,Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return  PageInfo.of(adminService.memberListOf(vo));
	}
	
	//경아 - 회원->가이드 권한수정
	@PostMapping("/memberAuthUpdate.do")
	@ResponseBody
	public int memberAuthUpdate(GuideVO vo,MemberVO mvo) {
		mvo.setMemberId(vo.getGuideId());
		adminService.memberAuthUpdateTo(mvo);
		return  adminService.memberAuthUpdate(vo);
	}
	
	

    //경아 - 파일 다운로드 처리
	 @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	 public void download(String fileName, HttpServletResponse response, HttpServletRequest request){
		
	        try {
	        	  String originFileName = URLDecoder.decode(fileName, "UTF-8");
	              String onlyFileName = originFileName.substring(originFileName.lastIndexOf("_") + 1);
	              File file = new File(fileDir, originFileName);

	              if(file.exists()) {
	                  String agent = request.getHeader("User-Agent");

	                  //브라우저별 한글파일 명 처리
	                  if(agent.contains("Trident"))//Internet Explore
	                      onlyFileName = URLEncoder.encode(onlyFileName, "UTF-8").replaceAll("\\+", " ");
	                  else if(agent.contains("Edge")) //Micro Edge
	                      onlyFileName = URLEncoder.encode(onlyFileName, "UTF-8");
	                  else //Chrome
	                      onlyFileName = new String(onlyFileName.getBytes("UTF-8"), "ISO-8859-1");
	                  //브라우저별 한글파일 명 처리

	                  response.setHeader("Content-Type", "application/octet-stream");
	                  response.setHeader("Content-Disposition", "attachment; filename=" + onlyFileName);

	                  InputStream is = new FileInputStream(file);
	                  OutputStream os = response.getOutputStream();

	                  int length;
	                  byte[] buffer = new byte[1024];

	                  while( (length = is.read(buffer)) != -1){
	                      os.write(buffer, 0, length);
	                  }

	                  os.flush();
	                  os.close();
	                  is.close();
	              }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }
	 
	 
}

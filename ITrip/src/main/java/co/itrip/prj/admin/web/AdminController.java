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
	private AdminService dao;

	
	@GetMapping("/appClass.do") // admin-Class 승인
	public String appClass(ClassVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "5") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(adminService.classList(vo)));
		return "admin/appclass";
	}
	

	@GetMapping("/appConsult.do") // admin-Consult 승인
	public String appConsult(ConsultVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "5") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		// vo.setStateCd("1");
		model.addAttribute("pageInfo", PageInfo.of(adminService.ConsultList(vo)));
		return "admin/appconsult";
	}
	
	
	@GetMapping("/memberAuthList.do")
	public String memberAuthList(GuideVO vo,Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(dao.memberAuthList(vo)));
		return "admin/memberAuthList";
	}


	@GetMapping("/memberList.do")
	public String memberList(MemberVO vo,Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		model.addAttribute("pageInfo", PageInfo.of(dao.memberList(vo)));
		return "admin/memberList";
	}


	@GetMapping("/memberListOf.do")
	@ResponseBody
	public PageInfo<MemberVO> memberListOf(MemberVO vo,Model model, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return  PageInfo.of(dao.memberListOf(vo));
	}
	
	@PostMapping("/memberAuthUpdate.do")
	@ResponseBody
	public int memberAuthUpdate(GuideVO vo,MemberVO mvo) {
		mvo.setMemberId(vo.getGuideId());
		dao.memberAuthUpdateTo(mvo);
		return dao.memberAuthUpdate(vo);
	}
	
	

    // 파일 다운로드 처리
	 @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	 public void download(String fileName, HttpServletResponse response, HttpServletRequest request){

	        try {
	        	  String originFileName = URLDecoder.decode(fileName, "UTF-8");
	              String onlyFileName = originFileName.substring(originFileName.lastIndexOf("_") + 1);
	              File file = new File(System.getProperty("user.dir")+"/src/main/resources/static", originFileName);

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

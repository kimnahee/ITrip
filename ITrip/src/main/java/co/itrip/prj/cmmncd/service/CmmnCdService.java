package co.itrip.prj.cmmncd.service;

import java.util.List;

public interface CmmnCdService {
	List<CmmnCdVO> careerCdList(); // 경력 공통코드 리스트
	List<CmmnCdVO> dutyCdList(); // 직무 공통코드 리스트
	List<CmmnCdVO> jobCdList(); // 업무 공통코드 리스트(Class,consult)
	
	String cdNameList(String cdIni, String cdNo); // 이니셜과 코드넘버로 네임 리스트 출력

	

}

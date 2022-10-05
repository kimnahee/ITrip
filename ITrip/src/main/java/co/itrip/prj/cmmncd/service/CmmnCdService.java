package co.itrip.prj.cmmncd.service;

import java.util.List;

public interface CmmnCdService {
	List<CmmnCdVO> cdList(String a); // 경력 공통코드 리스트
	List<CmmnCdVO> careerCdList(); // 경력 공통코드 리스트
	List<CmmnCdVO> dutyCdList(); // 직무 공통코드 리스트
	List<CmmnCdVO> jobCdList(); // 업무 공통코드 리스트(Class,consult)
	

	

}

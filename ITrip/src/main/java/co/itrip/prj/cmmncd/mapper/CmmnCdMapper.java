package co.itrip.prj.cmmncd.mapper;

import java.util.List;

import co.itrip.prj.cmmncd.service.CmmnCdVO;

public interface CmmnCdMapper {
	List<CmmnCdVO> careerCdList(); // 경력 공통코드 리스트
	List<CmmnCdVO> dutyCdList(); // 직무 공통코드 리스트
	List<CmmnCdVO> jobCdList(); // 업무 공통코드 리스트(Class,consult)
	
	String cdNameList(String cdIni, String cdNo); // 이니셜과 코드넘버로 네임 리스트 출력
}

package co.itrip.prj.cmmncd.mapper;

import java.util.List;

import co.itrip.prj.cmmncd.service.CmmnCdVO;

public interface CmmnCdMapper {
	List<CmmnCdVO> careerCdList(); // 경력 공통코드 리스트
	List<CmmnCdVO> dutyCdList(); // 직무 공통코드 리스트
}

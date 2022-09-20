package co.itrip.prj.cmmncd.mapper;

import java.util.List;

import co.itrip.prj.cmmncd.service.CmmnCdVO;

public interface CmmnCdMapper {
	List<CmmnCdVO> careerCdList();
	List<CmmnCdVO> dutyCdList();
}

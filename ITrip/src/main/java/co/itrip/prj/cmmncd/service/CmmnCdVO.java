package co.itrip.prj.cmmncd.service;

import lombok.Data;

@Data
public class CmmnCdVO {
	 
	// 공통코드 VO
	private String cdIni; // 주코드
	private String cdNo;  // 부코드 
	private String cdName; // 설명
}

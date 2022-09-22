package co.itrip.prj.cmmncd.service;

import lombok.Data;
/**
 * 
 * @author 박은지
 *
 */

@Data
public class CmmnCdVO {
	 /**
	  * 2022.09.20 박은지 작성
	  * 2022.09.21 박은지 순번열 추가
	  */
	// 공통코드 VO
	private String cdIni; // 주코드
	private String cdNo;  // 부코드 
	private String cdName; // 설명
	private String cd_sn; // 순번
}

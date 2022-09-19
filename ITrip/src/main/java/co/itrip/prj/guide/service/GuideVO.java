package co.itrip.prj.guide.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class GuideVO {
	
	// 가이드 테이블
	private String guideId;
	private String career;
	private String dc;
	private String duty;
	private String attach;
	private String attachDir;
	private String stateCd;	
	private Date dt;
	private int star;
	
	

}

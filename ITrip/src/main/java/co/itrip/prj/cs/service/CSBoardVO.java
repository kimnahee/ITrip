package co.itrip.prj.cs.service;

import java.sql.Date;

import lombok.Data;

@Data
public class CSBoardVO {
	private int csNo;
	private String title;
	private String content;
	private String memberId;
	private String nick;
	private Date dt;
	private int hit;
	private int orgNo;
	private int groupOdr;
	private int groupLyr;
	private String ctgry;
}

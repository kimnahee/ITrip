package co.itrip.prj.community.service;


import java.sql.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int reNo;
	private int comNo;
	private String content;
	private String memberId;
	private String nick;
	private Date dt;
}

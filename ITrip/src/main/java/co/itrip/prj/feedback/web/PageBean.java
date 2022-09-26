package co.itrip.prj.feedback.web;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;

import lombok.Data;

@Data
public class PageBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	 private long total; //    
	 private List<T> list; //   
	 private int pageNum; //   
	 private int pageSize; //     
	 private int pages; //    
	 private int size; //      <=pageSize

	 public PageBean(List<T> list){
	 if (list instanceof Page){
	  Page<T> page = (Page<T>) list;
	  this.pageNum = page.getPageNum();
	  this.pageSize = page.getPageSize();
	  this.total = page.getTotal();
	  this.pages = page.getPages();
	  this.list = page;
	  this.size = page.size();
	 }
	}
}

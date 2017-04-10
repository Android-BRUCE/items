package cn.zrcx.cutpage;

import java.util.List;

import cn.zrcx.action.form.RoleDimForm;

public class PageView<T> {
	


	private int currentPage=1;
	private int pageSize;
	private long totalRecords;
	private long totalPages;
	private long currentSize;
	

	private String condition; 
	private String result;
	
	private String sort;
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public long getCurrentSize() {
		return currentSize;
	}
	public void setCurrentSize(long currentSize) {
		this.currentSize = currentSize;
	}

	private List<T> records;
	
	public PageView(int currentPage,int pageSize)
	{	
		
		this.currentPage=(currentPage-1)*pageSize;
		this.pageSize=pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
		this.totalPages=this.totalRecords%this.pageSize==0? this.totalRecords/this.pageSize : this.totalRecords/this.pageSize+1;
	}
	public long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
		
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	
	
	
	
	

}

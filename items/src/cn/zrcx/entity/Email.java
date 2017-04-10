package cn.zrcx.entity;

import java.util.Date;



public class Email {
	private int email_id;
	private int email_state;
	private int email_sendman;
	private int email_receive;
	private String email_title;
	private String email_accessory ;
	private String email_content;
	private Date email_senddate;
	private String email_senDate;
	private String receivename;
	private String sendman;
	public String getSendman() {
		return sendman;
	}
	public void setSendman(String sendman) {
		this.sendman = sendman;
	}
	private int currentPage=1;
	private int pageSize;
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
	public String getEmail_senDate() {
		return email_senDate;
	}
	public void setEmail_senDate(String email_senDate) {
		this.email_senDate = email_senDate;
	}
	public String getReceivename() {
		return receivename;
	}
	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}
	public Email(){};
	public Email(int email_state, int email_sendman, int email_receive,
			String email_title, String email_accessory, String email_content,
			Date email_senddate) {
		super();
		this.email_sendman = email_sendman;
		this.email_receive = email_receive;
		this.email_title = email_title;
		this.email_accessory = email_accessory;
		this.email_content = email_content;
		this.email_senddate = email_senddate;
	}
	public int getEmail_id() {
		return email_id;
	}
	public void setEmail_id(int email_id) {
		this.email_id = email_id;
	}
	public int getEmail_state() {
		return email_state;
	}
	public void setEmail_state(int email_state) {
		this.email_state = email_state;
	}
	public int getEmail_sendman() {
		return email_sendman;
	}
	public void setEmail_sendman(int email_sendman) {
		this.email_sendman = email_sendman;
	}
	public int getEmail_receive() {
		return email_receive;
	}
	public void setEmail_receive(int email_receive) {
		this.email_receive = email_receive;
	}
	public String getEmail_title() {
		return email_title;
	}
	public void setEmail_title(String email_title) {
		this.email_title = email_title;
	}
	public String getEmail_accessory() {
		return email_accessory;
	}
	public void setEmail_accessory(String email_accessory) {
		this.email_accessory = email_accessory;
	}
	public String getEmail_content() {
		return email_content;
	}
	public void setEmail_content(String email_content) {
		this.email_content = email_content;
	}
	public Date getEmail_senddate() {
		return email_senddate;
	}
	public void setEmail_senddate(Date email_senddate) {
		this.email_senddate = email_senddate;
	}
	
	
}

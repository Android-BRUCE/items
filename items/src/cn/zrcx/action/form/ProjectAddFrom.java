package cn.zrcx.action.form;

import java.sql.Date;

public class ProjectAddFrom {
	private int i_id;
	private int c_id;
	private int e_id;
	private String i_name;
	private int i_number;
	private Date i_startdate;
	private Date i_builddate;
	private String i_cost;
	private int i_grade;
	private Date i_finishdate;
	private String i_comment;
	private int i_state;//1,2,3½ô¼±£¬Ò»°ã£¬Ôİ»º
	private java.util.Date i_update;
	
	
	
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public java.util.Date getI_update() {
		return i_update;
	}
	public void setI_update(java.util.Date i_update) {
		this.i_update = i_update;
	}
	public int getI_id() {
		return i_id;
	}
	public void setI_id(int i_id) {
		this.i_id = i_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getI_name() {
		return i_name;
	}
	public void setI_name(String i_name) {
		this.i_name = i_name;
	}
	public int getI_number() {
		return i_number;
	}
	public void setI_number(int i_number) {
		this.i_number = i_number;
	}
	public Date getI_startdate() {
		return i_startdate;
	}
	public void setI_startdate(Date i_startdate) {
		this.i_startdate = i_startdate;
	}
	public Date getI_builddate() {
		return i_builddate;
	}
	public void setI_builddate(Date i_builddate) {
		this.i_builddate = i_builddate;
	}
	public String getI_cost() {
		return i_cost;
	}
	public void setI_cost(String i_cost) {
		this.i_cost = i_cost;
	}
	public int getI_grade() {
		return i_grade;
	}
	public void setI_grade(int i_grade) {
		this.i_grade = i_grade;
	}
	public Date getI_finishdate() {
		return i_finishdate;
	}
	public void setI_finishdate(Date i_finishdate) {
		this.i_finishdate = i_finishdate;
	}
	public String getI_comment() {
		return i_comment;
	}
	public void setI_comment(String i_comment) {
		this.i_comment = i_comment;
	}
	public int getI_state() {
		return i_state;
	}
	public void setI_state(int i_state) {
		this.i_state = i_state;
	}
	
	
}
